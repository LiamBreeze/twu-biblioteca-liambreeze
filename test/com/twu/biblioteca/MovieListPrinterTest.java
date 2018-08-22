package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

public class MovieListPrinterTest
{
    @Rule
    public ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void listAvailableMovies()
    {
        String[] expectedListHeading = new String[]
                {
                        "===========================================",
                        "| Name | Release Year | Director | Rating |",
                        "-------------------------------------------",
                };

        MovieListPrinter testMovieListPrinter = new MovieListPrinter();
        testMovieListPrinter.printMovieList();

        consoleMock.assertSTDOutContains(expectedListHeading, 0);
    }
}