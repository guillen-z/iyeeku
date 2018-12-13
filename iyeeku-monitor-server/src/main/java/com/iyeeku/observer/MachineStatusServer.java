package com.iyeeku.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * “被观察者”
 */
public class MachineStatusServer implements IyeekuMachineStatusObserverable {

    private List<IyeekuMessageListener> listeners;
    private String message;

    public MachineStatusServer(){
        listeners = new ArrayList<>();
    }

    @Override
    public void registerObserver(IyeekuMessageListener o) {
        listeners.add(o);
    }

    @Override
    public void removeObserver(IyeekuMessageListener o) {
        if (!listeners.isEmpty()){
            listeners.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (IyeekuMessageListener listener : listeners){
            listener.onMessage(message);
        }
    }


}