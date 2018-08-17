package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest
{

    @Test
    public void testToStringReturnsTitleAndAuthor()
    {
        Book book = new Book("title", "author");
        Assert.assertEquals("title | author", book.toString());
    }
}