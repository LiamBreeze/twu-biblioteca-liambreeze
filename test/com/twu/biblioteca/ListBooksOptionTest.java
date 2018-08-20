package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class ListBooksOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testListBooksDisplaysBooks()
    {
        MainMenu listBooksOption = new MainMenu(new ArrayList<Book>());

        Assert.assertFalse(listBooksOption.selectOption(MainMenuOption.LIST_BOOKS));

        String[] listBooksString = new String[]
                {
                        "====================================",
                        "| Title | Author  | Year Published |",
                        "------------------------------------",
                };

        consoleMock.assertSTDOutContains(listBooksString, 0);
    }
}