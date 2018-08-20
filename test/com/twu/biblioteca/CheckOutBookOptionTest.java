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
        selectBook("Book1", "Author1", "2001");
        Assert.assertFalse(checkOutBookOption.showResult());
        assertBookWasRemoved();
    }

    @Test
    public void testSuccessfulBookCheckoutMessage()
    {
        selectBook("Book1", "Author1", "2001");
        Assert.assertFalse(checkOutBookOption.showResult());
        assertSuccessMessageWasPrinted();
    }

    @Test
    public void testUnsuccessfulBookCheckoutMessage()
    {
        selectBook("Book3", "Author3", "2003");
        Assert.assertFalse(checkOutBookOption.showResult());
        assertUnsuccessfulMessageWasPrinted();
    }

    private void selectBook(String title, String author, String yearPublished)
    {
        consoleMock.addUserInputSequence(new String[]
                {
                        title,
                        author,
                        yearPublished
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

    private void assertUnsuccessfulMessageWasPrinted()
    {
        String[] expectedMessage = new String[]
                {
                        "That book is not available",
                };
        consoleMock.assertSTDOutContains(expectedMessage, 0);
    }
}