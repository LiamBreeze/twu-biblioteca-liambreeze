package com.twu.biblioteca;

public class Biblioteca
{
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca.";

    public void start()
    {
        System.out.println();
        printWelcomeMessage();
        System.out.println();
        printTableOfBookDetails();
    }

    private void printTableOfBookDetails()
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
            System.out.println("| " + book.getTitle()
                    + " | " + book.getAuthor()
                    + " |           " + book.getPublishingYear() + " |");
        }
    }

    private void printTableSeparator()
    {
        System.out.println("------------------------------------");
    }

    private void printTableTitle()
    {
        System.out.println("| Title | Author  | Year Published |");
    }

    private void printTableHeader()
    {
        System.out.println("====================================");
    }

    private void printWelcomeMessage()
    {
        System.out.println(WELCOME_MESSAGE);
    }
}
