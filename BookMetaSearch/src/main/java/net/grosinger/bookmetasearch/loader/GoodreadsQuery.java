package net.grosinger.bookmetasearch.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;

import net.grosinger.bookmetasearch.Result;
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
        this.query = query;
    }

    @Override
    public List<Result> loadInBackground() {
        if(query == null || query == "") {
            return null;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO: Stop faking this data

        List<Result> results = new ArrayList<Result>();
        Author rothfuss = new Author.AuthorBuilder().setName("Patrick Rothfuss").build();
        results.add(new Book.BookBuilder(BookType.EBook).setAuthor(rothfuss).setTitle("The Name of the Wind").build());
        results.add(new Book.BookBuilder(BookType.EBook).setAuthor(rothfuss).setTitle("The next one...").build());

        return results;
    }
}
