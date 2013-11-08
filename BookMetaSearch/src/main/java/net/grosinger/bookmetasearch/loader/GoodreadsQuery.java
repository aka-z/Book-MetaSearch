package net.grosinger.bookmetasearch.loader;

import android.util.Log;

import net.grosinger.bookmetasearch.ApiKeys;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.dataprovider.GoodreadsProvider;

import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class GoodreadsQuery implements ProductQuery {
    private String query;

    @Override
    public void setSearchTerms(String searchTerms) {
        Log.d(getClass().getSimpleName(), "Setting query: " + searchTerms);
        this.query = searchTerms;
    }

    @Override
    public List<Book> loadProducts() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + query);

        if (query == null || query == "") {
            return null;
        }

        GoodreadsProvider provider = new GoodreadsProvider(ApiKeys.GOODREADS_ACCESS_KEY, null);
        return provider.findBooks(query);
    }
}
