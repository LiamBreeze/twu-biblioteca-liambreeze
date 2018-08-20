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

    private ArrayList<Book> expectedBookList;

    @Before
    public void setUp()
    {
        expectedBookList = buildBookList(2);
    }

    @Test
    public void testReturningNoBooksHasNoEffectOnBookList()
    {
        int numberOfTestBooks = 2;
        String[] userInput = {};

        testReturnBook(numberOfTestBooks, userInput);
    }

    @Test
    public void testReturningOneBookAppearsOnBookList()
    {
        int numberOfTestBooks = 1;
        String[] userInput = {"Book2", "Author2", "2002"};

        testReturnBook(numberOfTestBooks, userInput);
    }

    private void testReturnBook(int numberOfBooksRequested, String[] userInput)
    {
        ArrayList<Book> testBookList = buildBookList(numberOfBooksRequested);

        ReturnBookOption returnBookOption = new ReturnBookOption(testBookList);

        consoleMock.addUserInputSequence(userInput);

        Assert.assertFalse(returnBookOption.showResult());
        Assert.assertEquals(expectedBookList, testBookList);
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