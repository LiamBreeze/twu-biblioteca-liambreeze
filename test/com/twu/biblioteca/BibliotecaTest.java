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
    public void testAppDisplaysWelcomeMessageOnStart()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();

        String stdOutLog = systemOutRule.getLogWithNormalizedLineSeparator();
        String[] stdOutLogLines = stdOutLog.split("\\R");

        assertEquals("Welcome to Biblioteca.", stdOutLogLines[0]);
        assertEquals("Book1", stdOutLogLines[1]);
    }
}