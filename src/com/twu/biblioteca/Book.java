package com.twu.biblioteca;

public class Book
{
    private final String title;
    private final String author;

    public Book(String inTitle, String inAuthor)
    {
        title = inTitle;
        author = inAuthor;
    }

    @Override
    public String toString()
    {
        return title + " | " + author;
    }
}
