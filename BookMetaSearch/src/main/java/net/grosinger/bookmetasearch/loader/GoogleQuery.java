package net.grosinger.bookmetasearch.loader;

import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.dataprovider.GoogleProvider;

import java.util.List;

/**
 * Created by Tony on 11/7/13.
 */
public class GoogleQuery implements ProductQuery, InventoryQuery {
    private String query;
    private Book targetBook;

    @Override
    public void setSearchTarget(Book book) {
        Log.d(getClass().getSimpleName(), "Setting target: " + book);
        targetBook = book;
    }

    @Override
    public void setSearchTerms(String searchTerms) {
        Log.d(getClass().getSimpleName(), "Setting query: " + searchTerms);
        this.query = searchTerms;
    }

    @Override
    public List<AvailableBook> loadInventory() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + targetBook);

        if (targetBook == null) {
            return null;
        }

        GoogleProvider provider = new GoogleProvider();
        return provider.findInventory(targetBook);
    }

    @Override
    public List<Book> loadProducts() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + query);

        if (query == null || query == "") {
            return null;
        }

        GoogleProvider provider = new GoogleProvider();
        return provider.findBooks(query);
    }
}
