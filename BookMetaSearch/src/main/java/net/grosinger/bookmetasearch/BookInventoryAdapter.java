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

import net.grosinger.bookmetasearch.book.AvailableBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/3/13.
 */
public class BookInventoryAdapter extends BaseAdapter {
    List<AvailableBook> results;

    private LayoutInflater mInflater;

    public BookInventoryAdapter(Context context, List<AvailableBook> results) {
        if (results == null) {
            this.results = new ArrayList<AvailableBook>();
        } else {
            this.results = results;
        }

        Log.d(getClass().getSimpleName(), "Creating adapter with array size " + this.results.size());

        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int i) {
        return results.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        results = null;
    }

    public void addAll(List<AvailableBook> results) {
        Log.d(getClass().getSimpleName(), "Updating adapter results to size " + results.size());
        this.results = results;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(getClass().getSimpleName(), "Building view from results");

        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.inventory_item, null);
            holder = new ViewHolder();
            holder.imgType = (ImageView) convertView.findViewById(R.id.imageView_typeImg);
            holder.txtProvider = (TextView) convertView.findViewById(R.id.textView_provider);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AvailableBook currentResult = results.get(position);
        Log.d(getClass().getSimpleName(), "Current book: " + currentResult);

        holder.txtProvider.setText(currentResult.getProvider());
        if (currentResult.getFormat() == AvailableBook.Format.AUDIOBOOK) {
            holder.imgType.setBackgroundResource(R.drawable.ic_audiobook);
        } else {
            holder.imgType.setBackgroundResource(R.drawable.ic_ebook);
        }

        holder.txtProvider.setText(Html.fromHtml("<a href='" + currentResult.getLink() + "'>" + currentResult.getProvider() + "</a>"));
        holder.txtProvider.setMovementMethod(LinkMovementMethod.getInstance());

        return convertView;
    }

    static class ViewHolder {
        TextView txtProvider;
        ImageView imgType;
    }
}
