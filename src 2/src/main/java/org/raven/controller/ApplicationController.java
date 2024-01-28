package org.raven.controller;

import org.raven.view.FXView;
import org.raven.models.Model;

public class ApplicationController {

    private GlobalMessageHandler _gbHandler;

    private Thread  _fxThread;
    private FXView  _fxView;
    private Thread  _modelThread;
    private Model   _model;

    public void run()
    {
        loadUIComponents();
        loadModels();
        InitializeSynchronizationSequence();

        try {
            _fxThread.join();
            System.out.println("_fxThread joint");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public ApplicationController()
    {
        _fxView   = new FXView();
        _fxThread = new Thread(_fxView);

        _model    = new Model();
        _modelThread = new Thread(_model);

        _gbHandler = GlobalMessageHandler.getInstance();
    
    }

    public void loadUIComponents()
    {

        _fxThread.start();

    }
    public void loadModels()
    {
        _modelThread.start();
    }
    public void InitializeSynchronizationSequence()
    {
        _gbHandler.InitializeSynchronization();
    }

}
