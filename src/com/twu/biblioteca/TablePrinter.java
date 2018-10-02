package com.twu.biblioteca;

public class TablePrinter
{
    private static final String HEADING = "=";
    private static final String ROW_SEPARATOR = "-";
    private static final String COLUMN_SEPARATOR = "|";
    private static final String SPACE = " ";
    private final int tableWidth;

    public TablePrinter(int tableWidth)
    {
        this.tableWidth = tableWidth;
    }

    public void printHeading()
    {
        printRepeatedString(HEADING, tableWidth);
        System.out.println();
    }

    public void printRowSeparator()
    {
        printRepeatedString(ROW_SEPARATOR, tableWidth);
        System.out.println();
    }

    public void printSpaces(int numberOfSpaces)
    {
        printRepeatedString(SPACE, numberOfSpaces);
    }

    public void printColumnSeparator()
    {
        System.out.print(COLUMN_SEPARATOR);
    }

    public void printRepeatedString(String characterToPrint, int length)
    {
        for (int charNum = 0; charNum < length; charNum++) {
            System.out.print(characterToPrint);
        }
    }

    public void printNewLine()
    {
        System.out.println();
    }

    public void printTableEntry(String headingString)
    {
        printTableEntryWithLeftPadding(headingString, 1);
    }

    public void printTableEntryWithLeftPadding(String headingString, int paddingAmount)
    {
        System.out.print(COLUMN_SEPARATOR);
        for (int paddingNumber = 0; paddingNumber < paddingAmount; paddingNumber++) {
            System.out.print(SPACE);
        }
        System.out.print(headingString);
        System.out.print(SPACE);
    }
}
