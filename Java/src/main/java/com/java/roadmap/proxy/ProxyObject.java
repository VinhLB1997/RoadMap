package com.java.roadmap.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Calculator {
    int add(int a, int b);
    void inProcess();
}

class CalculatorImpl implements Calculator {

    public int add(int a, int b) {
        int result = a+b;
        System.out.println(result);
        return result;
    }

    public void inProcess() {
        System.out.println("in process...");
    }
}

class CalculatorProxy implements InvocationHandler {
    private Object target;

    public CalculatorProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method " + method.getName());
        if (result != null && result instanceof Void) {
            return null; // Return null to indicate void return type
        } else {
            return result;
        }
    }
}

public class ProxyObject {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                new CalculatorProxy(calculator)
        );

        int result = proxy.add(1, 2);
        proxy.inProcess();

    }
}