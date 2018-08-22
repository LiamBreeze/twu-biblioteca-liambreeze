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

        UserLoginManager userLoginManager = new UserLoginManager();

        if (!userLoginManager.loginUser(username, password))
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
