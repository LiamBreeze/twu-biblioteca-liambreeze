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
        InvalidOption invalidOption = new InvalidOption();

        Assert.assertFalse(invalidOption.select(new Library()));

        String[] expectedMessage = new String[]
                {
                        "Select a valid option!",
                };

        consoleMock.assertSTDOutContains(expectedMessage, 0);
    }
}