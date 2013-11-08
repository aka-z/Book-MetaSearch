package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import net.grosinger.bookmetasearch.book.Author;
import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 11/7/13.
 */
public class GoogleProvider implements MetadataProvider, AvailabilityProvider {
    @Override
    public List<Book> findBooks(String searchTerm) {
        try {
            searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
            String url = "https://www.googleapis.com/books/v1/volumes?q=" + searchTerm;
            JSONObject response = requestJson(url);
            List<Book> parsedResponse = responseToBooks(response);
            return parsedResponse;
            //return responseToBooks(requestJson(url));
        } catch (UnsupportedEncodingException e) {
            Log.e(getClass().getSimpleName(), "Unable to URL encode search terms", e);
        }
        return null;
    }

    @Override
    public List<Book> findBooks(Author author) {
        try {
            String searchTerm = URLEncoder.encode(author.getName(), "UTF-8");
            String url = "https://www.googleapis.com/books/v1/volumes?q=author:" + searchTerm;
            return responseToBooks(requestJson(url));
        } catch (UnsupportedEncodingException e) {
            Log.e(getClass().getSimpleName(), "Unable to URL encode search terms", e);
        }
        return null;
    }

    @Override
    public Author findAuthorByName(String authorName) {
        return null;
    }

    @Override
    public List<AvailableBook> findInventory(Book book) {
        return null;
    }

    private List<Book> responseToBooks(JSONObject results) {
        List<Book> books = new ArrayList<Book>();
        try {
            // TODO: Prevent one failed book from causing a return null
            // TODO: Make this more robust so one missing attribute doesn't cause whole book to fail

            JSONArray items = results.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                JSONObject volumeInfo = item.getJSONObject("volumeInfo");

                String id = item.getString("id");
                String title = volumeInfo.getString("title");
                String author_name = volumeInfo.getJSONArray("authors").getString(0);
                String publisher = volumeInfo.getString("publisher");
                String large_img = volumeInfo.getJSONObject("imageLinks").getString("thumbnail");
                String small_img = volumeInfo.getJSONObject("imageLinks").getString("smallThumbnail");
                double ave_rating = volumeInfo.getDouble("averageRating");
                String description = volumeInfo.getString("description");
                int page_count = volumeInfo.getInt("pageCount");

                String isbn = "";
                String isbn13 = "";
                JSONArray isbnNumbers = volumeInfo.getJSONArray("industryIdentifiers");
                for (int j = 0; j < isbnNumbers.length(); j++) {
                    JSONObject isbnItem = isbnNumbers.getJSONObject(j);
                    if (isbnItem.getString("type").equals("ISBN_10")) {
                        isbn = isbnItem.getString("identifier");
                    } else {
                        isbn13 = isbnItem.getString("identifier");
                    }
                }

                Author author = new Author.AuthorBuilder(0).setName(author_name).build();
                Book book = new Book.BookBuilder(item.getString("id"), this)
                        .setAuthor(author)
                        .setAvgRating(ave_rating)
                        .setDescription(description)
                        .setIsbn(isbn)
                        .setIsbn13(isbn13)
                        .setLargeImg(large_img)
                        .setSmallImg(small_img)
                        .setTitle(title)
                        .setNumPages(page_count)
                        .setPublisher(publisher)
                        .build();

                books.add(book);
            }
            return books;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject requestJson(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                InputStream in = con.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }

                return new JSONObject(sb.toString());
            }
        } catch (MalformedURLException e) {
            Log.e(getClass().getSimpleName(), "Invalid URL, aborting search", e);
        } catch (UnsupportedEncodingException e) {
            Log.e(getClass().getSimpleName(), "Invalid encoding, aborting search", e);
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(), "Invalid JSON or non-existent attribute, aborting", e);
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "IOException, aborting search", e);
        }
        return null;
    }
}
