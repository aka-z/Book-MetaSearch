package net.grosinger.bookmetasearch.book;

import net.grosinger.bookmetasearch.Result;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by tony on 11/2/13.
 */
public class Book implements Result {

    private BookType type;
    private String title;
    private Author author;
    private long isbn;
    private long isbn13;
    private String large_img;
    private String small_img;
    private String publisher;
    private int avg_rating;
    private String description;
    private int num_pages;

    private Book(BookType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(type).append(title).append(author).append(isbn).append(isbn13).append(publisher)
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
                .append(type, rhs.type).append(title, rhs.title).append(author, rhs.author).append(isbn, rhs.isbn)
                .append(isbn13, rhs.isbn13).append(publisher, rhs.publisher)
                .isEquals();
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }

    public static class BookBuilder {
        private Book instance;

        public BookBuilder(BookType type) {
            instance = new Book(type);
        }

        public BookBuilder setTitle(String title) {
            instance.title = title;
            return this;
        }

        public BookBuilder setAuthor(Author author) {
            instance.author = author;
            return this;
        }

        public BookBuilder setIsbn(long isbn) {
            instance.isbn = isbn;
            return this;
        }

        public BookBuilder setIsbn13(long isbn13) {
            instance.isbn13 = isbn13;
            return this;
        }

        public BookBuilder setLargeImg(String largeImg) {
            instance.large_img = largeImg;
            return this;
        }

        public BookBuilder setSmallImg(String smallImg) {
            instance.small_img = smallImg;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            instance.publisher = publisher;
            return this;
        }

        public BookBuilder setAvgRating(int avgRating) {
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
