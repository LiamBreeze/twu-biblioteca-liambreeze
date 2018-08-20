package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MainMenuOptionTest
{
    @Test
    public void testCreateReturnsCorrectClass()
    {
        ArrayList<String[]> testData = new ArrayList<String[]>();
        testData.add(new String[]{"", MainMenuOption.INVALID});
        testData.add(new String[]{"1", MainMenuOption.LIST_BOOKS});
        testData.add(new String[]{"2", MainMenuOption.QUIT});
        testData.add(new String[]{"3", MainMenuOption.CHECKOUT_BOOK});
        testData.add(new String[]{"4", MainMenuOption.RETURN_BOOK});


        for (String[] data : testData)
        {
            String testType = data[0];
            String expectedType = data[1];

            MainMenuOption option = MainMenuOption.create(testType);
            Assert.assertEquals(expectedType, option.getOptionType());
        }
    }
}