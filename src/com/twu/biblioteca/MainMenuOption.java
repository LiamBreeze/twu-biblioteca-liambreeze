package com.twu.biblioteca;

public abstract class MainMenuOption
{
    public static final int LIST_BOOKS = 1;
    public static final int QUIT = 2;

    public static MainMenuOption getMainMenuOption(int userOptionSelectionID)
    {
        MainMenuOption optionSelected = new InvalidOption();

        switch (userOptionSelectionID)
        {
            case LIST_BOOKS:
                optionSelected = new ListBooksOption();
                break;

            case QUIT:
                optionSelected = new QuitOption();
                break;
        }

        return optionSelected;
    }

    public abstract boolean showResult();
}
