package com.twu.biblioteca;

public class UserInformationOption extends MainMenuOption
{
    public static final String USER_INFORMATION_NAME = "Name:          ";
    public static final String USER_INFORMATION_EMAIL_ADDRESS = "Email address: ";
    public static final String USER_INFORMATION_PHONE_NUMBER = "Phone number:  ";

    @Override
    public String getOptionType()
    {
        return MainMenuOption.USER_INFORMATION;
    }

    @Override
    public boolean select(Library library)
    {
        UserInformation userinformation = UserInformation.create();

        if (userinformation != null) {
            System.out.println(USER_INFORMATION_NAME + userinformation.getName());
            System.out.println(USER_INFORMATION_EMAIL_ADDRESS + userinformation.getEmailAddress());
            System.out.println(USER_INFORMATION_PHONE_NUMBER + userinformation.getPhoneNumber());
        } else {
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
