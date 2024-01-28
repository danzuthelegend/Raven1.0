package org.raven.models;

import org.raven.controller.GlobalMessageHandler;

public class Model implements Runnable {

    private GlobalMessageHandler _gbHandler;

    @Override
    public void run() {
        _gbHandler = GlobalMessageHandler.getInstance();

        while(!_gbHandler.IsSynchronus())
        {

        }
        System.out.println("Message sent:");
        _gbHandler.msg2view(101);
    }

    public Model(){}
}
