package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReturnBookOptionTest
{
    @Test
    public void testReturningNoBooksHasNoEffectOnBookList()
    {
        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Book1", "Author1", 2001));
        testBookList.add(new Book("Book2", "Author2", 2002));

        ReturnBookOption returnBookOption = new ReturnBookOption();

        Assert.assertFalse(returnBookOption.showResult());

        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("Book1", "Author1", 2001));
        expectedBookList.add(new Book("Book2", "Author2", 2002));


        Assert.assertEquals(expectedBookList, testBookList);
    }
}