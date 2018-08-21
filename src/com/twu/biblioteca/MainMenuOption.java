package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MainMenuOption
{
    public static final String LIST_BOOKS = "1";
    public static final String QUIT = "2";
    public static final String CHECKOUT_BOOK = "3";
    public static final String RETURN_BOOK = "4";
    public static final String INVALID = "";

    public abstract String getOptionType();

    public abstract boolean select(ArrayList<Book> bookList, ArrayList<Book> checkedOutBookList);

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
        }

        return option;
    }

    protected Book getBookFromUser()
    {
        Scanner userInputScanner = new Scanner(System.in);

        Book book = null;

        if (userInputScanner.hasNext())
        {
            String title = userInputScanner.next();

            String author = userInputScanner.next();
            int publishingYear = userInputScanner.nextInt();

            book = new Book(title, author, publishingYear);
        }

        return book;
    }
}
