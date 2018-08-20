package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp
{

    public static void main(String[] args)
    {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start()
    {
        System.out.println();
        printWelcomeMessage();
        System.out.println();
        printOptions();
        handleUserSelection();
    }

    private void handleUserSelection()
    {
        Scanner userInputScanner = new Scanner(System.in);

        boolean isQuitSelected = false;

        while (!isQuitSelected)
        {
            if (userInputScanner.hasNext())
            {
                int userOptionSelectionID = userInputScanner.nextInt();

                MainMenuOption userOptionSelection = MainMenuOption.getMainMenuOption(userOptionSelectionID);
                isQuitSelected = userOptionSelection.showResult();
            }
        }
    }

    private void printOptions()
    {
        System.out.println(OutputStrings.OPTIONS);
        System.out.println(OutputStrings.OPTIONS_LIST_BOOKS);
    }

    private void printWelcomeMessage()
    {
        System.out.println(OutputStrings.WELCOME_MESSAGE);
    }
}
