package com.twu.biblioteca;

import java.util.Scanner;

public class Book
{
    private final String title;
    private final String author;
    private final int publishingYear;

    public Book(String inTitle, String inAuthor, int inPublishingYear)
    {
        title = inTitle;
        author = inAuthor;
        publishingYear = inPublishingYear;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getPublishingYear()
    {
        return publishingYear;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (other == null || getClass() != other.getClass())
        {
            return false;
        }

        Book book = (Book) other;

        return publishingYear == book.publishingYear
                && title.equals(book.title)
                && author.equals(book.author);
    }

    @Override
    public int hashCode()
    {
        return title.hashCode() + author.hashCode() + publishingYear;
    }

    public static Book createBookFromUserInput()
    {
        Scanner userInputScanner = new Scanner(System.in);

        Book book = null;

        System.out.print(OutputStrings.REQUEST_BOOK_TITLE);
        if (userInputScanner.hasNext())
        {
            String title = userInputScanner.next();

            System.out.print(OutputStrings.REQUEST_BOOK_AUTHOR);
            String author = userInputScanner.next();

            System.out.print(OutputStrings.REQUEST_BOOK_PUBLISHING_YEAR);
            int publishingYear = userInputScanner.nextInt();

            System.out.println();

            book = new Book(title, author, publishingYear);
        }

        return book;
    }
}
