package com.java.roadmap.string;

public class StringBufferAndBuider {
    public static void main(String[] args) {
        Thread thread1 = new StringBufferSynchronized("Thread 1");
        Thread thread2 = new StringBufferSynchronized("Thread 2");
        thread1.start();
        thread2.start();

        StringBuilder stringBuilder = new StringBuilder();
        Thread thread3 = new StringBuiderNonSynchronized("Thread 3", stringBuilder);
        Thread thread4 = new StringBuiderNonSynchronized("Thread 4", stringBuilder);
        thread3.start();
        thread4.start();
    }

}

class StringBufferSynchronized extends Thread {
    StringBuffer stringBuffer = new StringBuffer();

    public StringBufferSynchronized(String name) {
        super(name);
    }

    public void run() {
        synchronized (stringBuffer) {
            stringBuffer.append("Iam ");
            stringBuffer.append("is ");
            stringBuffer.append("StringBuffer of ");
            stringBuffer.append(Thread.currentThread().getName());
            stringBuffer.append("\n");
            System.out.print(stringBuffer);
        }
    }
}

class StringBuiderNonSynchronized extends Thread {
    StringBuilder stringBuilder;

    public StringBuiderNonSynchronized(String name, StringBuilder stringBuilder) {
        super(name);
        this.stringBuilder = stringBuilder;
    }

    public void run() {
        stringBuilder.append("Iam ");
        stringBuilder.append("is ");
        stringBuilder.append("StringBuilder of ");
        stringBuilder.append(Thread.currentThread().getName());
        stringBuilder.append("\n");
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
