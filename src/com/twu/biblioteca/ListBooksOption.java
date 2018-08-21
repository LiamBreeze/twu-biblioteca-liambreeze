package com.twu.biblioteca;

public class ListBooksOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.LIST_BOOKS;
    }

    @Override
    public boolean select(Library library)
    {
        library.listAvailableBooks();

        return false;
    }
}
