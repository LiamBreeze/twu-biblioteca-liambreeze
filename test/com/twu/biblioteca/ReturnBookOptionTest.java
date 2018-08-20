package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

public class ReturnBookOptionTest
{
    @Rule
    public final ConsoleTestRule consoleMock = new ConsoleTestRule();

    @Test
    public void testReturningNoBooksHasNoEffectOnBookList()
    {
        int numberOfTestBooks = 2;
        String[] userInput = {};

        testReturnBook(numberOfTestBooks, userInput, buildBookList(2));
    }

    @Test
    public void testReturningOneBookAppearsOnBookList()
    {
        int numberOfTestBooks = 1;
        String[] userInput = {"Book2", "Author2", "2002"};

        testReturnBook(numberOfTestBooks, userInput, buildBookList(2));
    }

    @Test
    public void testReturningMultipleBooks()
    {
        int numberOfTestBooks = 2;
        String[] userInput =
                {
                        "Book3", "Author3", "2003",
                        "Book4", "Author4", "2004",
                        "Book5", "Author5", "2005",
                };

        testReturnBook(numberOfTestBooks, userInput, buildBookList(5));
    }

    private void testReturnBook(int numberOfBooksRequested, String[] userInput, ArrayList<Book> expectedBookList)
    {
        ArrayList<Book> testBookList = buildBookList(numberOfBooksRequested);

        MainMenu returnBookOption = new MainMenu(testBookList);

        consoleMock.addUserInputSequence(userInput);

        for (int testCount = 0; testCount < userInput.length; testCount += 3)
        {
            Assert.assertFalse(returnBookOption.selectOption(MainMenuOption.RETURN_BOOK));
        }

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