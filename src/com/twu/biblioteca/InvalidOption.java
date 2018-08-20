package com.twu.biblioteca;

public class InvalidOption extends MainMenuOption
{

    @Override
    public boolean showResult()
    {
        System.out.println(OutputStrings.INVALID_MENU_OPTION_SELECTED);
        return false;
    }
}
