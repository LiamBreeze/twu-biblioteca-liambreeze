package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

public class LibraryTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testCheckoutMovie()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      U |",
                };

        Library testLibrary = new Library();
        Movie testMovieNotInLibrary = new Movie("NotInLibrary", 0, "");
        testLibrary.checkoutMovie(testMovieNotInLibrary);

        testLibrary.listAvailableMovies();
        consoleMock.assertSTDOutContains(expectedMovieList, 3);
    }
}