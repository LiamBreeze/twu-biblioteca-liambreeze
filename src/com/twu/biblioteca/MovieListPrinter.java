package com.twu.biblioteca;

public class MovieListPrinter
{
    public static final int TABLE_WIDTH = 43;

    private static final String NAME_HEADING = "Name";
    private static final String RELEASE_YEAR_HEADING = "Release Year";
    private static final String DIRECTOR_HEADING = "Director";
    private static final String RATING_HEADING = "Rating";


    private final TablePrinter tablePrinter;

    public MovieListPrinter()
    {
        tablePrinter = new TablePrinter(TABLE_WIDTH);
    }

    public void printMovieList()
    {
        tablePrinter.printHeading();
        printTitle();
        tablePrinter.printRowSeparator();
        tablePrinter.printHeading();
    }

    private void printTitle()
    {
        tablePrinter.printTableEntry(NAME_HEADING);
        tablePrinter.printTableEntry(RELEASE_YEAR_HEADING);
        tablePrinter.printTableEntry(DIRECTOR_HEADING);
        tablePrinter.printTableEntry(RATING_HEADING);
        tablePrinter.printColumnSeparator();
        tablePrinter.printNewLine();
    }

}
