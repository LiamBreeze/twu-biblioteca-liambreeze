package com.twu.biblioteca;

public class Biblioteca
{
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca.";

    public void start()
    {
        System.out.println(WELCOME_MESSAGE);

        Book[] books = new Book[]
                {
                        new Book("Book1", "Author1", 2001),
                        new Book("Book2", "Author2", 2002),
                };


        for (Book book : books)
        {
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getPublishingYear());
        }
    }
}
