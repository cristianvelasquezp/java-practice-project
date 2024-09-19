package org.cristianvelasquezp.multithreading;

import org.cristianvelasquezp.PrintExamples;

public class ThreadPractice implements PrintExamples {

    /*
     * Thread is a lightweight sub-process, the smallest unit of processing.
     * Multiprocessing and multithreading, both are used to achieve multitasking.
     * But we use multithreading than multiprocessing because threads share a common memory area.
     * They don't allocate separate memory area so saves memory, and context-switching between the threads takes less time than process.
     *
     * Thread class is the main class to create a thread. There are two ways to create a thread:
     * 1) By extending Thread class
     * 2) By implementing Runnable interface
     *
     * */

    @Override
    public void printExamples() {
        ThreadExample1 threadExample1 = new ThreadExample1();
        threadExample1.start();

        ThreadExample2 threadExample2 = new ThreadExample2();
        Thread thread = new Thread(threadExample2);
        thread.start();

        // we also can create a thread using inline class
        Thread threadExample3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Example using inline class. Thread name: " + Thread.currentThread().getName());
            }
        });
        threadExample3.start();

        // we also can create a thread using lambda
        Thread threadExample4 = new Thread(() -> System.out.println("Thread Example using lambda. Thread name: " + Thread.currentThread().getName()));
        threadExample4.start();


        System.out.println("Thread Example ending main method. Thread name: " + Thread.currentThread().getName());


        // The method join() allows one thread to wait until another thread completes its execution.



        long result2 = 0;
        long startTime2 = System.currentTimeMillis();

        for (long i = 1; i <= Integer.MAX_VALUE; i++) {
            result2 += i;
        }
        System.out.println("Sum of 1 to " + Integer.MAX_VALUE + " in one thread is: " + result2);

        long endTime2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime2 - startTime2) + " ms");

        long result = 0;
        long startTime = System.currentTimeMillis();
        SumThread thread1 = new SumThread(1, Integer.MAX_VALUE / 2);
        SumThread thread2 = new SumThread((Integer.MAX_VALUE / 2) + 1, Integer.MAX_VALUE);
        Thread threadExample5 = new Thread(thread1);
        Thread threadExample6 = new Thread(thread2);

        threadExample5.start();
        threadExample6.start();

        try {
            threadExample5.join();
            threadExample6.join();
            result = thread1.getSum() + thread2.getSum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of 1 to " + Integer.MAX_VALUE + " in two thread is: " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private class ThreadExample1 extends Thread {
        public void run() {
            System.out.println("Thread Example extending Thread class. Thread name: " + Thread.currentThread().getName());
        }
    }

    private class ThreadExample2 implements Runnable {
        public void run() {
            System.out.println("Thread Example implementing Runnable interface. Thread name: " + Thread.currentThread().getName());
        }
    }

    class SumThread implements Runnable {
        private int start;
        private int end;
        private long sum = 0;

        SumThread(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        }

        public long getSum() {
            return sum;
        }
    }

}

