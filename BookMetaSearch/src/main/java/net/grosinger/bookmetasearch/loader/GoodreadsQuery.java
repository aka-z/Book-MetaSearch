package net.grosinger.bookmetasearch.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import net.grosinger.bookmetasearch.book.Author;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.book.BookType;

import java.util.ArrayList;
import java.util.List;

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

        if(query == null || query == "") {
            return null;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO: Stop faking this data

        List<Book> results = new ArrayList<Book>();
        Author rothfuss = new Author.AuthorBuilder().setName("Patrick Rothfuss").build();
        results.add(new Book.BookBuilder(BookType.EBook).setAuthor(rothfuss).setTitle("The Name of the Wind").setAvgRating(3.5f).setLargeImg("http://d202m5krfqbpi5.cloudfront.net/books/1270352123m/186074.jpg").build());
        results.add(new Book.BookBuilder(BookType.EBook).setAuthor(rothfuss).setTitle("The Wise Man's Fear").setAvgRating(2.24f).setLargeImg("http://d202m5krfqbpi5.cloudfront.net/books/1297311431m/1215032.jpg").build());

        return results;
    }
}
