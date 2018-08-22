package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnBookOption extends MainMenuOption
{

    @Override
    public String getOptionType()
    {
        return MainMenuOption.RETURN_BOOK;
    }

    @Override
    public boolean select(Library library)
    {
        Scanner userInputScanner = new Scanner(System.in);

        String username = getUserUsername(userInputScanner);
        String password = getUserPassword(userInputScanner);

        System.out.println();

        library.returnBook(username, password, getBookFromUser());
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_RETURN_BOOK;
    }
}
