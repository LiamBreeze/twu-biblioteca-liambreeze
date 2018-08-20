package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

public class BookListPrinterTest
{
    @Rule
    public final ConsoleTestRule consoleTestMock = new ConsoleTestRule();

    @Test
    public void printBookList()
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList();

        String[] bookDetails = new String[]
                {
                        "====================================",
                        "| Title | Author  | Year Published |",
                        "------------------------------------",
                        "| Book1 | Author1 |           2001 |",
                        "| Book2 | Author2 |           2002 |",
                        "====================================",
                };

        consoleTestMock.assertSTDOutContains(bookDetails, 0);
    }
}