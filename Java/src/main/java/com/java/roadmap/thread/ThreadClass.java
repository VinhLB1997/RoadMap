package com.java.roadmap.thread;

public class ThreadClass {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new NumberOperator("Thread 1");
        Thread thread2 = new NumberOperator("Thread 2");
        Thread thread3 = new NumberOperator("Thread 3");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}

class NumberOperator extends Thread {
    public NumberOperator(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            String array[] = {"Sum running in Thread", "Decide running in Thread"};
            System.out.println(this.getName() + " đang " + array[0]);
            Thread.sleep(3000);
            System.out.println(this.getName() + " đang " + array[1]);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
