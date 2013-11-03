package net.grosinger.bookmetasearch.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class InventoryLoader extends AsyncTaskLoader<List<AvailableBook>> {
    List<InventoryQuery> queries;

    public InventoryLoader(Context context) {
        super(context);

        queries = new ArrayList<InventoryQuery>();
    }

    @Override
    public List<AvailableBook> loadInBackground() {
        List<AvailableBook> results = new ArrayList<AvailableBook>();

        for (InventoryQuery query : queries) {
            List<AvailableBook> part = query.load();
            if(part != null) {
                Log.d(getClass().getSimpleName(), "Adding results");
                results.addAll(part);
            }
        }

        return results;
    }

    public void addInventoryQuery(InventoryQuery query) {
        queries.add(query);
    }

    public void setSearchTarget(Book book) {
        for (InventoryQuery query : queries) {
            query.setSearchTarget(book);
        }
    }
}
