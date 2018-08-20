package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuitOptionTest
{

    @Test
    public void testQuitReturnsTrue()
    {
        QuitOption quitOption = new QuitOption();

        Assert.assertTrue(quitOption.showResult());
    }
}