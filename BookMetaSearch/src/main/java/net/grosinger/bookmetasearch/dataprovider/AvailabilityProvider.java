package net.grosinger.bookmetasearch.dataprovider;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public interface AvailabilityProvider {
    public List<AvailableBook> findInventory(Book book);
}
