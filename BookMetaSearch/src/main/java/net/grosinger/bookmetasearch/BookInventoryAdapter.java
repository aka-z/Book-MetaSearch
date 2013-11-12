package net.grosinger.bookmetasearch;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.grosinger.bookmetasearch.inventory.AvailableBook;
import net.grosinger.bookmetasearch.inventory.InventoryHeader;
import net.grosinger.bookmetasearch.inventory.InventoryListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class BookInventoryAdapter extends BaseAdapter {
    List<InventoryListItem> items;

    private LayoutInflater mInflater;

    public BookInventoryAdapter(Context context, List<InventoryListItem> ebooks, List<InventoryListItem> audiobooks) {
        Log.d(getClass().getSimpleName(), "Creating new adapter...");
        addAll(ebooks, audiobooks);

        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        items.clear();
        items.add(new InventoryHeader("No Availability"));
    }

    public void addAll(List<InventoryListItem> ebooks, List<InventoryListItem> audiobooks) {
        items = new ArrayList<InventoryListItem>();

        if(ebooks != null && !ebooks.isEmpty()) {
            items.add(new InventoryHeader("Available Ebooks"));
            items.addAll(ebooks);
        }

        if(audiobooks != null && !audiobooks.isEmpty()) {
            items.add(new InventoryHeader("Available Audiobooks"));
            items.addAll(audiobooks);
        }

        if(items.isEmpty()) {
            items.add(new InventoryHeader("No Availability"));
        }

        Log.d(getClass().getSimpleName(), "Updating adapter results to size " + items.size());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(getClass().getSimpleName(), "Building view from results");

        InventoryListItem item = items.get(position);
        View view = item.fillView(convertView, mInflater);

        return view;
    }
}
