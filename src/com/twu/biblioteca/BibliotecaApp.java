package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp
{
    private ArrayList<Book> bookList;

    public static void main(String[] args)
    {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public BibliotecaApp()
    {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Book1", "Author1", 2001));
        bookList.add(new Book("Book2", "Author2", 2002));
    }

    public void start()
    {
        System.out.println();
        printWelcomeMessage();
        System.out.println();
        MainMenuOption.printOptions();
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

                MainMenuOption userOptionSelection = MainMenuOption.getMainMenuOption(userOptionSelectionID, bookList);
                isQuitSelected = userOptionSelection.showResult();
            }
        }
    }

    private void printWelcomeMessage()
    {
        System.out.println(OutputStrings.WELCOME_MESSAGE);
    }
}
