package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBookOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.RETURN_BOOK;
    }

    @Override
    public boolean select(ArrayList<Book> bookList)
    {
        return returnBook(bookList, getBookFromUser());
    }

    private boolean returnBook(ArrayList<Book> bookList, Book book)
    {
        if (book != null)
        {
            bookList.add(book);
        }

        return false;
    }
}
