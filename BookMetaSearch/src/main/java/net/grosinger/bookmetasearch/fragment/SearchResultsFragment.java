package net.grosinger.bookmetasearch.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.Result;

import java.util.Collections;
import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class SearchResultsFragment extends Fragment {

    ArrayAdapter<Result> listAdapter;

    private ListView resultsListView;
    private LinearLayout resultsLayout;
    private View loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("SearchResultsFragment", "Creating View");

        return inflater.inflate(R.layout.fragment_search_results, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadingView = getActivity().findViewById(R.id.linearLayout_resultsLoading);
        resultsListView = (ListView) getActivity().findViewById(R.id.listView_resultsList);
        resultsLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayout_resultsLayout);

        listAdapter = new ArrayAdapter<Result>(getActivity(), android.R.layout.simple_list_item_1);
        resultsListView.setAdapter(listAdapter);
    }

    public void setResults(List<Result> results) {
        listAdapter.clear();
        listAdapter.addAll(results);
        listAdapter.notifyDataSetChanged();

        loadingView.setVisibility(View.INVISIBLE);
        resultsLayout.setVisibility(View.VISIBLE);
    }
}