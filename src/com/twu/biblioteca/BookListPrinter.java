package com.twu.biblioteca;

public class BookListPrinter
{
    public void printBookList()
    {
        System.out.println(OutputStrings.TABLE_HEADER);
        printTableTitle();
        System.out.println(OutputStrings.TABLE_ROW_SEPARATOR);
        printBooks();
        System.out.println(OutputStrings.TABLE_HEADER);
    }

    private void printBooks()
    {
        Book[] books = new Book[]
                {
                        new Book("Book1", "Author1", 2001),
                        new Book("Book2", "Author2", 2002),
                };


        for (Book book : books)
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
