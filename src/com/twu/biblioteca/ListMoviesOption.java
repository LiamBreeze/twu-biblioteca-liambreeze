package com.twu.biblioteca;

public class ListMoviesOption extends MainMenuOption
{
    @Override
    public String getOptionType()
    {
        return MainMenuOption.LIST_MOVIES;
    }

    @Override
    public boolean select(Library library)
    {
        library.listAvailableMovies();

        return false;
    }

    @Override
    public String toString()
    {
        return "List movies";
    }
}
