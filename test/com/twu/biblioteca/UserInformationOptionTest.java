package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UserInformationOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private UserInformationOption userInformationOption;
    private Library testLibrary;

    @Before
    public void setUp()
    {
        userInformationOption = new UserInformationOption();
        testLibrary = new Library();
    }

    @Test
    public void testSelectDoesNotExitApp()
    {
        Assert.assertFalse(userInformationOption.select(testLibrary));
    }

    @Test
    public void testUserInfoNotDisplayedWhenNotLoggedIn()
    {
        userInformationOption.select(testLibrary);

        String[] expectedOutput = new String[]
                {
                        "Unable to login"
                };
        consoleMock.assertSTDOutContains(expectedOutput, 1);
    }
}