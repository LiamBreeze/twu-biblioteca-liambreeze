package com.twu.biblioteca;

public class ListBooksOption extends MainMenuOption
{

    @Override
    public boolean showResult()
    {
        BookListPrinter bookListPrinter = new BookListPrinter();
        bookListPrinter.printBookList();
        return false;
    }
}
