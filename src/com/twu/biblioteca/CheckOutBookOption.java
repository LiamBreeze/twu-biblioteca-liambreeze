package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutBookOption extends MainMenuOption
{
    private final ArrayList<Book> bookList;
    private final Scanner userInputScanner;

    public CheckOutBookOption(ArrayList<Book> bookList)
    {
        this.bookList = bookList;
        this.userInputScanner = new Scanner(System.in);
    }

    @Override
    public boolean showResult()
    {
        String bookTitle = getBookTitleFromUser();
        String bookAuthor = getBookAuthorFromUser();
        int bookReleaseDate = getBookReleaseDateFromUser();

        Book book = new Book(bookTitle, bookAuthor, bookReleaseDate);
        bookList.remove(book);

        return false;
    }

    private int getBookReleaseDateFromUser()
    {
        return userInputScanner.nextInt();
    }

    private String getBookAuthorFromUser()
    {
        return userInputScanner.next();
    }

    private String getBookTitleFromUser()
    {
        return userInputScanner.next();
    }
}
