package net.grosinger.bookmetasearch.loader;

import android.util.Log;

import net.grosinger.bookmetasearch.ApiKeys;
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
        Log.d(getClass().getSimpleName(), "Setting target: " + book);
        target = book;
    }

    @Override
    public List<AvailableBook> load() {
        Log.d(getClass().getSimpleName(), "Loading in background: " + target);

        if (target == null) {
            return null;
        }

        AmazonProvider provider = new AmazonProvider(ApiKeys.AWS_ACCESS_KEY_ID, ApiKeys.AWS_SECRET_ACCESS_KEY, ApiKeys.AWS_ASSOCIATES_ID);
        return provider.findInventory(target);
    }
}
