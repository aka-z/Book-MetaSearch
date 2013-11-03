package net.grosinger.bookmetasearch.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class Author {
    private String name;
    private long id;
    private int num_works;
    private String large_img;
    private String small_img;
    private String hometown;

    private List<Book> books;

    private Author() {

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

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class AuthorBuilder {
        Author instance;

        public AuthorBuilder() {
            instance = new Author();
        }

        public AuthorBuilder setName(String name) {
            instance.name = name;
            return this;
        }

        public AuthorBuilder setId(long id) {
            instance.id = id;
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

        public AuthorBuilder setBooks(ArrayList<Book> books) {
            instance.books = Collections.unmodifiableList(books);
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
