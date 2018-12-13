package com.iyeeku.observer;

/**
 * 抽象“被观察者”接口
 */
public interface IyeekuMachineStatusObserverable {

    public void registerObserver(IyeekuMessageListener o);
    public void removeObserver(IyeekuMessageListener o);
    public void notifyObserver();

}
