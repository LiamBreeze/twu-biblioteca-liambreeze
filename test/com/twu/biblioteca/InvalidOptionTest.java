package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class InvalidOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testInvalidOptionPrintsOutMessage()
    {
        MainMenu invalidOption = new MainMenu(null, null);

        Assert.assertFalse(invalidOption.selectOption(""));

        String[] expectedMessage = new String[]
                {
                        "Select a valid option!",
                };

        consoleMock.assertSTDOutContains(expectedMessage, 0);
    }
}