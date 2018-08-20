package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ConsoleTestRule implements TestRule
{
    private final SystemOutRule systemOutMock = new SystemOutRule().enableLog().muteForSuccessfulTests();
    private final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    public void assertSTDOutContains(String[] expectedOutputPerLine, int lineOffset)
    {
        String[] stdOutLogLines = getSTDOutSplitPerLine();

        for (int index = 0; index < expectedOutputPerLine.length; index++)
        {
            Assert.assertEquals(expectedOutputPerLine[index], stdOutLogLines[index + lineOffset]);
        }
    }

    public void addUserInputSequence(String userInput)
    {
        systemInMock.provideLines(userInput);
    }

    private String[] getSTDOutSplitPerLine()
    {
        String stdOutLog = systemOutMock.getLogWithNormalizedLineSeparator();
        return stdOutLog.split("\\R");
    }

    @Override
    public Statement apply(final Statement base, final Description description)
    {
        final Statement applySystemOutMock = new Statement()
        {
            @Override
            public void evaluate()
            {
                systemOutMock.apply(base, description);
            }
        };

        Statement applySystemOutAndInMock = new Statement()
        {
            @Override
            public void evaluate()
            {
                systemInMock.apply(applySystemOutMock, description);
            }
        };

        return applySystemOutAndInMock;
    }
}
