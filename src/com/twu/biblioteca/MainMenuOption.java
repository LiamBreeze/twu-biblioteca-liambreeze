package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    static final HashMap<String, MainMenuOption> optionListMap = new HashMap<String, MainMenuOption>();

    static
    {
        optionListMap.put(LIST_BOOKS, new ListBooksOption());
        optionListMap.put(CHECKOUT_BOOK, new CheckoutBookOption());
        optionListMap.put(RETURN_BOOK, new ReturnBookOption());
        optionListMap.put(LIST_MOVIES, new ListMoviesOption());
        optionListMap.put(CHECKOUT_MOVIE, new CheckoutMovieOption());
        optionListMap.put(USER_INFORMATION, new UserInformationOption());
        optionListMap.put(QUIT, new QuitOption());
    }

    public static MainMenuOption create(String type)
    {
        MainMenuOption option = optionListMap.get(type);

        if (option == null)
        {
            option = new InvalidOption();
        }

        return option;
    }

    public static List<String> getOptionsList()
    {
        return new ArrayList<String>(optionListMap.keySet());
    }

    public abstract String getOptionType();

    public abstract boolean select(Library library);
}
