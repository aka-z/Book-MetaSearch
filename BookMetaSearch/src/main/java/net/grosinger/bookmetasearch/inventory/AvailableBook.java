package net.grosinger.bookmetasearch.inventory;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.book.Book;

/**
 * Created by tony on 11/3/13.
 */
public class AvailableBook implements InventoryListItem {
    private Book book;
    private Format format;
    private String link;
    private String provider;

    public AvailableBook(Book book, Format format, String link, String provider) {
        this.book = book;
        this.format = format;
        this.link = link;
        this.provider = provider;
    }

    public Book getBook() {
        return book;
    }

    public Format getFormat() {
        return format;
    }

    public String getLink() {
        return link;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.inventory_item, null);
        }

        ViewHolder holder;
        holder = new ViewHolder();
        holder.imgType = (ImageView) view.findViewById(R.id.imageView_typeImg);
        holder.txtProvider = (TextView) view.findViewById(R.id.textView_provider);

        holder.txtProvider.setText(getProvider());
        if (getFormat() == AvailableBook.Format.AUDIOBOOK) {
            holder.imgType.setBackgroundResource(R.drawable.ic_audiobook);
        } else {
            holder.imgType.setBackgroundResource(R.drawable.ic_ebook);
        }

        holder.txtProvider.setText(Html.fromHtml("<a href='" + getLink() + "'>" + getProvider() + "</a>"));
        holder.txtProvider.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }

    static class ViewHolder {
        TextView txtProvider;
        ImageView imgType;
    }

    public static enum Format {
        AUDIOBOOK, EBOOK;
    }
}
