package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

public class LibraryTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testCheckoutMovieWithNoneExistingMovie()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      U |",
                        "| Movie1 |         2001 | Director1 |      1 |",
                        "| Movie2 |         2002 | Director2 |      10 |",
                };

        Library testLibrary = new Library();
        Movie testMovieNotInLibrary = new Movie("NotInLibrary", 0, "");

        testLibrary.checkoutMovie(testMovieNotInLibrary);

        testLibrary.listAvailableMovies();
        consoleMock.assertSTDOutContains(expectedMovieList, 3);
    }

    @Test
    public void tetCheckoutOneMovie()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      U |",
                        "| Movie2 |         2002 | Director2 |      10 |",
                };

        Library testLibrary = new Library();
        Movie testMovieInLibrary = new Movie("Movie1", 2001, "Director1", 1);

        testLibrary.checkoutMovie(testMovieInLibrary);

        testLibrary.listAvailableMovies();
        consoleMock.assertSTDOutContains(expectedMovieList, 3);
    }
}