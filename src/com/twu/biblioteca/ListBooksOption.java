package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption extends MainMenuOption
{
    public ListBooksOption(ArrayList<Book> bookList)
    {
        super(bookList);
    }

    @Override
    public boolean showResult()
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList(bookList);
        return false;
    }
}
