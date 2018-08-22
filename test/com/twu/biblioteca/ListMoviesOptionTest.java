package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListMoviesOptionTest
{

    @Test
    public void testSelect()
    {
        Library library = new Library();
        ListMoviesOption testListMoviesOption = new ListMoviesOption();

        Assert.assertFalse("List movies option should not quit the app.",
                testListMoviesOption.select(library));
    }
}