package net.grosinger.bookmetasearch.book;

import net.grosinger.bookmetasearch.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public class Author implements Result {
    private String name;
    private long id;
    private int num_works;
    private String large_img;
    private String small_img;
    private String hometown;

    private List<Book> books;

    private Author() {

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

        public Author build() {
            return instance;
        }
    }
}
