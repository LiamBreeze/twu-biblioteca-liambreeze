package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaTest
{
    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog().muteForSuccessfulTests();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp()
    {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testAppDisplaysWelcomeMessageAndOptionsOnStartup()
    {
        bibliotecaApp.start();

        String[] expectedOutputPerLine = new String[]
                {
                        "",
                        "Welcome to Biblioteca.",
                        "",
                        "Options:",
                        "  1) List Books"
                };

        assertSTDOutEquals(expectedOutputPerLine, 0);
    }

    @Test
    public void testAppDisplaysListOfBooksWhenSelected()
    {
        addUserInputSequence("1");

        bibliotecaApp.start();

        String[] bookDetails = new String[]
                {
                        "====================================",
                        "| Title | Author  | Year Published |",
                        "------------------------------------",
                        "| Book1 | Author1 |           2001 |",
                        "| Book2 | Author2 |           2002 |",
                        "====================================",
                };

        assertSTDOutEquals(bookDetails, 5);
    }

    private void assertSTDOutEquals(String[] expectedOutputPerLine, int lineOffset)
    {
        String[] stdOutLogLines = getSTDOutSplitPerLine();

        for (int index = 0; index < expectedOutputPerLine.length; index++)
        {
            assertEquals(expectedOutputPerLine[index], stdOutLogLines[index + lineOffset]);
        }
    }

    private void addUserInputSequence(String userInput)
    {
        systemInMock.provideLines(userInput);
    }

    private String[] getSTDOutSplitPerLine()
    {
        String stdOutLog = systemOutMock.getLogWithNormalizedLineSeparator();
        return stdOutLog.split("\\R");
    }
}