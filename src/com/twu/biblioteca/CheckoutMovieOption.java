package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        library.checkoutMovie(getMovieFromUser());
        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTION_CHECKOUT_MOVIE;
    }

    private Movie getMovieFromUser()
    {
        Scanner userInputScanner = new Scanner(System.in);

        String title = getMovieTitleFromUser(userInputScanner);
        int releaseYear = getMovieReleaseYearFromUser(userInputScanner);
        String director = getMovieDirectorFromUser(userInputScanner);
        int rating = getMovieRatingFromUser(userInputScanner);

        System.out.println();

        return new Movie(title, releaseYear, director, rating);
    }

    private String getMovieTitleFromUser(Scanner input)
    {
        System.out.print(OutputStrings.REQUEST_MOVIE_TITLE);

        String title = null;

        if (input.hasNext()) {
            title = input.next();
        }

        return title;
    }

    private int getMovieReleaseYearFromUser(Scanner input)
    {
        System.out.print(OutputStrings.REQUEST_MOVIE_RELEASE_YEAR);

        int releaseYear = 0;

        if (input.hasNext()) {
            releaseYear = input.nextInt();
        }

        return releaseYear;
    }

    private String getMovieDirectorFromUser(Scanner input)
    {
        System.out.print(OutputStrings.REQUEST_MOVIE_DIRECTOR);

        String director = null;

        if (input.hasNext()) {
            director = input.next();
        }

        return director;
    }

    private int getMovieRatingFromUser(Scanner input)
    {
        System.out.print(OutputStrings.REQUEST_MOVIE_RATING);

        int rating = 0;

        if (input.hasNext()) {
            try {
                rating = input.nextInt();
            } catch (InputMismatchException exception) {
            }
        }

        return rating;
    }
}
