package com.twu.biblioteca;

import java.util.Objects;

public class Movie
{
    private String title;
    private int releaseYear;
    private String director;
    private int rating;

    public Movie(String title, int releaseYear, String director, int rating)
    {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.rating = rating;
    }

    public Movie(String title, int releaseYear, String director)
    {
        this(title, releaseYear, director, 0);
    }

    public String getTitle()
    {
        return title;
    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public String getDirector()
    {
        return director;
    }

    public int getRating() throws MovieHasNoRatingException
    {
        if (hasRating())
        {
            return rating;
        }
        else
        {
            throw new MovieHasNoRatingException();
        }
    }

    public boolean hasRating()
    {
        return rating > 0 && rating < 11;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (other == null || getClass() != other.getClass())
        {
            return false;
        }

        Movie movie = (Movie) other;

        return releaseYear == movie.releaseYear &&
                rating == movie.rating &&
                title.equals(movie.title) &&
                director.equals(movie.director);
    }

    @Override
    public int hashCode()
    {
        return title.hashCode() + releaseYear + director.hashCode() + rating;
    }
}
