package com.twu.biblioteca;

import java.util.ArrayList;

public class BookListPrinter
{
    public static final int TABLE_WIDTH = 36;

    public static final String TITLE = "Title";
    public static final String AUTHOR = "Author";
    public static final String YEAR_PUBLISHED = "Year Published";


    private final TablePrinter tablePrinter;

    public BookListPrinter()
    {
        this.tablePrinter = new TablePrinter(TABLE_WIDTH);
    }

    public void printBookList(ArrayList<Book> bookList)
    {
        tablePrinter.printHeading();
        printTableTitle();
        tablePrinter.printRowSeparator();
        printBooks(bookList);
        tablePrinter.printHeading();
    }

    private void printTableTitle()
    {
        tablePrinter.printTableEntry(TITLE);
        tablePrinter.printTableEntry(AUTHOR);
        tablePrinter.printSpaces(1);
        tablePrinter.printTableEntry(YEAR_PUBLISHED);
        tablePrinter.printColumnSeparator();
        tablePrinter.printNewLine();
    }

    private void printBooks(ArrayList<Book> bookList)
    {
        for (Book book : bookList) {
            printBook(book);
        }
    }

    private void printBook(Book book)
    {
        tablePrinter.printTableEntry(book.getTitle());
        tablePrinter.printTableEntry(book.getAuthor());
        tablePrinter.printTableEntryWithLeftPadding(Integer.toString(book.getPublishingYear()), 11);
        tablePrinter.printColumnSeparator();
        tablePrinter.printNewLine();
    }

}
