package net.grosinger.bookmetasearch.book;

import java.security.InvalidParameterException;

/**
 * Created by tony on 11/3/13.
 */
public class AvailableBook {
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

    public static enum Format {
        AUDIOBOOK, EBOOK;
    }

}
