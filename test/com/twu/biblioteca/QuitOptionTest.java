package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class QuitOptionTest
{

    @Test
    public void testQuitReturnsTrue()
    {
        QuitOption quitOption = new QuitOption();

        Assert.assertTrue(quitOption.select(new Library()));
    }
}