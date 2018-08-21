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

        for (String option : MainMenuOption.getOptionsList())
        {
            stringBuilder.append("  ");
            stringBuilder.append(option);
            stringBuilder.append(") ");
            stringBuilder.append(MainMenuOption.create(option));
            stringBuilder.append(OutputStrings.NEW_LINE_SEPARATOR);
        }

        return stringBuilder.toString();
    }
}
