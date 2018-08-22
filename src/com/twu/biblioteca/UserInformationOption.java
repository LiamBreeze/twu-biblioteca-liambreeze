package com.twu.biblioteca;

public class UserInformationOption extends MainMenuOption
{

    @Override
    public String getOptionType()
    {
        return MainMenuOption.USER_INFORMATION;
    }

    @Override
    public boolean select(Library library)
    {
        String username = getUserUsername();
        String password = getUserPassword();
        System.out.println();

        UserInformation userinformation = UserInformation.createUserLogin(username, password);

        if (userinformation != null)
        {
            System.out.println("Name: " + userinformation.getName());
            System.out.println("Email address: " + userinformation.getEmailAddress());
            System.out.println("Phone number: " + userinformation.getPhoneNumber());
        }
        else
        {
            System.out.println(OutputStrings.UNABLE_TO_LOGIN);
        }

        return false;
    }

    @Override
    public String toString()
    {
        return OutputStrings.OPTIONS_USER_INFORMATION;
    }
}
