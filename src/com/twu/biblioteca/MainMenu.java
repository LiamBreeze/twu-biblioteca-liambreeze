package com.twu.biblioteca;

public class MainMenu
{
    public boolean selectOption(Library library, String userOptionSelection)
    {
        MainMenuOption selectedOption = MainMenuOption.create(userOptionSelection);

        return selectedOption.select(library);
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
