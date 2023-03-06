package com.java.roadmap.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread("Thread 1") {
            public void run() {
                    try {
                        Exam.processExam(this.getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        };
        Thread thread2 = new Thread("Thread 2") {
            public void run() {
                    try {
                        Exam.processExam(this.getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        };
        thread1.setPriority(2);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();
    }
}

@Getter
@Setter
class Exam {
    private static String timeStart = LocalTime.now().toString();
    private static String timeEnd = LocalTime.now().plusMinutes(45).toString();

    synchronized static void processExam(String threadName) throws InterruptedException {
        System.out.println(threadName + ": Time Start at " + timeStart);
        System.out.println(threadName + ": Đang làm bài thi");
        Thread.sleep(5000);
        System.out.println(threadName + ": Time End at " + timeEnd);
    }
}
