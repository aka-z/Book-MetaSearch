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
import android.widget.SearchView;

import net.grosinger.bookmetasearch.book.Book;
import net.grosinger.bookmetasearch.fragment.SearchResultsFragment;
import net.grosinger.bookmetasearch.loader.GoodreadsQuery;
import net.grosinger.bookmetasearch.loader.ProductLoader;

import java.util.List;


/**
 * Created by tony on 11/3/13.
 */
public class SearchActivity extends Activity implements LoaderManager.LoaderCallbacks<List<Book>> {
    SearchResultsFragment searchResultsFragment;

    String queryString;
    ProductLoader queryLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getLoaderManager().initLoader(0, null, this);

        Intent intent = getIntent();
        if (intent != null && Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(getClass().getSimpleName(), "Found ACTION_SEARCH intent, creating SearchResultsFragment");

            searchResultsFragment = new SearchResultsFragment();

            getFragmentManager().beginTransaction()
                    .add(R.id.container, searchResultsFragment)
                    .commit();

            handleIntent(getIntent());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void handleIntent(Intent intent) {
        Log.d(getClass().getSimpleName(), "Handling intent");

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(getClass().getSimpleName(), "Intent is ACTION_SEARCH");

            queryString = intent.getStringExtra(SearchManager.QUERY);
            Log.d(getClass().getSimpleName(), "Searching for " + queryString);

            if(queryLoader == null) {
                onCreateLoader(0, null);
            }
            queryLoader.setSearchTerm(queryString);
            queryLoader.forceLoad();
        }
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle args) {
        Log.v(getClass().getSimpleName(), "Creating Loader");

        queryLoader = new ProductLoader(this);
        queryLoader.addProductQuery(new GoodreadsQuery());
        return queryLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> results) {
        searchResultsFragment.setResults(results);
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        queryLoader.setSearchTerm(null);
    }
}
