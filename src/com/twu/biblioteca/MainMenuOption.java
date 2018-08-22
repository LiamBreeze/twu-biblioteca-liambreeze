package com.twu.biblioteca;

import java.util.Scanner;

public abstract class MainMenuOption
{
    public static final String LIST_BOOKS = "1";
    public static final String CHECKOUT_BOOK = "2";
    public static final String RETURN_BOOK = "3";
    public static final String LIST_MOVIES = "4";
    public static final String CHECKOUT_MOVIE = "5";
    public static final String QUIT = "6";
    public static final String INVALID = "";

    public static final String[] OPTION_LIST = {
            LIST_BOOKS,
            CHECKOUT_BOOK,
            RETURN_BOOK,
            LIST_MOVIES,
            CHECKOUT_MOVIE,
            QUIT,
    };

    public abstract String getOptionType();

    public abstract boolean select(Library library);

    public static MainMenuOption create(String type)
    {
        MainMenuOption option = new InvalidOption();

        if (type.equals(LIST_BOOKS))
        {
            option = new ListBooksOption();
        } else if (type.equals(QUIT))
        {
            option = new QuitOption();
        } else if (type.equals(CHECKOUT_BOOK))
        {
            option = new CheckoutBookOption();
        } else if (type.equals(RETURN_BOOK))
        {
            option = new ReturnBookOption();
        } else if (type.equals(LIST_MOVIES))
        {
            option = new ListMoviesOption();
        } else if (type.equals(CHECKOUT_MOVIE))
        {
            option = new CheckoutMovieOption();
        }

        return option;
    }

    public static String[] getOptionsList()
    {
        return OPTION_LIST;
    }

    protected Book getBookFromUser()
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

    protected String getUserUsername(Scanner input)
    {
        String username = null;

        System.out.print("Username: ");
        if (input.hasNext())
        {
            username = input.next();
        }

        return username;
    }

    protected String getUserPassword(Scanner input)
    {
        String password = null;

        System.out.print("Password: ");
        if (input.hasNext())
        {
            password = input.next();
        }

        return password;
    }
}
