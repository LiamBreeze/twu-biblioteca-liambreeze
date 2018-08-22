package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LibraryTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private Library testLibrary;

    @Before
    public void setUp()
    {
        testLibrary = new Library();
    }

    @Test
    public void testCheckoutMovieWithNoneExistingMovie()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      U |",
                        "| Movie1 |         2001 | Director1 |      1 |",
                        "| Movie2 |         2002 | Director2 |      10 |",
                };

        Movie[] moviesToCheckout = new Movie[]
                {
                        new Movie("NotInLibrary", 0, ""),
                };

        runMovieCheckoutTest(moviesToCheckout, expectedMovieList);
    }

    @Test
    public void tetCheckoutOneMovie()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      U |",
                        "| Movie2 |         2002 | Director2 |      10 |",
                };

        Movie[] moviesToCheckout = new Movie[]
                {
                        new Movie("Movie1", 2001, "Director1", 1),
                };

        runMovieCheckoutTest(moviesToCheckout, expectedMovieList);
    }

    @Test
    public void testCheckoutMultipleMovies()
    {
        String[] expectedMovieList = new String[]
                {
                        "=============================================="
                };

        Movie[] moviesToCheckout = new Movie[]
                {
                        new Movie("Movie0", 2000, "Director0"),
                        new Movie("Movie1", 2001, "Director1", 1),
                        new Movie("Movie2", 2002, "Director2", 10),
                };

        runMovieCheckoutTest(moviesToCheckout, expectedMovieList);
    }

    @Test
    public void testCheckoutBookFailsWithoutLogin()
    {
        String[] expectedOutput =
                {
                        "| Book1 | Author1 |           2001 |",
                        "| Book2 | Author2 |           2002 |",
                };

        Book testBook = new Book("Book1", "Author1", 2001);
        testLibrary.checkoutBook("", "", testBook);

        testLibrary.listAvailableBooks();
        consoleMock.assertSTDOutContains(expectedOutput, 4);
    }

    private void runMovieCheckoutTest(Movie[] moviesToCheckout, String[] expectedMovieList)
    {
        for (int movieNumber = 0; movieNumber < moviesToCheckout.length; movieNumber++)
        {
            testLibrary.checkoutMovie(moviesToCheckout[movieNumber]);
        }

        testLibrary.listAvailableMovies();
        consoleMock.assertSTDOutContains(expectedMovieList, 3);
    }
}