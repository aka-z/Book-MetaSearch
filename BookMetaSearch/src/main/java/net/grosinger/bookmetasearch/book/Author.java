package net.grosinger.bookmetasearch.book;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class Author implements Parcelable {
    private String name;
    private long id;
    private int num_works;
    private String large_img;
    private String small_img;
    private String hometown;

    private Author(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getNum_works() {
        return num_works;
    }

    public String getLarge_img() {
        return large_img;
    }

    public String getSmall_img() {
        return small_img;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    private Author(Parcel parcel) {
        name = parcel.readString();
        id = parcel.readLong();
        num_works = parcel.readInt();
        large_img = parcel.readString();
        small_img = parcel.readString();
        hometown = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeLong(id);
        parcel.writeInt(num_works);
        parcel.writeString(large_img);
        parcel.writeString(small_img);
        parcel.writeString(hometown);
    }

    public static class AuthorBuilder {
        Author instance;

        public AuthorBuilder(long id) {
            instance = new Author(id);
        }

        public AuthorBuilder setName(String name) {
            instance.name = name;
            return this;
        }

        public AuthorBuilder setNumWorks(int numWorks) {
            instance.num_works = numWorks;
            return this;
        }

        public AuthorBuilder setLargeImg(String largeImg) {
            instance.large_img = largeImg;
            return this;
        }

        public AuthorBuilder setSmallImg(String smallImg) {
            instance.small_img = smallImg;
            return this;
        }

        public AuthorBuilder setHometown(String hometown) {
            instance.hometown = hometown;
            return this;
        }

        public Author build() {
            return instance;
        }
    }
}
