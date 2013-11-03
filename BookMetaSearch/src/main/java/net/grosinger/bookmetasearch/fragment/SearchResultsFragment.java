package net.grosinger.bookmetasearch.fragment;

import android.app.Fragment;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import net.grosinger.bookmetasearch.BookDetail;
import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.SearchResultAdapter;
import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class SearchResultsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private List<Book> searchResults;
    private SearchResultAdapter listAdapter;

    private ListView resultsListView;
    private LinearLayout resultsLayout;
    private View loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "Creating View");

        return inflater.inflate(R.layout.fragment_search_results, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadingView = getActivity().findViewById(R.id.linearLayout_resultsLoading);
        resultsListView = (ListView) getActivity().findViewById(R.id.listView_resultsList);
        resultsLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayout_resultsLayout);

        listAdapter = new SearchResultAdapter(getActivity(), null);
        resultsListView.setAdapter(listAdapter);

        resultsListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(getClass().getSimpleName(), "Item clicked: " + position);
        if (searchResults != null) {
            Book selectedBook = searchResults.get(position);

            Intent status = new Intent(getActivity(), BookDetail.class);
            status.putExtra("book", selectedBook);
            startActivity(status);
        }
    }

    public void setResults(List<Book> results) {
        Log.d(getClass().getSimpleName(), "Setting new results");

        searchResults = results;

        listAdapter.clear();
        listAdapter.addAll(results);
        listAdapter.notifyDataSetChanged();

        loadingView.setVisibility(View.INVISIBLE);
        resultsLayout.setVisibility(View.VISIBLE);
    }
}