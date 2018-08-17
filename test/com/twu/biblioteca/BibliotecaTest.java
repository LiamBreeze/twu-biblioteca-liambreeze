package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class BibliotecaTest
{
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Test
    public void testAppDisplaysWelcomeMessageAndListOfBooksOnStart()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();

        String[] expectedOutputPerLine = new String[]
                {
                        "Welcome to Biblioteca.",
                        "Book1",
                        "Book2",
                };
        String[] stdOutLogLines = getSTDOutSplitPerLine();

        for (int index = 0; index < expectedOutputPerLine.length; index++)
        {
            assertEquals(expectedOutputPerLine[index], stdOutLogLines[index]);
        }
    }

    private String[] getSTDOutSplitPerLine()
    {
        String stdOutLog = systemOutRule.getLogWithNormalizedLineSeparator();
        return stdOutLog.split("\\R");
    }
}