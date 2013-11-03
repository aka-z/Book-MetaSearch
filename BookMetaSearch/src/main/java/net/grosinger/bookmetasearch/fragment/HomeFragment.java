package net.grosinger.bookmetasearch.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.grosinger.bookmetasearch.R;

/**
 * Created by tony on 11/2/13.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        Log.d("Home.PlaceholderFragment", "Initialized");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Home.PlaceholderFragment", "Creating View");

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
}
