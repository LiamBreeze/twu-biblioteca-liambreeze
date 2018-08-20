package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class CheckOutBookOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testCheckedOutBooksAreNotListed()
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Book1", "Author1", 2001));
        bookList.add(new Book("Book2", "Author2", 2002));

        consoleMock.addUserInputSequence(new String[]
                {
                        "Book1",
                        "Author1",
                        "2001"
                });
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(bookList);
        checkOutBookOption.showResult();


        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("Book2", "Author2", 2002));

        Assert.assertEquals(expectedBookList, bookList);
    }
}