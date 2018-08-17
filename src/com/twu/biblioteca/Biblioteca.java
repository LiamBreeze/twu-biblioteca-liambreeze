package com.twu.biblioteca;

public class Biblioteca
{
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca.";

    public void start()
    {
        System.out.println(WELCOME_MESSAGE);

        String[] books = new String[]
                {
                        "Book1",
                        "Book2",
                };

        for (String book : books)
        {
            System.out.println(book);
        }
    }
}
