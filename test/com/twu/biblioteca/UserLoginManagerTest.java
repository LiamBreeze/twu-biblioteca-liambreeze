package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserLoginManagerTest
{

    @Test
    public void testLoginUser()
    {
        UserLoginManager testUserLoginManager = new UserLoginManager();

        String validUsername = "username";
        String validPassword = "password";
        Assert.assertTrue(testUserLoginManager.loginUser(validUsername, validPassword));

        String invalidPassword = ".";
        String invalidUsername = ".";
        Assert.assertFalse(testUserLoginManager.loginUser(invalidUsername, invalidPassword));
    }
}