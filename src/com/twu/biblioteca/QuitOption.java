package com.twu.biblioteca;

import java.util.ArrayList;

public class QuitOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.QUIT;
    }

    @Override
    public boolean select(ArrayList<Book> bookList, ArrayList<Book> checkedOutBookList)
    {
        return true;
    }
}
