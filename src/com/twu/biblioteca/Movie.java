package com.twu.biblioteca;

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
}
