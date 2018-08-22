package com.twu.biblioteca;

public class UserInformation
{
    private String name;
    private String emailAddress;
    private String phoneNumber;

    private UserInformation(String name, String emailAddress, String phoneNumber)
    {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public static UserInformation createUserLogin(String username, String password)
    {
        UserInformation userInformation = null;

        if (isUserLoginSuccessful(username, password))
        {
            userInformation = new UserInformation("name", "email", "00000 000 000");
        }

        return userInformation;
    }

    public String getName()
    {
        return name;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    private static boolean isUserLoginSuccessful(String username, String password)
    {
        return username != null &&
                password != null &&
                username.equals("xxx-xxxx") &&
                password.equals("password");
    }
}
