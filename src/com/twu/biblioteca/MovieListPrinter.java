package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieListPrinter
{
    public static final int TABLE_WIDTH = 46;

    private static final String NAME_HEADING = "Name";
    private static final String RELEASE_YEAR_HEADING = "Release Year";
    private static final String DIRECTOR_HEADING = "Director";
    private static final String RATING_HEADING = "Rating";


    private final TablePrinter tablePrinter;

    public MovieListPrinter()
    {
        tablePrinter = new TablePrinter(TABLE_WIDTH);
    }

    public void printMovieList(ArrayList<Movie> movies)
    {
        tablePrinter.printHeading();
        printTitle();
        tablePrinter.printRowSeparator();
        printMovies(movies);
        tablePrinter.printHeading();
    }

    private void printMovies(ArrayList<Movie> movies)
    {
        for (Movie movie : movies)
        {
            printMovie(movie);
        }
    }

    private void printMovie(Movie movie)
    {
        tablePrinter.printTableEntry(movie.getTitle());
        tablePrinter.printTableEntryWithLeftPadding(Integer.toString(movie.getReleaseYear()), 9);
        tablePrinter.printTableEntry(movie.getDirector());
        tablePrinter.printTableEntryWithLeftPadding(Integer.toString(movie.getRating()), 6);
        tablePrinter.printColumnSeparator();
        tablePrinter.printNewLine();
    }

    private void printTitle()
    {
        tablePrinter.printTableEntryWithLeftPadding(NAME_HEADING, 4);
        tablePrinter.printTableEntry(RELEASE_YEAR_HEADING);
        tablePrinter.printTableEntryWithLeftPadding(DIRECTOR_HEADING, 2);
        tablePrinter.printTableEntry(RATING_HEADING);
        tablePrinter.printColumnSeparator();
        tablePrinter.printNewLine();
    }

}
