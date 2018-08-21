package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CheckoutBookOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private CheckoutBookOption checkOutBookOption;
    private Library testLibrary;

    @Before
    public void setUp()
    {
        checkOutBookOption = new CheckoutBookOption();
        testLibrary = new Library();
    }

    @Test
    public void testCheckedOutBooksAreNotListed()
    {
        selectBook("Book1", "Author1", "2001");
        Assert.assertFalse(checkOutBookOption.select(testLibrary));
        assertBookWasRemoved();
    }

    @Test
    public void testSuccessfulBookCheckoutMessage()
    {
        selectBook("Book1", "Author1", "2001");
        Assert.assertFalse(checkOutBookOption.select(testLibrary));
        assertSuccessMessageWasPrinted();
    }

    @Test
    public void testUnsuccessfulBookCheckoutMessage()
    {
        selectBook("Book3", "Author3", "2003");
        Assert.assertFalse(checkOutBookOption.select(testLibrary));
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
        testLibrary.listAvailableBooks();

        String[] outputWithoutBook1 = new String[]
                {
                        "| Book2 | Author2 |           2002 |"
                };
        consoleMock.assertSTDOutContains(outputWithoutBook1, 5);
    }

    private void assertSuccessMessageWasPrinted()
    {
        String[] expectedMessage = new String[]
                {
                        "Thank you! Enjoy the book",
                };

        consoleMock.assertSTDOutContains(expectedMessage, 1);
    }

    private void assertUnsuccessfulMessageWasPrinted()
    {
        String[] expectedMessage = new String[]
                {
                        "That book is not available",
                };
        consoleMock.assertSTDOutContains(expectedMessage, 1);
    }
}