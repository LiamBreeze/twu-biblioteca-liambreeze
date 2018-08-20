package com.twu.biblioteca;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuOptionOptionTest
{
    @Test
    public void testMainMenuOptionInvalid()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption("0", null);
        Assert.assertThat(menuOption, new IsInstanceOf(InvalidOption.class));
    }

    @Test
    public void testMainMenuOptionListBooks()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption("1", null);
        Assert.assertThat(menuOption, new IsInstanceOf(ListBooksOption.class));
    }

    @Test
    public void testMainMenuOptionQuit()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption("2", null);
        Assert.assertThat(menuOption, new IsInstanceOf(QuitOption.class));
    }

    @Test
    public void testMainMenuOptionCheckOutBook()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption("3", null);
        Assert.assertThat(menuOption, new IsInstanceOf(CheckOutBookOption.class));
    }

    @Test
    public void testMainMenuOptionReturnBook()
    {
        MainMenuOption menuOption = MainMenuOption.getMainMenuOption("4", null);
        Assert.assertThat(menuOption, new IsInstanceOf(ReturnBookOption.class));
    }
}