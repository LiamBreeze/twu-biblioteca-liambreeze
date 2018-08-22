package com.twu.biblioteca;

import java.util.Scanner;

public class CheckoutBookOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.CHECKOUT_BOOK;
    }

    @Override
    public boolean select(Library library)
    {
        Scanner userInputScanner = new Scanner(System.in);

        String username = getUserUsername(userInputScanner);
        String password = getUserPassword(userInputScanner);

        System.out.println();

        library.checkoutBook(username, password, getBookFromUser());
        return false;
    }

    private static String getUserUsername(Scanner input)
    {
        String username = null;

        System.out.print("Username: ");
        if (input.hasNext())
        {
            username = input.next();
        }

        return username;
    }

    private static String getUserPassword(Scanner input)
    {
        String password = null;

        System.out.print("Password: ");
        if (input.hasNext())
        {
            password = input.next();
        }

        return password;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_CHECK_OUT_BOOK;
    }
}
