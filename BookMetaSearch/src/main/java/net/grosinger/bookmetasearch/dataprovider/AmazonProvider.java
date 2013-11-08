package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import com.ECS.client.jax.Item;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class AmazonProvider implements AvailabilityProvider {
    Gson gson;

    public AmazonProvider() {
        gson = new Gson();
    }

    @Override
    public List<AvailableBook> findInventory(Book book) {
        Log.d(getClass().getSimpleName(), "Finding inventory");

        String isbn = (book.getIsbn() != null) ? book.getIsbn() : book.getIsbn13();
        if (isbn == null || isbn.equals("")) {
            return null;
        }

        List<AvailableBook> books = new ArrayList<AvailableBook>();
        try {
            URL url = new URL("http://wiki.grosinger.net:8080/search?method=isbn&q=" + isbn);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
                List<Item> items = new ArrayList<Item>();
                reader.beginArray();
                while (reader.hasNext()) {
                    Item results = gson.fromJson(reader, Item.class);
                    items.add(results);
                }
                reader.endArray();
                reader.close();

                for (Item item : items) {
                    books.add(new AvailableBook(book, AvailableBook.Format.EBOOK, item.getItemLinks().getItemLink().get(0).getURL(), "Amazon"));
                }
            } else {
                Log.e(getClass().getSimpleName(), "Unable to complete request");
            }
        } catch (MalformedURLException e) {
            Log.e(getClass().getSimpleName(), "Invalid URL", e);
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "IOException", e);
        }
        return books;
    }
}
