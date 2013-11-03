package net.grosinger.bookmetasearch.loader;

import android.content.Context;
import android.util.Log;

import net.grosinger.bookmetasearch.book.Author;
import net.grosinger.bookmetasearch.book.Book;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by tony on 11/2/13.
 */
public class GoodreadsQuery extends Query {
    private String query;

    public GoodreadsQuery(Context context) {
        super(context);
    }

    @Override
    public void setQuery(String query) {
        Log.d(getClass().getSimpleName(), "Setting query: " + query);

        this.query = query;
    }

    @Override
    public List<Book> loadInBackground() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + query);

        if (query == null || query == "") {
            return null;
        }

        try {
            String key = "EJfEBt5xXWbOjoE0t78yUw";
            String url = "http://www.goodreads.com/search.xml?key=" + key + "&q=" + URLEncoder.encode(query, "UTF-8");
            Document response = performGetRequest(url);
            if (response != null) {
                List<Book> results = new ArrayList<Book>();

                NodeList works = response.getDocumentElement().getElementsByTagName("work");
                for (int i = 0; i < works.getLength(); i++) {
                    Node node = works.item(i);

                    String authorName = "";
                    long authorId = 0;
                    String title = "";
                    String large_img = "";
                    float avg_rating = 0f;
                    long bookId = 0;

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element workElement = (Element) node;

                        Element authorNameElement = (Element) workElement.getElementsByTagName("name").item(0);
                        authorName = authorNameElement.getFirstChild().getNodeValue().trim();

                        Element titleElement = (Element) workElement.getElementsByTagName("title").item(0);
                        title = titleElement.getFirstChild().getNodeValue().trim();

                        Element imageElement = (Element) workElement.getElementsByTagName("image_url").item(0);
                        large_img = imageElement.getFirstChild().getNodeValue().trim();

                        Element bookIdElement = (Element) workElement.getElementsByTagName("id").item(1);
                        bookId = Long.parseLong(bookIdElement.getFirstChild().getNodeValue().trim());

                        Element authorIdElement = (Element) workElement.getElementsByTagName("id").item(2);
                        authorId = Long.parseLong(bookIdElement.getFirstChild().getNodeValue().trim());

                        Element ratingElement = (Element) workElement.getElementsByTagName("average_rating").item(0);
                        avg_rating = Float.parseFloat(ratingElement.getFirstChild().getNodeValue().trim());
                    }

                    Author author = new Author.AuthorBuilder(authorId).setName(authorName).build();
                    Book book = new Book.BookBuilder(bookId).setTitle(title).setAvgRating(avg_rating).setLargeImg(large_img).setAuthor(author).build();
                    results.add(book);

                    Log.d(getClass().getSimpleName(), "Loaded book: " + book);
                }
                return results;
            } else {
                Log.e(getClass().getSimpleName(), "Search failed");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Really shouldn't have gotten here...
        return null;
    }

    private Document performGetRequest(String url) {
        Log.d(getClass().getSimpleName(), "Getting " + url);

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(conn.getInputStream());
            doc.getDocumentElement().normalize();

            conn.disconnect();
            return doc;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
