package net.grosinger.bookmetasearch.book;

import java.security.InvalidParameterException;

/**
 * Created by tony on 11/3/13.
 */
public class AvailableBook {
    private Book book;
    private Format format;
    private String link;

    public AvailableBook(Book book, Format format, String link) {
        if (book.getPublisher() == null || book.getPublisher() == "") {
            throw new InvalidParameterException("Publisher can not be empty");
        }

        this.book = book;
        this.format = format;
        this.link = link;
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

    public static enum Format {
        AUDIOBOOK, EBOOK;
    }

}
