package net.grosinger.bookmetasearch.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public abstract class Query extends AsyncTaskLoader<List<Book>> {
    public Query(Context context) {
        super(context);
    }

    public abstract void setQuery(String query);
}
