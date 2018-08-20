package com.twu.biblioteca;

import java.util.ArrayList;

public class BookListPrinter
{
    public void printBookList(ArrayList<Book> bookList)
    {
        System.out.println(OutputStrings.TABLE_HEADER);
        printTableTitle();
        System.out.println(OutputStrings.TABLE_ROW_SEPARATOR);
        printBooks(bookList);
        System.out.println(OutputStrings.TABLE_HEADER);
    }

    private void printBooks(ArrayList<Book> bookList)
    {
        for (Book book : bookList)
        {
            printBook(book);
        }
    }

    private void printTableTitle()
    {
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(1);

        System.out.print(OutputStrings.TITLE);

        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(1);

        System.out.print(OutputStrings.AUTHOR);

        printSpaces(1);
        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(1);

        System.out.print(OutputStrings.YEAR_PUBLISHED);

        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);

        System.out.println();
    }

    private void printBook(Book book)
    {
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(1);

        System.out.print(book.getTitle());

        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(1);

        System.out.print(book.getAuthor());

        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);
        printSpaces(11);

        System.out.print(book.getPublishingYear());

        printSpaces(1);
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR);

        System.out.println();
    }

    private void printSpaces(int numberOfSpaces)
    {
        for (int spaceNumber = 0; spaceNumber < numberOfSpaces; spaceNumber++)
        {
            System.out.print(OutputStrings.SPACE);
        }
    }

}
