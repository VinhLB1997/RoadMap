package com.java.roadmap.compare_technical;

import java.util.concurrent.CompletableFuture;

public class NonBlockingAndBlocking {
    public static void main(String[] args) throws InterruptedException {

        long startTime1 = System.currentTimeMillis();
        System.out.println(NonBlockingAndBlocking.processTask1());
        System.out.println(NonBlockingAndBlocking.processTask2());
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("Thời gian thực thi program blocking: " + elapsedTime1 + "ms");

        Thread.sleep(3000);

        long startTime2 = System.currentTimeMillis();
        CompletableFuture.supplyAsync(() -> NonBlockingAndBlocking.processTask1())
                .thenAccept(result -> System.out.println(result));
        System.out.println(NonBlockingAndBlocking.processTask2());
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Thời gian thực thi program non-blocking: " + elapsedTime2 + "ms");

    }

    private static String processTask1(){
        System.out.println("Start process 1");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "End process 1";
    }

    private static String processTask2(){
        System.out.println("Start process 2");
        try{
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "End process 2";
    }
}
