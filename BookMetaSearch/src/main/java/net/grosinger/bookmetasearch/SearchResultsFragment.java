package net.grosinger.bookmetasearch;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.grosinger.bookmetasearch.R;

/**
 * Created by tony on 11/2/13.
 */
public class SearchResultsFragment extends Fragment {

        public SearchResultsFragment() {
            Log.d("SearchResultsFragment", "Initialized");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("SearchResultsFragment", "Creating View");

            View rootView = inflater.inflate(R.layout.fragment_search_results, container, false);
            return rootView;
        }
    }