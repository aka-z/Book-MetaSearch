package net.grosinger.bookmetasearch.search;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class SearchResultAdapter extends BaseAdapter {
    private List<Book> results;

    private LayoutInflater mInflater;

    public SearchResultAdapter(Context context, List<Book> results) {
        if (results != null) {
            this.results = results;
        } else {
            this.results = new ArrayList<Book>();
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

    public void addAll(List<Book> results) {
        Log.d(getClass().getSimpleName(), "Updating adapter results to size " + results.size());
        this.results = results;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(getClass().getSimpleName(), "Building view from results");

        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.search_result_item, null);
            holder = new ViewHolder();
            holder.txtBookName = (TextView) convertView.findViewById(R.id.textView_bookName);
            holder.txtAuthorName = (TextView) convertView.findViewById(R.id.textView_authorName);
            holder.rating = (RatingBar) convertView.findViewById(R.id.ratingBar_bookRating);
            holder.largeImg = (ImageView) convertView.findViewById(R.id.imageView_coverImg);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Book currentResult = results.get(position);
        Log.d(getClass().getSimpleName(), "Current book: " + currentResult);
        holder.txtBookName.setText(currentResult.getTitle());
        holder.txtAuthorName.setText(currentResult.getAuthor().getName());
        holder.rating.setRating((float) currentResult.getAvg_rating());

        currentResult.getImageAsync(holder.largeImg);

        return convertView;
    }

    static class ViewHolder {
        TextView txtBookName;
        TextView txtAuthorName;
        RatingBar rating;
        ImageView largeImg;
    }
}
