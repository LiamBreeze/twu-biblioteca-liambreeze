package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MainMenuOption
{
    protected final ArrayList<Book> bookList;
    protected final Scanner userInputScanner;

    public MainMenuOption(ArrayList<Book> bookList)
    {
        this.bookList = bookList;
        this.userInputScanner = new Scanner(System.in);
    }

    public enum Options
    {
        LIST_BOOKS
                {
                    @Override
                    public String toString()
                    {
                        return OutputStrings.OPTIONS_LIST_BOOKS;
                    }
                },
        QUIT
                {
                    @Override
                    public String toString()
                    {
                        return OutputStrings.OPTIONS_QUIT;
                    }
                },
        CHECK_OUT_BOOK
                {
                    @Override
                    public String toString()
                    {
                        return OutputStrings.OPTIONS_CHECK_OUT_BOOK;
                    }
                },
        RETURN_BOOK
                {
                    @Override
                    public String toString()
                    {
                        return OutputStrings.OPTIONS_RETURN_BOOK;
                    }
                };

        public static Options getFromInputString(String inputString)
        {
            Options resultOption = null;

            if (inputString.equals("1"))
            {
                resultOption = LIST_BOOKS;
            }
            else if (inputString.equals("2"))
            {
                resultOption = QUIT;
            }
            else if (inputString.equals("3"))
            {
                resultOption = CHECK_OUT_BOOK;
            }
            else if (inputString.equals("4"))
            {
                resultOption = RETURN_BOOK;
            }

            return resultOption;
        }
    }

    public static MainMenuOption getMainMenuOption(String userOptionSelectionID, ArrayList<Book> bookList)
    {
        MainMenuOption optionSelected = new InvalidOption();

        Options selectedOptionEnum = Options.getFromInputString(userOptionSelectionID);

        if (selectedOptionEnum != null)
        {
            switch (selectedOptionEnum)
            {
                case LIST_BOOKS:
                    optionSelected = new ListBooksOption(bookList);
                    break;

                case QUIT:
                    optionSelected = new QuitOption();
                    break;

                case CHECK_OUT_BOOK:
                    optionSelected = new CheckOutBookOption(bookList);
                    break;

                case RETURN_BOOK:
                    optionSelected = new ReturnBookOption(bookList);
                    break;
            }
        }

        return optionSelected;
    }

    public static void printMainMenu()
    {
        System.out.println(OutputStrings.OPTIONS);

        for (Options mainMenuOption : MainMenuOption.Options.values())
        {
            System.out.println(mainMenuOption.toString());
        }
    }

    public abstract boolean showResult();
}
