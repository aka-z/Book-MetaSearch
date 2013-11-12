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
import net.grosinger.bookmetasearch.book.AvailableBook;
import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.loader.AmazonQuery;
import net.grosinger.bookmetasearch.loader.InventoryLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class DetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<AvailableBook>> {
    Book book;
    InventoryLoader queryLoader;

    BookInventoryAdapter ebookAdapter;
    BookInventoryAdapter audiobookAdapter;

    public DetailFragment(Book book) {
        this.book = book;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "Creating View");

        getLoaderManager().initLoader(0, null, this);

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView coverImg = (ImageView) getActivity().findViewById(R.id.imageView_coverImg);
        TextView title = (TextView) getActivity().findViewById(R.id.textView_detailBookName);
        TextView author = (TextView) getActivity().findViewById(R.id.textView_detailAuthorName);
        TextView description = (TextView) getActivity().findViewById(R.id.textView_detailDescription);
        RatingBar rating = (RatingBar) getActivity().findViewById(R.id.ratingBar_detailBookRating);

        coverImg.setImageBitmap(book.getLarge_img());
        title.setText(book.getTitle());
        author.setText(book.getAuthor().getName());
        description.setText(book.getDescription());
        rating.setRating((float) book.getAvg_rating());

        // TODO: Async-loadProducts book description

        ListView ebookListView = (ListView) getActivity().findViewById(R.id.listView_ebookSources);
        ListView audiobookListView = (ListView) getActivity().findViewById(R.id.listView_audiobookSources);

        ebookAdapter = new BookInventoryAdapter(getActivity(), null);
        audiobookAdapter = new BookInventoryAdapter(getActivity(), null);

        ebookListView.setAdapter(ebookAdapter);
        audiobookListView.setAdapter(audiobookAdapter);

        if(queryLoader == null) {
            onCreateLoader(0, null);
        }
        queryLoader.setSearchTarget(book);
        queryLoader.forceLoad();
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
        Log.d(getClass().getSimpleName(), "Sorting results by type");
        List<AvailableBook> ebooks = new ArrayList<AvailableBook>();
        List<AvailableBook> audiobooks = new ArrayList<AvailableBook>();
        for (AvailableBook book : results) {
            if (book.getFormat().equals(AvailableBook.Format.EBOOK)) {
                ebooks.add(book);
            } else {
                audiobooks.add(book);
            }
        }

        Log.d(getClass().getSimpleName(), "Updating list adapters");
        ebookAdapter.clear();
        ebookAdapter.addAll(ebooks);
        ebookAdapter.notifyDataSetChanged();

        audiobookAdapter.clear();
        audiobookAdapter.addAll(ebooks);
        audiobookAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<AvailableBook>> loader) {
        queryLoader.setSearchTarget(null);
    }
}
