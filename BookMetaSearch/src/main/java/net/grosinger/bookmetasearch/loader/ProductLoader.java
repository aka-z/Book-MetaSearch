package net.grosinger.bookmetasearch.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import net.grosinger.bookmetasearch.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class ProductLoader extends AsyncTaskLoader<List<Book>> {
    List<ProductQuery> queries;

    public ProductLoader(Context context) {
        super(context);

        queries = new ArrayList<ProductQuery>();
    }

    @Override
    public List<Book> loadInBackground() {
        List<Book> results = new ArrayList<Book>();

        for (ProductQuery query : queries) {
            List<Book> part = query.loadProducts();
            if(part != null) {
                Log.d(getClass().getSimpleName(), "Adding results");
                results.addAll(part);
            }
        }

        return results;
    }

    public void addProductQuery(ProductQuery query) {
        queries.add(query);
    }

    public void setSearchTerm(String searchTerm) {
        for (ProductQuery query : queries) {
            query.setSearchTerms(searchTerm);
        }
    }
}
