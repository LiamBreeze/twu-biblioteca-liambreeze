package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BibliotecaTest
{
    @Rule
    public final ConsoleTestRule consoleTestMock = new ConsoleTestRule();

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp()
    {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testAppDisplaysWelcomeMessageOnStartup()
    {
        bibliotecaApp.start();

        String[] expectedOutputPerLine = new String[]
                {
                        "Welcome to Biblioteca.",
                };

        consoleTestMock.assertSTDOutContains(expectedOutputPerLine, 1);
    }

    @Test
    public void testAppDisplaysOptionsOnStartup()
    {
        bibliotecaApp.start();

        String[] expectedOptionsString = new String[]
                {
                        "Options:",
                        "  1) List Books",
                };

        consoleTestMock.assertSTDOutContains(expectedOptionsString, 3);
    }

    @Test
    public void testAppDisplaysListOfBooksWhenSelected()
    {
        consoleTestMock.addUserInputSequence("1");

        bibliotecaApp.start();

        String[] bookDetails = new String[]
                {
                        "====================================",
                        "| Title | Author  | Year Published |",
                        "------------------------------------",
                };

        consoleTestMock.assertSTDOutContains(bookDetails, 5);
    }

    @Test
    public void testInvalidMenuOptionPrintsOutMessage()
    {
        consoleTestMock.addUserInputSequence("0");

        bibliotecaApp.start();

        String[] expectedMessage = new String[]
                {
                        "Select a valid option!",
                };

        consoleTestMock.assertSTDOutContains(expectedMessage, 5);
    }
}