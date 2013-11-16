package net.grosinger.bookmetasearch.book;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import net.grosinger.bookmetasearch.loader.AsyncImageLoader;
import net.grosinger.bookmetasearch.loader.ProductQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Container object for a book and all required information.
 *
 * @author Tony
 * @since 11/2/2013
 */
public class Book implements Parcelable {

    private String id;
    private ProductQuery provider;

    private String title;
    private Author author;
    private String isbn;
    private String isbn13;
    private String publisher;
    private double avg_rating;
    private String description;
    private int num_pages;

    private Bitmap large_img;
    private Bitmap small_img;
    private String large_img_url;
    private String small_img_url;

    // TODO: Adapt to support multiple authors

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private Book(Parcel parcel) {
        Log.d(getClass().getSimpleName(), "Un-parceling book");

        id = parcel.readString();
        title = parcel.readString();
        author = parcel.readParcelable(Author.class.getClassLoader());
        isbn = parcel.readString();
        isbn13 = parcel.readString();
        large_img = parcel.readParcelable(Bitmap.class.getClassLoader());
        small_img = parcel.readParcelable(Bitmap.class.getClassLoader());
        large_img_url = parcel.readString();
        small_img_url = parcel.readString();
        publisher = parcel.readString();
        avg_rating = parcel.readDouble();
        description = parcel.readString();
        num_pages = parcel.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Log.d(getClass().getSimpleName(), "Parceling book");

        // TODO: Add provider to parcel

        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeParcelable(author, i);
        parcel.writeString(isbn);
        parcel.writeString(isbn13);
        parcel.writeParcelable(large_img, i);
        parcel.writeParcelable(small_img, i);
        parcel.writeString(large_img_url);
        parcel.writeString(small_img_url);
        parcel.writeString(publisher);
        parcel.writeDouble(avg_rating);
        parcel.writeString(description);
        parcel.writeInt(num_pages);
    }

    private Book(String id, ProductQuery provider) {
        this.id = id;
        this.provider = provider;
    }

    public String getId() {
        return id;
    }

    public ProductQuery getProvider() {
        return provider;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public Bitmap getLargeImg() {
        return large_img;
    }

    public Bitmap getSmallImg() {
        return small_img;
    }

    public void getLargeImgAsync(ImageView view) {
        if(large_img != null) {
            view.setImageBitmap(large_img);
        } else {
            AsyncImageLoader loader = new AsyncImageLoader(view, title);
            loader.execute(large_img_url);
        }
    }

    public void getSmallImgAsync(ImageView view) {
        if (small_img != null) {
            view.setImageBitmap(small_img);
        } else {
            AsyncImageLoader loader = new AsyncImageLoader(view, title);
            loader.execute(small_img_url);
        }
    }

    public void getImageAsync(ImageView view) {
        if(large_img_url != null && !large_img_url.equals("")) {
            getLargeImgAsync(view);
        } else if (small_img_url != null && !small_img_url.equals("")) {
            getSmallImgAsync(view);
        } else {
            Log.d(getClass().getSimpleName(), "No image URL available to load: " + title);
        }
    }

    public String getLargeImgUrl() {
        return large_img_url;
    }

    public String getSmallImgUrl() {
        return small_img_url;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getAvg_rating() {
        return avg_rating;
    }

    public String getDescription() {
        return description;
    }

    public int getNum_pages() {
        return num_pages;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(id).append(title).append(author).append(isbn).append(isbn13).append(publisher)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book rhs = (Book) obj;
        return new EqualsBuilder()
                .append(id, rhs.id).append(title, rhs.title).append(author, rhs.author).append(isbn, rhs.isbn)
                .append(isbn13, rhs.isbn13).append(publisher, rhs.publisher)
                .isEquals();
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }

    public static class BookBuilder {
        private Book instance;

        public BookBuilder(String id, ProductQuery provider) {
            instance = new Book(id, provider);
        }

        public BookBuilder setTitle(String title) {
            instance.title = title;
            return this;
        }

        public BookBuilder setAuthor(Author author) {
            instance.author = author;
            return this;
        }

        public BookBuilder setIsbn(String isbn) {
            instance.isbn = isbn;
            return this;
        }

        public BookBuilder setIsbn13(String isbn13) {
            instance.isbn13 = isbn13;
            return this;
        }

        public BookBuilder setLargeImg(String largeImg) {
            instance.large_img_url = largeImg;
            return this;
        }

        public BookBuilder setSmallImg(String smallImg) {
            instance.small_img_url = smallImg;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            instance.publisher = publisher;
            return this;
        }

        public BookBuilder setAvgRating(double avgRating) {
            instance.avg_rating = avgRating;
            return this;
        }

        public BookBuilder setNumPages(int numPages) {
            instance.num_pages = numPages;
            return this;
        }

        public BookBuilder setDescription(String description) {
            instance.description = description;
            return this;
        }

        public Book build() {
            return instance;
        }
    }
}
