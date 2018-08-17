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
        assertEquals("Welcome to Biblioteca.\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }
}