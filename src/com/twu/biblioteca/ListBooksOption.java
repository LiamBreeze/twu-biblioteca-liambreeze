package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption extends MainMenuOption
{
    private ArrayList<Book> bookList;

    public ListBooksOption(ArrayList<Book> bookList)
    {
        this.bookList = bookList;
    }

    @Override
    public boolean showResult()
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList(bookList);
        return false;
    }
}
