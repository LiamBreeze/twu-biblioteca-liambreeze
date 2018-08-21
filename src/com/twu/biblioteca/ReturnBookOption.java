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
        library.returnBook(getBookFromUser());
        return false;
    }
}
