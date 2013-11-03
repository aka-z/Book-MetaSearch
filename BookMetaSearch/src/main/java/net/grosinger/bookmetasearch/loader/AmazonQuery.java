package net.grosinger.bookmetasearch.loader;

import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.dataprovider.AmazonProvider;

import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class AmazonQuery implements InventoryQuery {
    private Book target;

    @Override
    public void setSearchTarget(Book book) {
        target = book;
    }

    @Override
    public List<AvailableBook> load() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + target);

        if (target == null) {
            return null;
        }

        AmazonProvider provider = new AmazonProvider("EJfEBt5xXWbOjoE0t78yUw", null);
        return provider.findInventory(target);
    }
}
