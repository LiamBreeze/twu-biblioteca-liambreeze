package com.twu.biblioteca;

public class BookListPrinter
{
    public void printBookList()
    {
        printTableHeader();
        printTableTitle();
        printTableSeparator();
        printBooks();
        printTableHeader();
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
        printTableColumnSeparator();
        printSpaces(1);

        System.out.print(OutputStrings.TITLE);

        printSpaces(1);
        printTableColumnSeparator();
        printSpaces(1);

        System.out.print(OutputStrings.AUTHOR_STRING);

        printSpaces(1);
        printSpaces(1);
        printTableColumnSeparator();
        printSpaces(1);

        System.out.print(OutputStrings.YEAR_PUBLISHED_STRING);

        printSpaces(1);
        printTableColumnSeparator();

        System.out.println();
    }

    private void printBook(Book book)
    {
        printTableColumnSeparator();
        printSpaces(1);

        System.out.print(book.getTitle());

        printSpaces(1);
        printTableColumnSeparator();
        printSpaces(1);

        System.out.print(book.getAuthor());

        printSpaces(1);
        printTableColumnSeparator();
        printSpaces(11);

        System.out.print(book.getPublishingYear());

        printSpaces(1);
        printTableColumnSeparator();

        System.out.println();
    }

    private void printSpaces(int numberOfSpaces)
    {
        for (int spaceNumber = 0; spaceNumber < numberOfSpaces; spaceNumber++)
        {
            System.out.print(OutputStrings.SPACE_STRING);
        }
    }

    private void printTableColumnSeparator()
    {
        System.out.print(OutputStrings.TABLE_COLUMN_SEPARATOR_STRING);
    }

    private void printTableSeparator()
    {
        System.out.println(OutputStrings.TABLE_ROW_SEPARATOR);
    }

    private void printTableHeader()
    {
        System.out.println(OutputStrings.TABLE_HEADER_STRING);
    }
}
