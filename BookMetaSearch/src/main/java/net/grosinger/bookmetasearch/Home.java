package net.grosinger.bookmetasearch;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import net.grosinger.bookmetasearch.fragment.HomeFragment;
import net.grosinger.bookmetasearch.fragment.SearchResultsFragment;
import net.grosinger.bookmetasearch.loader.GoodreadsQuery;
import net.grosinger.bookmetasearch.loader.Query;

import java.util.List;

public class Home extends Activity implements LoaderManager.LoaderCallbacks<List<Result>> {
    SearchResultsFragment searchResultsFragment;
    boolean searchResultsVisible;

    Query queryLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getLoaderManager().initLoader(0, null, this);

        Intent intent = getIntent();
        if (intent != null && Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(this.getClass().getSimpleName(), "Found ACTION_SEARCH intent, creating SearchResultsFragment");

            searchResultsFragment = new SearchResultsFragment();
            searchResultsVisible = true;

            getFragmentManager().beginTransaction()
                    .add(R.id.container, searchResultsFragment)
                    .commit();
        } else if (savedInstanceState == null) {
            Log.d(this.getClass().getSimpleName(), "No intent or saved instance, creating PlaceholderFragment");
            searchResultsVisible = false;
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new HomeFragment())
                    .commit();
        }

        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleIntent(Intent intent) {
        Log.d(this.getClass().getSimpleName(), "Handling intent");

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(this.getClass().getSimpleName(), "Intent is ACTION_SEARCH");

            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(this.getClass().getSimpleName(), "Searching for " + query);

            queryLoader.setQuery(query);
            queryLoader.forceLoad();
        }
    }

    @Override
    public Loader<List<Result>> onCreateLoader(int i, Bundle args) {
        Log.v(this.getClass().getSimpleName(), "Creating Loader");

        queryLoader = new GoodreadsQuery(this);
        return queryLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<Result>> loader, List<Result> results) {
        searchResultsFragment.setResults(results);
    }

    @Override
    public void onLoaderReset(Loader<List<Result>> loader) {
        queryLoader.setQuery(null);
    }
}
