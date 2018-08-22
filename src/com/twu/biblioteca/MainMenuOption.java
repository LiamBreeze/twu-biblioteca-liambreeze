package com.twu.biblioteca;

public abstract class MainMenuOption
{
    public static final String LIST_BOOKS = "1";
    public static final String CHECKOUT_BOOK = "2";
    public static final String RETURN_BOOK = "3";
    public static final String LIST_MOVIES = "4";
    public static final String CHECKOUT_MOVIE = "5";
    public static final String USER_INFORMATION = "6";
    public static final String QUIT = "7";
    public static final String INVALID = "";

    public static final String[] OPTION_LIST = {
            LIST_BOOKS,
            CHECKOUT_BOOK,
            RETURN_BOOK,
            LIST_MOVIES,
            CHECKOUT_MOVIE,
            USER_INFORMATION,
            QUIT,
    };

    public abstract String getOptionType();

    public abstract boolean select(Library library);

    public static MainMenuOption create(String type)
    {
        MainMenuOption option = new InvalidOption();

        if (type.equals(LIST_BOOKS))
        {
            option = new ListBooksOption();
        } else if (type.equals(QUIT))
        {
            option = new QuitOption();
        } else if (type.equals(CHECKOUT_BOOK))
        {
            option = new CheckoutBookOption();
        } else if (type.equals(RETURN_BOOK))
        {
            option = new ReturnBookOption();
        } else if (type.equals(LIST_MOVIES))
        {
            option = new ListMoviesOption();
        } else if (type.equals(CHECKOUT_MOVIE))
        {
            option = new CheckoutMovieOption();
        } else if (type.equals(USER_INFORMATION))
        {
            option = new UserInformationOption();
        }

        return option;
    }

    public static String[] getOptionsList()
    {
        return OPTION_LIST;
    }
}
