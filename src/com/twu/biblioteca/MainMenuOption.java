package com.twu.biblioteca;

public abstract class MainMenuOption
{
    public static final int LIST_BOOKS = 1;
    public static final int QUIT = 2;
    public static final int CHECK_OUT_BOOK = 3;

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

            case CHECK_OUT_BOOK:
                optionSelected = new CheckOutBookOption();
                break;
        }

        return optionSelected;
    }

    public static void printOptions()
    {
        System.out.println(OutputStrings.OPTIONS);
        System.out.println(OutputStrings.OPTIONS_LIST_BOOKS);
        System.out.println(OutputStrings.OPTIONS_QUIT);
        System.out.println(OutputStrings.OPTIONS_CHECK_OUT_BOOK);
    }

    public abstract boolean showResult();
}
