package net.grosinger.bookmetasearch.book;

import java.security.InvalidParameterException;

/**
 * Created by tony on 11/3/13.
 */
public class AvailableBook {
    private Book book;
    private Format format;

    public AvailableBook(Book book, Format format) {
        if (book.getPublisher() == null || book.getPublisher() == "") {
            throw new InvalidParameterException("Publisher can not be empty");
        }

        this.book = book;
        this.format = format;
    }

    public Book getBook() {
        return book;
    }

    public Format getFormat() {
        return format;
    }

    public static enum Format {
        AUDIOBOOK, EBOOK;
    }

}
