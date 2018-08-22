package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CheckoutMovieOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private Library testLibrary;
    private CheckoutMovieOption testOption;

    @Before
    public void setUp()
    {
        testLibrary = new Library();
        testOption = new CheckoutMovieOption();
    }

    @Test
    public void testSelectDoesNotExitApp()
    {
        Assert.assertFalse(testOption.select(testLibrary));
    }

    @Test
    public void testSelectChecksOutAMovieFromTheLibrary()
    {
        String[] expectedMovieList = new String[]
                {
                        "| Movie1 |         2001 | Director1 |      1 |",
                        "| Movie2 |         2002 | Director2 |      10 |",
                };

        consoleMock.addUserInputSequence(new String[]
                {
                        "Movie0", "2000", "Director0", "U"
                });

        testOption.select(testLibrary);

        testLibrary.listAvailableMovies();
        consoleMock.assertSTDOutContains(expectedMovieList, 4);
    }
}