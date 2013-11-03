package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class MockAmazonProvider implements AvailabilityProvider {

    public MockAmazonProvider(String apiKey, String apiSecret, String affiliateId) {
        // TODO: Connect to Amazon SOAP translation service
    }

    public List<AvailableBook> findInventory(Book book) {
        Log.d(getClass().getSimpleName(), "Finding inventory");

        Log.d(getClass().getSimpleName(), "ISBN: " + book.getIsbn() + ", ISBN13: " + book.getIsbn13());

        List<AvailableBook> books = new ArrayList<AvailableBook>();

        if(book.getIsbn13() != null && book.getIsbn13() != "") {
            Log.d(getClass().getSimpleName(), "Searching by ISBN13");

            // Mock receiving a result
            books.add(new AvailableBook(book, AvailableBook.Format.EBOOK, "http://www.amazon.com/Name-Wind-Kingkiller-Chonicles-ebook/dp/B0010SKUYM", "Amazon.com"));
        }

        if(books.size() == 0 && book.getIsbn() != null && book.getIsbn() != "") {
            Log.d(getClass().getSimpleName(), "Searching by ISBN");

            // This is where we would search if we didn't have the longer ISBN number
        }

        return books;
    }
}
