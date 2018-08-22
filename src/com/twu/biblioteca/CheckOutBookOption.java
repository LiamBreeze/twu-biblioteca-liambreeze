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
        library.checkoutBook(UserInformation.create(), Book.createBookFromUserInput());
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_CHECK_OUT_BOOK;
    }
}
