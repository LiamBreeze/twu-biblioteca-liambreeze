package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.LIST_BOOKS;
    }

    @Override
    public boolean select(ArrayList<Book> bookList)
    {
        return listBooks(bookList);
    }

    private boolean listBooks(ArrayList<Book> bookList)
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList(bookList);

        return false;
    }
}
