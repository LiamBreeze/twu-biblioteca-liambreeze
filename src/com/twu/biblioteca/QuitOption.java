package com.twu.biblioteca;

public class QuitOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.QUIT;
    }

    @Override
    public boolean select(Library library)
    {
        return true;
    }
}
