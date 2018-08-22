package com.twu.biblioteca;

import java.util.ArrayList;

public class Library
{
    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> availableMovies;

    public Library()
    {
        availableBooks = new ArrayList<Book>();
        availableBooks.add(new Book("Book1", "Author1", 2001));
        availableBooks.add(new Book("Book2", "Author2", 2002));

        checkedOutBooks = new ArrayList<Book>();

        availableMovies = new ArrayList<Movie>();
        availableMovies.add(new Movie("Movie0", 2000, "Director0"));
        availableMovies.add(new Movie("Movie1", 2001, "Director1", 1));
        availableMovies.add(new Movie("Movie2", 2002, "Director2", 10));
    }

    public void checkoutBook(Book book)
    {
        if (availableBooks.contains(book))
        {
            availableBooks.remove(book);
            checkedOutBooks.add(book);

            System.out.println(OutputStrings.CHECK_OUT_BOOK_SUCCESS_MESSAGE);
        } else
        {
            System.out.println(OutputStrings.CHECK_OUT_BOOK_UNSUCCESSFUL_MESSAGE);
        }
    }

    public void listAvailableBooks()
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList(availableBooks);
    }

    public void returnBook(Book book)
    {
        if (book != null && checkedOutBooks.contains(book))
        {
            checkedOutBooks.remove(book);
            availableBooks.add(book);

            System.out.println(OutputStrings.BOOK_RETURN_SUCCESS_MESSAGE);
        } else
        {
            System.out.println(OutputStrings.BOOK_RETURN_UNSUCCESSFUL_MESSAGE);
        }
    }

    public void listAvailableMovies()
    {
        MovieListPrinter movieListPrinter = new MovieListPrinter();
        movieListPrinter.printMovieList(availableMovies);
    }

    public void checkoutMovie(Movie movie)
    {
        if (availableMovies.contains(movie))
        {
            availableMovies.remove(movie);
        }
    }
}
