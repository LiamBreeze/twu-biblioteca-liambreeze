package com.twu.biblioteca;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuOptionTest
{
    @Test
    public void testMainMenuOptionInvalid()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption(0, null);
        Assert.assertThat(menuOption, new IsInstanceOf(InvalidOption.class));
    }

    @Test
    public void testMainMenuOptionListBooks()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption(MainMenuOption.LIST_BOOKS, null);
        Assert.assertThat(menuOption, new IsInstanceOf(ListBooksOption.class));
    }

    @Test
    public void testMainMenuOptionQuit()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption(MainMenuOption.QUIT, null);
        Assert.assertThat(menuOption, new IsInstanceOf(QuitOption.class));
    }

    @Test
    public void testMainMenuOptionCheckOutBook()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption(MainMenuOption.CHECK_OUT_BOOK, null);
        Assert.assertThat(menuOption, new IsInstanceOf(CheckOutBookOption.class));
    }
}