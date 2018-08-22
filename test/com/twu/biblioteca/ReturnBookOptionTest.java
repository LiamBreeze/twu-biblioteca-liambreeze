package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class ReturnBookOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    private ReturnBookOption returnBookOption;
    private Library testLibrary;

    @Before
    public void setUp()
    {
        returnBookOption = new ReturnBookOption();
        testLibrary = new Library();
    }

    @Test
    public void testReturningNoBooksHasNoEffectOnBookList()
    {
        String[] userInput = {};
        runReturnBookTest(userInput);
        assertAvailableBooks(buildBookList(2));
    }

    @Test
    public void testReturningOneBookAppearsOnBookList()
    {
        String[] userInput = {"Book2", "Author2", "2002"};

        Book checkedOutBook = new Book("Book2", "Author2", 2002);
        testLibrary.checkoutBook("username", "password", checkedOutBook);

        runReturnBookTest(userInput);

        assertAvailableBooks(buildBookList(2));
    }

    @Test
    public void testReturningMultipleBooks()
    {
        String[] userInput =
                {
                        "Book1", "Author1", "2001",
                        "Book2", "Author2", "2002",
                };

        Book checkedOutBook = new Book("Book1", "Author1", 2001);
        testLibrary.checkoutBook("username", "password", checkedOutBook);
        checkedOutBook = new Book("Book2", "Author2", 2002);
        testLibrary.checkoutBook("username", "password", checkedOutBook);

        runReturnBookTest(userInput);

        assertAvailableBooks(buildBookList(2));
    }

    @Test
    public void testSuccessfullyReturningBookMessage()
    {
        String[] userInput = {"Book2", "Author2", "2002"};

        Book checkedOutBook = new Book("Book2", "Author2", 2002);
        testLibrary.checkoutBook("username", "password", checkedOutBook);

        consoleMock.clearSTDOut();

        runReturnBookTest(userInput);

        assertSuccessfulMessageDisplayed();
    }

    @Test
    public void testUnsuccessfullyReturningBookMessage()
    {
        String[] userInput = {"Book2", "Author2", "2002"};

        runReturnBookTest(userInput);

        assertUnsuccessfulMessageDisplayed();
    }

    private void assertUnsuccessfulMessageDisplayed()
    {
        String[] expectedOutput = new String[]
                {
                        "That is not a valid book to return"
                };
        consoleMock.assertSTDOutContains(expectedOutput, 1);
    }

    private void assertAvailableBooks(ArrayList<Book> books)
    {
        consoleMock.clearSTDOut();

        testLibrary.listAvailableBooks();

        String[] expectedOutput = new String[books.size()];

        for (int index = 0; index < books.size(); index++)
        {
            Book currentBook = books.get(index);
            expectedOutput[index] = "| " + currentBook.getTitle() + " | "
                    + currentBook.getAuthor() + " |           "
                    + currentBook.getPublishingYear() + " |";
        }

        consoleMock.assertSTDOutContains(expectedOutput, 3);
    }

    private void assertSuccessfulMessageDisplayed()
    {
        String[] expectedOutput = new String[]
                {
                        "Thank you for returning the book",
                };
        consoleMock.assertSTDOutContains(expectedOutput, 1);
    }

    private void runReturnBookTest(String[] userInput)
    {
        consoleMock.addUserInputSequence(userInput);

        for (int testCount = 0; testCount < userInput.length; testCount += 3)
        {
            Assert.assertFalse(returnBookOption.select(testLibrary));
        }
    }

    private ArrayList<Book> buildBookList(int numberOfBooksRequested)
    {
        ArrayList<Book> bookList = new ArrayList<Book>();

        for (int bookNumber = 1; bookNumber <= numberOfBooksRequested; bookNumber++)
        {
            bookList.add(new Book("Book" + bookNumber,
                    "Author" + bookNumber,
                    2000 + bookNumber));
        }

        return bookList;
    }
}