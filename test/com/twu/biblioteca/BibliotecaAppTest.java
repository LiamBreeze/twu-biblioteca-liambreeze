package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BibliotecaAppTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp()
    {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testAppDisplaysWelcomeMessageOnStartup()
    {
        consoleMock.addUserInputSequence(new String[] { "2" });

        bibliotecaApp.start();

        String[] expectedOutputPerLine = new String[]
                {
                        "Welcome to Biblioteca.",
                };

        consoleMock.assertSTDOutContains(expectedOutputPerLine, 1);
    }

    @Test
    public void testAppDisplaysOptionsOnStartup()
    {
        consoleMock.addUserInputSequence(new String[] { "2" });

        bibliotecaApp.start();

        String[] expectedOptionsString = new String[]
                {
                        "Options:",
                        "  1) List Books",
                };

        consoleMock.assertSTDOutContains(expectedOptionsString, 3);
    }

    @Test
    public void testReEnteringMainMenuSelection()
    {
        consoleMock.addUserInputSequence(new String[] { "0", "0", "2"});

        bibliotecaApp.start();

        String[] expectedMessage = new String[]
                {
                        "Select a valid option!",
                };

        consoleMock.assertSTDOutContains(expectedMessage, 6);
    }
}