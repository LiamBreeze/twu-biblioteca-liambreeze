package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ListBooksOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testListBooksDisplaysBooks()
    {
        ListBooksOption listBooksOption = new ListBooksOption();

        Assert.assertFalse(listBooksOption.select(new Library()));

        String[] listBooksString = new String[]
                {
                        "====================================",
                        "| Title | Author  | Year Published |",
                        "------------------------------------",
                };

        consoleMock.assertSTDOutContains(listBooksString, 0);
    }
}