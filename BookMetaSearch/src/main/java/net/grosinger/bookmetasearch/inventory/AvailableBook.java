package net.grosinger.bookmetasearch.inventory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.grosinger.bookmetasearch.R;
import net.grosinger.bookmetasearch.book.Book;

/**
 * Store information about a specific inventory item.
 * Contains a url for this item, who is providing it, and the book itself.
 *
 * @author Tony
 * @since 11/3/2013
 */
public class AvailableBook implements InventoryListItem, View.OnClickListener, Parcelable {
    private Book book;
    private Format format;
    private String link;
    private String provider;

    private volatile Activity activity;

    public static final Parcelable.Creator<AvailableBook> CREATOR = new Parcelable.Creator<AvailableBook>() {
        public AvailableBook createFromParcel(Parcel in) {
            return new AvailableBook(in);
        }

        public AvailableBook[] newArray(int size) {
            return new AvailableBook[size];
        }
    };

    private AvailableBook(Parcel parcel) {
        Log.d(getClass().getSimpleName(), "Un-parceling AvailableBook");

        book = parcel.readParcelable(Book.class.getClassLoader());
        format = parcel.readParcelable(Format.class.getClassLoader());
        link = parcel.readString();
        provider = parcel.readString();
    }

    public AvailableBook(Book book, Format format, String link, String provider) {
        this.book = book;
        this.format = format;
        this.link = link;
        this.provider = provider;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Log.d(getClass().getSimpleName(), "Parceling AvailableBook");

        parcel.writeParcelable(book, i);
        parcel.writeParcelable(format, i);
        parcel.writeString(link);
        parcel.writeString(provider);
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
        Log.d(getClass().getSimpleName(), "Creating and filling view for list item: " + provider + " - " + format);
        if (view == null) {
            view = inflater.inflate(R.layout.inventory_item, null);
        }

        // While we are using the inflater, also get the activity
        activity = (Activity) inflater.getContext();

        ImageView imgType = (ImageView) view.findViewById(R.id.imageView_typeImg);
        TextView txtProvider = (TextView) view.findViewById(R.id.textView_provider);

        txtProvider.setText(getProvider());
        if (getFormat() == AvailableBook.Format.AUDIOBOOK) {
            imgType.setBackgroundResource(R.drawable.ic_audiobook);
        } else {
            imgType.setBackgroundResource(R.drawable.ic_ebook);
        }

        view.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Log.d(getClass().getSimpleName(), "InventoryItem clicked, launching link");
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        activity.startActivity(i);
    }

    public static enum Format implements Parcelable {
        AUDIOBOOK, EBOOK;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(final Parcel parcel, final int flags) {
            parcel.writeInt(ordinal());
        }

        public static final Creator<Format> CREATOR = new Creator<Format>() {
            @Override
            public Format createFromParcel(final Parcel source) {
                return Format.values()[source.readInt()];
            }

            @Override
            public Format[] newArray(final int size) {
                return new Format[size];
            }
        };
    }
}
