package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MovieTest
{
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private Movie testMovieWithRating;
    private Movie testMovieWithoutRating;

    @Before
    public void setUp()
    {
        testMovieWithRating = new Movie("", 0, "", 1);
        testMovieWithoutRating = new Movie("", 0, "");
    }

    @Test
    public void testHasRating()
    {
        Assert.assertTrue("Movie with rating should have a movie rating available.",
                testMovieWithRating.hasRating());

        Assert.assertFalse("Movie without rating should not have a movie rating.",
                testMovieWithoutRating.hasRating());
    }

    @Test
    public void testGetRatingException()
    {
        testMovieWithRating.getRating();

        expectedException.expect(MovieHasNoRatingException.class);
        testMovieWithoutRating.getRating();
    }
}