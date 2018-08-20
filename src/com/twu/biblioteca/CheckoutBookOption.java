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
    public boolean select(ArrayList<Book> bookList)
    {
        return checkoutBook(bookList, getBookFromUser());
    }

    private boolean checkoutBook(ArrayList<Book> bookList, Book book)
    {
        boolean isDeleteSuccessful = bookList.remove(book);

        if (isDeleteSuccessful)
        {
            System.out.println(OutputStrings.CHECK_OUT_BOOK_SUCCESS_MESSAGE);
        } else
        {
            System.out.println(OutputStrings.CHECK_OUT_BOOK_UNSUCCESSFUL_MESSAGE);
        }

        return false;
    }
}
