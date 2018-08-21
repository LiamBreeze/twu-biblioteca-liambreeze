package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckoutBookOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.CHECKOUT_BOOK;
    }

    @Override
    public boolean select(ArrayList<Book> bookList, ArrayList<Book> checkedOutBookList)
    {
        return checkoutBook(bookList, getBookFromUser(), checkedOutBookList);
    }

    private boolean checkoutBook(ArrayList<Book> bookList, Book book, ArrayList<Book> checkoutBookList)
    {
        if (bookList.contains(book))
        {
            bookList.remove(book);
            checkoutBookList.add(book);
            System.out.println(OutputStrings.CHECK_OUT_BOOK_SUCCESS_MESSAGE);
        }
        else
        {
            System.out.println(OutputStrings.CHECK_OUT_BOOK_UNSUCCESSFUL_MESSAGE);
        }

        return false;
    }
}
