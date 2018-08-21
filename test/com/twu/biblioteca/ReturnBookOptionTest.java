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

    @Before
    public void setUp()
    {
        returnBookOption = new ReturnBookOption();
    }

    @Test
    public void testReturningNoBooksHasNoEffectOnBookList()
    {
        String[] userInput = {};
        ArrayList<Book> testBookList = buildBookList(1);
        ArrayList<Book> checkedOutBookList = buildBookList(2);

        runReturnBookTest(userInput, testBookList, checkedOutBookList);

        ArrayList<Book> expectedBookList = buildBookList(1);
        Assert.assertEquals(expectedBookList, testBookList);
    }

    @Test
    public void testReturningOneBookAppearsOnBookList()
    {
        String[] userInput = {"Book2", "Author2", "2002"};
        ArrayList<Book> testBookList = buildBookList(1);
        ArrayList<Book> checkedOutBookList = buildBookList(2);

        runReturnBookTest(userInput, testBookList, checkedOutBookList);

        ArrayList<Book> expectedBookList = buildBookList(2);
        Assert.assertEquals(expectedBookList, testBookList);
    }

    @Test
    public void testReturningMultipleBooks()
    {
        String[] userInput =
                {
                        "Book3", "Author3", "2003",
                        "Book4", "Author4", "2004",
                        "Book5", "Author5", "2005",
                };
        ArrayList<Book> testBookList = buildBookList(2);
        ArrayList<Book> checkedOutBookList = buildBookList(5);

        runReturnBookTest(userInput, testBookList, checkedOutBookList);

        ArrayList<Book> expectedBookList = buildBookList(5);
        Assert.assertEquals(expectedBookList, testBookList);
    }

    @Test
    public void testSuccessfullyReturningBookMessage()
    {
        String[] userInput = {"Book2", "Author2", "2002"};
        ArrayList<Book> testBookList = new ArrayList<Book>();
        ArrayList<Book> checkedOutBookList = buildBookList(2);

        runReturnBookTest(userInput, testBookList, checkedOutBookList);

        String[] expectedOutput = new String[]
                {
                        "Thank you for returning the book",
                };
        consoleMock.assertSTDOutContains(expectedOutput, 0);
    }

    @Test
    public void testUnsuccessfullyReturningBookMessage()
    {
        String[] userInput = {"Book2", "Author2", "2002"};
        ArrayList<Book> testBookList = new ArrayList<Book>();
        ArrayList<Book> checkedOutBookList = buildBookList(1);

        runReturnBookTest(userInput, testBookList, checkedOutBookList);

        String[] expectedOutput = new String[]
                {
                        "That is not a valid book to return"
                };
        consoleMock.assertSTDOutContains(expectedOutput, 0);
    }

    private void runReturnBookTest(String[] userInput, ArrayList<Book> testBookList, ArrayList<Book> checkedOutBookList)
    {
        consoleMock.addUserInputSequence(userInput);

        for (int testCount = 0; testCount < userInput.length; testCount += 3)
        {
            Assert.assertFalse(returnBookOption.select(testBookList, checkedOutBookList));
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