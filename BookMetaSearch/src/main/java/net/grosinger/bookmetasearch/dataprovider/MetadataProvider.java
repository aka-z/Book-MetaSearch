package net.grosinger.bookmetasearch.dataprovider;

import net.grosinger.bookmetasearch.book.Author;
import net.grosinger.bookmetasearch.book.Book;

import java.util.List;

/**
 * Created by tony on 11/2/13.
 */
public interface MetadataProvider {
    /**
     * Search for all books that match a given query
     *
     * @param searchTerm A string to search with
     * @return List of books written
     */
    public List<Book> findBooks(String searchTerm);

    /**
     * Search for all books written by an author
     *
     * @param author Instance of an Author object representing your author
     * @return List of books written
     */
    public List<Book> findBooks(Author author);

    /**
     * Search for an author by name
     *
     * @param authorName Name of author to search for
     * @return Instance of Author object
     */
    public Author findAuthorByName(String authorName);
}
