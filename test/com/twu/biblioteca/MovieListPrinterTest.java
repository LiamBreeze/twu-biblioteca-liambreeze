package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class MovieListPrinterTest
{
    @Rule
    public ConsoleTestRule consoleMock = new ConsoleTestRule();

    private ArrayList<Movie> testMovieList;
    private MovieListPrinter testMovieListPrinter;

    @Before
    public void setUp()
    {
        testMovieList = new ArrayList<Movie>();
        testMovieListPrinter = new MovieListPrinter();
    }

    @Test
    public void testListAvailableMoviesTable()
    {
        String[] expectedListHeading = new String[]
                {
                        "==============================================",
                        "|    Name | Release Year |  Director | Rating |",
                        "----------------------------------------------",
                };

        testMovieListPrinter.printMovieList(testMovieList);

        consoleMock.assertSTDOutContains(expectedListHeading, 0);
    }

    @Test
    public void testListAvailableMoviesWithOneMovie()
    {
        String[] expectedTableOutput = new String[]
                {
                        "| Movie1 |         2001 | Director1 |      1 |",
                };

        testMovieList.add(new Movie("Movie1", 2001, "Director1", 1));

        testMovieListPrinter.printMovieList(testMovieList);

        consoleMock.assertSTDOutContains(expectedTableOutput, 3);
    }
}