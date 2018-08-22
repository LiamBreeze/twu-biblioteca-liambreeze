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

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_CHECK_OUT_BOOK;
    }
}
