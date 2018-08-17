package com.twu.biblioteca;

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
}
