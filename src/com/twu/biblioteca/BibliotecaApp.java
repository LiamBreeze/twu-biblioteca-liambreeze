package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp
{
    private ArrayList<Book> bookList;
    private MainMenu mainMenu;

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

        mainMenu = new MainMenu(bookList);
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
                isQuitSelected = mainMenu.selectOption(userOptionSelection);
            }
        }
    }

    private void printWelcomeMessage()
    {
        System.out.println(OutputStrings.WELCOME_MESSAGE);
    }
}
