package net.grosinger.bookmetasearch.fragment;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import net.grosinger.bookmetasearch.BookInventoryAdapter;
import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.inventory.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.inventory.InventoryListItem;
import net.grosinger.bookmetasearch.loader.AmazonQuery;
import net.grosinger.bookmetasearch.loader.InventoryLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Show the cover image, book name, author, rating and description of
 * book above a list of all sources where the book can be found.
 *
 * Provides handling of inventory loading and interacts with a
 * custom ListView adapter to create custom headings
 *
 * @author Tony
 * @since 11/3/2013
 */
public class DetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<AvailableBook>> {
    Book book;
    InventoryLoader queryLoader;

    BookInventoryAdapter bookSourcesAdapter;
    AvailableBook[] currentSearchResults;

    /**
     * Default constructor for use during orientation changes
     */
    public DetailFragment() {
    }

    public DetailFragment(Book book) {
        this.book = book;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "Creating View");

        getLoaderManager().initLoader(0, null, this);

        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey("book")) {
                book = savedInstanceState.getParcelable("book");
            }
            if (savedInstanceState.containsKey("results")) {
                currentSearchResults = (AvailableBook[]) savedInstanceState.getParcelableArray("results");
            }
        }

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(getClass().getSimpleName(), "Creating activity");

        // Get all the fields at the top of the screen
        ImageView coverImg = (ImageView) getActivity().findViewById(R.id.imageView_coverImg);
        TextView title = (TextView) getActivity().findViewById(R.id.textView_detailBookName);
        TextView author = (TextView) getActivity().findViewById(R.id.textView_detailAuthorName);
        TextView description = (TextView) getActivity().findViewById(R.id.textView_detailDescription);
        RatingBar rating = (RatingBar) getActivity().findViewById(R.id.ratingBar_detailBookRating);

        // Populate fields at top of screen with book information
        book.getImageAsync(coverImg);
        title.setText(book.getTitle());
        author.setText(book.getAuthor().getName());
        description.setText(book.getDescription());
        rating.setRating((float) book.getAvg_rating());

        // TODO: Async-loadProducts book description

        // Create the custom ListView adapter and set it on the list
        bookSourcesAdapter = new BookInventoryAdapter(getActivity(), null, null);
        ListView bookSourcesListView = (ListView) getActivity().findViewById(R.id.listView_detailBookSources);
        bookSourcesListView.setAdapter(bookSourcesAdapter);

        // Initiate a load if we do not have saved data
        if(currentSearchResults != null) {
            onLoadFinished(null, Arrays.asList(currentSearchResults));
        } else {
            if(queryLoader == null) {
                onCreateLoader(0, null);
            }
            queryLoader.setSearchTarget(book);
            queryLoader.forceLoad();
        }
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        Log.d(getClass().getSimpleName(), "Saving instance state");

        outState.putParcelable("book", book);
        outState.putParcelableArray("results", currentSearchResults);
    }

    @Override
    public Loader<List<AvailableBook>> onCreateLoader(int i, Bundle args) {
        Log.v(getClass().getSimpleName(), "Creating Loader");

        queryLoader = new InventoryLoader(getActivity());
        queryLoader.addInventoryQuery(new AmazonQuery());
        return queryLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<AvailableBook>> loader, List<AvailableBook> results) {
        Log.d(getClass().getSimpleName(), "Finished loading, setting results");

        // We need to save these results so we can parcel them if the orientation is changed
        currentSearchResults = results.toArray(new AvailableBook[results.size()]);

        Log.d(getClass().getSimpleName(), "Sorting results by type");
        List<InventoryListItem> ebooks = new ArrayList<InventoryListItem>();
        List<InventoryListItem> audiobooks = new ArrayList<InventoryListItem>();
        for (AvailableBook book : results) {
            if (book.getFormat().equals(AvailableBook.Format.EBOOK)) {
                ebooks.add(book);
            } else {
                audiobooks.add(book);
            }
        }

        Log.d(getClass().getSimpleName(), "Updating list adapters");
        bookSourcesAdapter.clear();
        bookSourcesAdapter.addAll(ebooks, audiobooks);
        bookSourcesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<AvailableBook>> loader) {
        Log.d(getClass().getSimpleName(), "Resetting loader");

        queryLoader.setSearchTarget(null);
        currentSearchResults = null;
    }
}
