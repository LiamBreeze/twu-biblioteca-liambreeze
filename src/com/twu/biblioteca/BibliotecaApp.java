package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp
{
    private static final int OPTIONS_LIST_BOOKS = 1;

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

        if (userInputScanner.hasNext())
        {
            int userOptionSelection = userInputScanner.nextInt();

            if (userOptionSelection == OPTIONS_LIST_BOOKS)
            {
                BookListPrinter bookListPrinter = new BookListPrinter();
                bookListPrinter.printBookList();
            }
        }
    }

    private void printOptions()
    {
        System.out.println(OutputStrings.OPTIONS_STRING);
        System.out.println(OutputStrings.OPTIONS_LIST_BOOKS_STRING);
    }

    private void printWelcomeMessage()
    {
        System.out.println(OutputStrings.WELCOME_MESSAGE_STRING);
    }
}
