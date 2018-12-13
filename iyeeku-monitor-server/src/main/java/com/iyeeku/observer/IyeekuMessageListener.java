package com.iyeeku.observer;

public interface IyeekuMessageListener {
    /**
     * 抽象观察者，定义了一个onMessage()方法，当“被观察者”调用xxx方法时，观察者的 onMessage 方法会被回调
     * @param message
     */
    public void onMessage(String message);

}
