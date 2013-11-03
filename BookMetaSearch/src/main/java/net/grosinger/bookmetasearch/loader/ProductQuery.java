package net.grosinger.bookmetasearch.loader;

import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public interface ProductQuery {

    public void setSearchTerms(String searchTerms);

    public List<Book> load();
}
