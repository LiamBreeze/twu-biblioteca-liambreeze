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

    public int getRating()
    {
        return rating;
    }
}
