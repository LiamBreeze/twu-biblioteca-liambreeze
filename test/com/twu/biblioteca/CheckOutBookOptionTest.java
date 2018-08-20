package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class CheckOutBookOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private ArrayList<Book> bookList;
    private CheckOutBookOption checkOutBookOption;

    @Before
    public void setUp()
    {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Book1", "Author1", 2001));
        bookList.add(new Book("Book2", "Author2", 2002));

        checkOutBookOption = new CheckOutBookOption(bookList);
    }

    @Test
    public void testCheckedOutBooksAreNotListed()
    {
        selectBook();
        Assert.assertFalse(checkOutBookOption.showResult());
        assertBookWasRemoved();
    }

    @Test
    public void testSuccessfulBookCheckoutMessage()
    {
        selectBook();
        Assert.assertFalse(checkOutBookOption.showResult());
        assertSuccessMessageWasPrinted();
    }

    private void selectBook()
    {
        consoleMock.addUserInputSequence(new String[]
                {
                        "Book1",
                        "Author1",
                        "2001"
                });
    }

    private void assertBookWasRemoved()
    {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("Book2", "Author2", 2002));

        Assert.assertEquals(expectedBookList, bookList);
    }

    private void assertSuccessMessageWasPrinted()
    {
        String[] expectedMessage = new String[]
                {
                        "Thank you! Enjoy the book",
                };

        consoleMock.assertSTDOutContains(expectedMessage, 0);
    }
}