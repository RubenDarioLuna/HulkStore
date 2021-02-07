package com.hulkstore.logic.commands;

import com.hulkstore.persistence.DBHandler;

public abstract class Command<T>
{
    private DBHandler _handler;

    public Command()
    {
    }

    public Command( DBHandler handler )
    {
        _handler = handler;
    }

    public abstract void execute();

    public abstract T getReturnParam();

    public void closeSession()
    {
        _handler.finishTransaction();
        _handler.closeSession();
    }

    protected void createSession( boolean transaction )
    {
        _handler = new DBHandler();

        if( transaction )
            _handler.beginTransaction();
    }

    protected DBHandler getHandler()
    {
        return _handler;
    }
}
