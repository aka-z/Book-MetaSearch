package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class AmazonProvider implements AvailabilityProvider {
    private String apiKey;
    private String apiSecret;

    public AmazonProvider(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public List<AvailableBook> findInventory(Book book) {
        Log.d(getClass().getSimpleName(), "Finding inventory");
        return null;
    }

}
