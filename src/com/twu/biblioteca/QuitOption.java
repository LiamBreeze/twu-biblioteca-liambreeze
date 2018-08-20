package com.twu.biblioteca;

public class QuitOption extends MainMenuOption
{
    public QuitOption()
    {
        super(null);
    }

    @Override
    public boolean showResult()
    {
        return true;
    }
}
