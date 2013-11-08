package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import net.grosinger.bookmetasearch.book.Author;
import net.grosinger.bookmetasearch.book.Book;

import org.w3c.dom.CharacterData;
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
public class GoodreadsProvider implements MetadataProvider {

    private static final String BASE_URL = "http://www.goodreads.com/";

    private String apiKey;
    private String apiSecret;

    public GoodreadsProvider(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    @Override
    public List<Book> findBooks(String searchTerm) {
        Log.d(getClass().getSimpleName(), "Finding books");
        List<Book> results = new ArrayList<Book>();

        try {
            String url = BASE_URL + "search.xml?key=" + apiKey + "&q=" + URLEncoder.encode(searchTerm, "UTF-8");
            Document response = performGetRequest(url);
            if (response != null) {
                NodeList works = response.getDocumentElement().getElementsByTagName("work");
                for (int i = 0; i < works.getLength(); i++) {
                    Node node = works.item(i);

                    String authorName = "";
                    long authorId = 0;
                    String title = "";
                    String large_img = "";
                    float avg_rating = 0f;
                    String bookId = "";
                    String isbn = "";
                    String isbn13 = "";

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element workElement = (Element) node;

                        Element authorNameElement = (Element) workElement.getElementsByTagName("name").item(0);
                        authorName = authorNameElement.getFirstChild().getNodeValue().trim();

                        Element titleElement = (Element) workElement.getElementsByTagName("title").item(0);
                        title = titleElement.getFirstChild().getNodeValue().trim();

                        Element imageElement = (Element) workElement.getElementsByTagName("image_url").item(0);
                        large_img = imageElement.getFirstChild().getNodeValue().trim();

                        Element bookIdElement = (Element) workElement.getElementsByTagName("id").item(1);
                        bookId = bookIdElement.getFirstChild().getNodeValue().trim();

                        Element authorIdElement = (Element) workElement.getElementsByTagName("id").item(2);
                        authorId = Long.parseLong(bookIdElement.getFirstChild().getNodeValue().trim());

                        Element ratingElement = (Element) workElement.getElementsByTagName("average_rating").item(0);
                        avg_rating = Float.parseFloat(ratingElement.getFirstChild().getNodeValue().trim());
                    }

                    String url2 = BASE_URL + "book/show?key=" + apiKey + "&format=xml&id=" + bookId;
                    Document response2 = performGetRequest(url2);
                    if(response2 != null) {
                        Element bookElement = (Element) response2.getDocumentElement().getElementsByTagName("book").item(0);
                        Log.d(getClass().getSimpleName(), bookElement.getNodeName());


                        CharacterData isbnElement = (CharacterData) bookElement.getElementsByTagName("isbn").item(0).getFirstChild();
                        if(isbnElement != null) {
                            isbn = isbnElement.getData();
                        }

                        CharacterData isbn13Element = (CharacterData) bookElement.getElementsByTagName("isbn13").item(0).getFirstChild();
                        if(isbn13Element != null) {
                            isbn13 = isbn13Element.getData();
                        }
                    }

                    Author author = new Author.AuthorBuilder(authorId).setName(authorName).build();
                    Book book = new Book.BookBuilder(bookId, this).setTitle(title).setAvgRating(avg_rating).setLargeImg(large_img).setAuthor(author).setIsbn(isbn).setIsbn13(isbn13).build();
                    results.add(book);

                    Log.d(getClass().getSimpleName(), "Loaded book: " + book);
                }




            } else {
                Log.e(getClass().getSimpleName(), "Search failed");
            }
        } catch (UnsupportedEncodingException e) {
            Log.e(getClass().getSimpleName(), "Unsupported encoding exception", e);
        }

        return results;
    }

    @Override
    public List<Book> findBooks(Author author) {
        return null;
    }

    @Override
    public Author findAuthorByName(String authorName) {
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
