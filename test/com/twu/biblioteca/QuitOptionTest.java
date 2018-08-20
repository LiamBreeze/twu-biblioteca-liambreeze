package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class QuitOptionTest
{

    @Test
    public void testQuitReturnsTrue()
    {
        MainMenu quitOption = new MainMenu(null);

        Assert.assertTrue(quitOption.selectOption(MainMenuOption.QUIT));
    }
}