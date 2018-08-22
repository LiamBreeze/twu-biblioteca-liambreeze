package com.twu.biblioteca;

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
        library.returnBook(UserInformation.create(), Book.createBookFromUserInput());
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_RETURN_BOOK;
    }
}
