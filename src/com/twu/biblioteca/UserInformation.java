package com.twu.biblioteca;

import java.util.Scanner;

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

    public static UserInformation create()
    {
        return create(getUserUsername(), getUserPassword());
    }

    public static UserInformation create(String username, String password)
    {
        UserInformation userInformation = null;

        if (isUserLoginSuccessful(username, password)) {
            userInformation = new UserInformation("name", "email", "00000 000 000");
        }

        return userInformation;
    }

    private static String getUserUsername()
    {
        String username = null;
        Scanner input = new Scanner(System.in);

        System.out.print("Username: ");
        if (input.hasNext()) {
            username = input.next();
        }

        return username;
    }

    private static String getUserPassword()
    {
        String password = null;
        Scanner input = new Scanner(System.in);

        System.out.print("Password: ");
        if (input.hasNext()) {
            password = input.next();
        }
        System.out.println();

        return password;
    }

    private static boolean isUserLoginSuccessful(String username, String password)
    {
        return username != null &&
                password != null &&
                username.equals("xxx-xxxx") &&
                password.equals("password");
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
}
