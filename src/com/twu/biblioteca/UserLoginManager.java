package com.twu.biblioteca;

public class UserLoginManager
{
    public boolean loginUser(String username, String password)
    {
        return isUserLoginSuccessful(username, password);
    }

    private static boolean isUserLoginSuccessful(String username, String password)
    {
        return username != null &&
                password != null &&
                username.equals("username") &&
                password.equals("password");
    }
}
