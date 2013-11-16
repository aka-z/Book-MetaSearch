package net.grosinger.bookmetasearch.search;

import android.content.SearchRecentSuggestionsProvider;

// TODO: Update class description
/**
 * A description of what this class does
 *
 * @author Tony
 * @since 11/16/2013
 */
public class RecentBookSearchSuggestionsProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "net.grosinger.bookmetasearch.search.RecentBookSearchSuggestionsProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public RecentBookSearchSuggestionsProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
