package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBookOption extends MainMenuOption
{
    public ReturnBookOption(ArrayList<Book> bookList)
    {
        super(bookList);
    }

    @Override
    public boolean showResult()
    {
        if (userInputScanner.hasNext())
        {
            String bookTitle = userInputScanner.next();
            String bookAuthor = userInputScanner.next();
            int publishingYear = userInputScanner.nextInt();

            bookList.add(new Book(bookTitle, bookAuthor, publishingYear));
        }

        return false;
    }
}
