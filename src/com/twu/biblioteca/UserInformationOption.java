package com.twu.biblioteca;

public class UserInformationOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.USER_INFORMATION;
    }

    @Override
    public boolean select(Library library)
    {
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_USER_INFORMATION;
    }
}
