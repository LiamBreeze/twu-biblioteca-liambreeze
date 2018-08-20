package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ConsoleTestRule implements TestRule
{
    private final SystemOutRule systemOutMock = new SystemOutRule().enableLog().muteForSuccessfulTests();
    private final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
    private final RuleChain systemInAndOutRuleChain = RuleChain.outerRule(systemOutMock).around(systemInMock);

    public void assertSTDOutContains(String[] expectedOutputPerLine, int lineOffset)
    {
        String[] stdOutLogLines = getSTDOutSplitPerLine();

        for (int index = 0; index < expectedOutputPerLine.length; index++)
        {
            Assert.assertEquals(expectedOutputPerLine[index], stdOutLogLines[index + lineOffset]);
        }
    }

    public void addUserInputSequence(String[] userInput)
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
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                systemInAndOutRuleChain.apply(base, description).evaluate();
            }
        };
    }
}
