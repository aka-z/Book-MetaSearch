package net.grosinger.bookmetasearch.inventory;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.grosinger.bookmetasearch.R;

/**
 * A very simple InventoyListItem which displays a header
 * item such as "Ebook Availability" or "Audiobook Availability"
 *
 * @author Tony
 * @since 11/3/2013
 */
public class InventoryHeader implements InventoryListItem {
    private String value;

    public InventoryHeader(String value) {
        this.value = value;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.inventory_item_header, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.textView_detailHeader);
        if(textView != null) {
            textView.setText(this.value);
        }

        view.setClickable(false);
        return view;
    }
}
