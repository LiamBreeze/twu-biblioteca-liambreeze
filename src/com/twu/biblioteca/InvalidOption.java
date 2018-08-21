package com.twu.biblioteca;

public class InvalidOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.INVALID;
    }

    @Override
    public boolean select(Library library)
    {
        System.out.println(OutputStrings.INVALID_MENU_OPTION_SELECTED);

        return false;
    }
}
