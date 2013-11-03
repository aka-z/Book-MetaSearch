package net.grosinger.bookmetasearch.dataprovider;

import android.util.Log;

import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.loader.helper.AmazonAffiliatesSearch;

import com.ECS.client.jax.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class AmazonProvider implements AvailabilityProvider {
    AmazonAffiliatesSearch search;

    public AmazonProvider(String apiKey, String apiSecret, String affiliateId) {
        search = new AmazonAffiliatesSearch(apiKey, apiSecret, affiliateId);
    }

    public List<AvailableBook> findInventory(Book book) {
        Log.d(getClass().getSimpleName(), "Finding inventory");

        List<AvailableBook> books = new ArrayList<AvailableBook>();

        if(book.getIsbn13() != 0) {
            Log.d(getClass().getSimpleName(), "Searching by ISBN13");

            List<Item> results = search.performItemLookupISBN(Long.toString(book.getIsbn13()));
            for (Item item : results) {
                String link = item.getItemLinks().getItemLink().get(0).getURL();
                books.add(new AvailableBook(book, AvailableBook.Format.EBOOK, link));
            }
        }

        if(books.size() == 0 && book.getIsbn() != 0) {
            Log.d(getClass().getSimpleName(), "Searching by ISBN");

            List<Item> results = search.performItemLookupISBN(Long.toString(book.getIsbn()));
            for (Item item : results) {
                String link = item.getItemLinks().getItemLink().get(0).getURL();
                books.add(new AvailableBook(book, AvailableBook.Format.EBOOK, link));
            }
        }

        return books;
    }
}
