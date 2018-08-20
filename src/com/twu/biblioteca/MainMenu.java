package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu
{
    private final ArrayList<Book> bookList;

    public MainMenu(ArrayList<Book> bookList)
    {
        this.bookList = bookList;
    }

    public boolean selectOption(String userOptionSelection)
    {
        MainMenuOption selectedOption = MainMenuOption.create(userOptionSelection);

        return selectedOption.select(bookList);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(OutputStrings.OPTIONS);
        stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);

        stringBuilder.append(OutputStrings.OPTIONS_LIST_BOOKS);
        stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);
        stringBuilder.append(OutputStrings.OPTIONS_QUIT);
        stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);
        stringBuilder.append(OutputStrings.OPTIONS_CHECK_OUT_BOOK);
        stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);
        stringBuilder.append(OutputStrings.OPTIONS_RETURN_BOOK);
        stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);

        return stringBuilder.toString();
    }
}
