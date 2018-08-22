package com.twu.biblioteca;

public class CheckoutMovieOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.CHECKOUT_MOVIE;
    }

    @Override
    public boolean select(Library library)
    {
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTION_CHECKOUT_MOVIE;
    }
}
