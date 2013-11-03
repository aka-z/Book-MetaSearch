package net.grosinger.bookmetasearch.loader;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public interface InventoryQuery {

    public void setSearchTarget(Book book);

    public List<AvailableBook> load();
}
