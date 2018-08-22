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
    public void testListMoviesTable()
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
    public void testListMoviesWithOneMovie()
    {
        String[] expectedTableOutput = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      1 |",
                };

        testMovieList = addMovies(testMovieList, 1);

        testMovieListPrinter.printMovieList(testMovieList);

        consoleMock.assertSTDOutContains(expectedTableOutput, 3);
    }

    @Test
    public void testListMoviesWithMultipleMovies()
    {
        String[] expectedMovieOutput = new String[]
                {
                        "| Movie0 |         2000 | Director0 |      1 |",
                        "| Movie1 |         2001 | Director1 |      1 |",
                        "| Movie2 |         2002 | Director2 |      1 |",
                };

        testMovieList = addMovies(testMovieList, 3);

        testMovieListPrinter.printMovieList(testMovieList);

        consoleMock.assertSTDOutContains(expectedMovieOutput, 3);
    }

    private ArrayList<Movie> addMovies(ArrayList<Movie> movieList, int numberOfMovies)
    {
        for (int movieNumber = 0; movieNumber < numberOfMovies; movieNumber++)
        {
            movieList.add(new Movie(
                    "Movie" + movieNumber,
                    2000 + movieNumber,
                    "Director" + movieNumber,
                    1));
        }

        return movieList;
    }
}