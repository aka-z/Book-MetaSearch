package net.grosinger.bookmetasearch.loader;

import android.util.Log;

import com.ECS.client.jax.Item;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import net.grosinger.bookmetasearch.inventory.AvailableBook;
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
public class AmazonQuery implements InventoryQuery {
    private Book target;

    @Override
    public void setSearchTarget(Book book) {
        Log.d(getClass().getSimpleName(), "Setting target: " + book);
        target = book;
    }

    @Override
    public List<AvailableBook> loadInventory() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + target);

        if (target == null) {
            return null;
        }

        List<AvailableBook> books = null;
        if (target.getIsbn13() != null) {
            Log.d(getClass().getSimpleName(), "Searching for ISBN13 " + target.getIsbn13());
            books = performSearch(target.getIsbn13());
        }
        if ((books == null || books.size() == 0) && target.getIsbn() != null) {
            Log.d(getClass().getSimpleName(), "Searching for ISBN " + target.getIsbn());
            books = performSearch(target.getIsbn());
        }

        return books;
    }

    private List<AvailableBook> performSearch(String isbn) {
        Gson gson = new Gson();
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
                    books.add(new AvailableBook(target, AvailableBook.Format.EBOOK, item.getItemLinks().getItemLink().get(0).getURL(), "Amazon"));
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
