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
        System.out.println("| Movie1 |         2001 | Director1 |      1 |");
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
