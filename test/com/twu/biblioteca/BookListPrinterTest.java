package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class BookListPrinterTest
{
    @Rule
    public final ConsoleTestRule consoleTestMock = new ConsoleTestRule();

    @Test
    public void printBookList()
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book1", "Author1", 2001));
        bookList.add(new Book("Book2", "Author2", 2002));

        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList(bookList);

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