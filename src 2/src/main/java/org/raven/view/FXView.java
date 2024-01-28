
package org.raven.view;

import javafx.application.Application;

import org.raven.controller.GlobalMessageHandler;


public class FXView implements Runnable {

    private GlobalMessageHandler _gbHandler;


    @Override
    public void run() {
        _gbHandler = GlobalMessageHandler.getInstance();
        int msg = _gbHandler.listen2model();

        System.out.println("Message from model:"+ msg);
        Application.launch(UIComponents.class);
    }

    public FXView(){}
}
