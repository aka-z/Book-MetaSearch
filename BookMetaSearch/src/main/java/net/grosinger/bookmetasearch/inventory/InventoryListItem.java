package net.grosinger.bookmetasearch.inventory;

import android.view.LayoutInflater;
import android.view.View;

/**
 * An interface for items which can be displayed in the list
 * on the book details page. Should be able to draw itself.
 *
 * @author Tony
 * @since 11/3/2013
 */
public interface InventoryListItem {

    /**
     * Fill the given view or create a new view and return it
     * for this InventoryListItem
     *
     * @param view A view which may be optionally filled. May be null.
     * @param inflater LayoutInflater to create a new view if necessary.
     * @return The view which should be inserted for this list item.
     */
    public View fillView(View view, LayoutInflater inflater);
}
