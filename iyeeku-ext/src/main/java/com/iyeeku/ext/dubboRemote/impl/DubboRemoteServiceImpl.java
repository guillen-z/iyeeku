package com.iyeeku.ext.dubboRemote.impl;

import com.iyeeku.ext.dubboRemote.IDubboRemoteService;

public class DubboRemoteServiceImpl implements IDubboRemoteService {

    @Override
    public void sayHello() {
        System.out.println("hello dubbo!!");
    }

    @Override
    public void sayHello123() {
        System.out.println("sayHello123");
    }

    @Override
    public void sayHello123456() {
        System.out.println("sayHello123456");
    }

}
