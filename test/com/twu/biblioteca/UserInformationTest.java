package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class UserInformationTest
{

    @Test
    public void testLoginUser()
    {
        UserInformation validUser = UserInformation.create("xxx-xxxx", "password");
        Assert.assertNotNull(validUser);

        UserInformation invalidUser = UserInformation.create("-", "-");
        Assert.assertNull(invalidUser);
    }
}