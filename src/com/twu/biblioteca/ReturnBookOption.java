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
    public boolean select(ArrayList<Book> bookList, ArrayList<Book> checkedOutBookList)
    {
        return returnBook(bookList, getBookFromUser(), checkedOutBookList);
    }

    private boolean returnBook(ArrayList<Book> bookList, Book book, ArrayList<Book> checkedOutBookList)
    {
        if (book != null && checkedOutBookList.contains(book))
        {
            checkedOutBookList.remove(book);
            bookList.add(book);

            System.out.println(OutputStrings.BOOK_RETURN_SUCCESS_MESSAGE);
        }

        return false;
    }
}
