package com.twu.biblioteca;

public class CheckoutBookOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.CHECKOUT_BOOK;
    }

    @Override
    public boolean select(Library library)
    {
        library.checkoutBook(getBookFromUser());
        return false;
    }
}
