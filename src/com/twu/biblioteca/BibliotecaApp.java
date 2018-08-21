package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp
{
    private MainMenu mainMenu;
    private Library library;

    public static void main(String[] args)
    {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public BibliotecaApp()
    {
        library = new Library();
        mainMenu = new MainMenu();
    }

    public void start()
    {
        System.out.println();
        printWelcomeMessage();
        System.out.println();
        System.out.println(mainMenu);
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
                String userOptionSelection = userInputScanner.next();
                isQuitSelected = mainMenu.selectOption(library, userOptionSelection);
            }
        }
    }

    private void printWelcomeMessage()
    {
        System.out.println(OutputStrings.WELCOME_MESSAGE);
    }
}
