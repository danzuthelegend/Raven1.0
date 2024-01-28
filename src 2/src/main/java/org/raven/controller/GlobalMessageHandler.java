package org.raven.controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GlobalMessageHandler {

    private static GlobalMessageHandler _gbHandler;
    private final BlockingQueue<Integer> _v2mQ;
    private final BlockingQueue<Integer> _m2vQ;
    private boolean _synchronus;

    public static synchronized GlobalMessageHandler getInstance()
    {
        if (_gbHandler == null){
            _gbHandler = new GlobalMessageHandler();
        }
        return _gbHandler;
    }

    private GlobalMessageHandler()
    {
        _v2mQ = new LinkedBlockingQueue<>();
        _m2vQ = new LinkedBlockingQueue<>();
        _synchronus = false;
    }

    public void msg2model(int message) {
        try {
            _v2mQ.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during sending a message", e);
        }
    }

    public int listen2model() {
        try {
            return _m2vQ.take();
            } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during receiving a message", e);
        }
    }


    public void msg2view(int message) {
        try {
            _m2vQ.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during sending a message", e);
        }
    }

    public int listen2view() {
        try {
            return _v2mQ.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during receiving a message", e);
    }
    }

        public boolean IsSynchronus(){
            return _synchronus;
        }

        public int InitializeSynchronization(){
            _synchronus = true;
            return 0;
        }
}
