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
}
