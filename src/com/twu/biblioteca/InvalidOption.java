package com.twu.biblioteca;

import java.util.ArrayList;

public class InvalidOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.INVALID;
    }

    @Override
    public boolean select(ArrayList<Book> bookList)
    {
        System.out.println(OutputStrings.INVALID_MENU_OPTION_SELECTED);

        return false;
    }
}
