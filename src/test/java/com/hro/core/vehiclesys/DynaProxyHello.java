package com.hro.core.vehiclesys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyHello implements InvocationHandler {

    private Object proxy;

    private Object target;

    public Object bind(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Class clazz = this.proxy.getClass();
        System.out.println("方法前......");
        result = method.invoke(this.target, args);
        System.out.println("方法后......");
        return result;
    }
}
