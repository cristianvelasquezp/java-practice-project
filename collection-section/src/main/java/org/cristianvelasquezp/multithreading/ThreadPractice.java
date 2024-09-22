package org.cristianvelasquezp.multithreading;

import org.cristianvelasquezp.PrintExamples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        SumThread thread1 = new SumThread(1, Integer.MAX_VALUE / 4);
        SumThread thread2 = new SumThread((Integer.MAX_VALUE / 4) + 1, Integer.MAX_VALUE / 4 * 2);
        SumThread thread3 = new SumThread((Integer.MAX_VALUE / 4 * 2) + 1, Integer.MAX_VALUE / 4 * 3);
        SumThread thread4 = new SumThread((Integer.MAX_VALUE / 4 * 3) + 1, Integer.MAX_VALUE);
        Thread threadExample5 = new Thread(thread1);
        Thread threadExample6 = new Thread(thread2);
        Thread threadExample7 = new Thread(thread3);
        Thread threadExample8 = new Thread(thread4);

        threadExample5.start();
        threadExample6.start();
        threadExample7.start();
        threadExample8.start();

        try {
            threadExample5.join();
            threadExample6.join();
            threadExample7.join();
            threadExample8.join();
            result = thread1.getSum() + thread2.getSum() + thread3.getSum() + thread4.getSum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of 1 to " + Integer.MAX_VALUE + " in two thread is: " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");



        // Thead methods Id and Name

        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread name: " + currentThread.getName());
        System.out.println("Current thread id: " + currentThread.getId());

        // Thread sleep

        try {
            System.out.println("Thread Example before sleep. Thread name: " + Thread.currentThread().getName() + ", time: " + new Date(System.currentTimeMillis()));
            Thread.sleep(3000);
            System.out.println("Thread Example after sleep. Thread name: " + Thread.currentThread().getName() + ", time: " + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread priority. the default priority is 5. The minimum priority is 1 and the maximum priority is 10.
        // we can set the priority using setPriority() method. Even though we can set the priority, it is not guaranteed
        // that the thread with the highest priority will execute first.

        TheadPriorityExample threadExample11 = new TheadPriorityExample();
        Thread threadExample12 = new Thread(threadExample11);
        Thread threadExample9 = new Thread(threadExample11);
        Thread threadExample10 = new Thread(threadExample11);

        threadExample12.setPriority(Thread.MIN_PRIORITY);
        threadExample9.setPriority(Thread.NORM_PRIORITY);
        threadExample10.setPriority(Thread.MAX_PRIORITY);

        threadExample12.start();
        threadExample9.start();
        threadExample10.start();

        try {
            threadExample12.join();
            threadExample9.join();
            threadExample10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Example ending printExamples method. Thread name: " + Thread.currentThread().getName());


        // Atomic operations Definition: An atomic operation is an operation that is performed as a single unit of work
        // without the possibility of interference from other operations. example: incrementing a counter.
        // In Java, the java.util.concurrent.atomic package provides classes that support atomic operations.
        // The classes in this package provide atomic operations on single variables.
        // The classes in this package are thread-safe. This means that multiple threads can access the same variable
        // without any problem.

        // Sometimes when we work with multithreading, and we multiply threads are trying to access the same variable,
        // we can have a problem. For example, if we have a variable that is being incremented by multiple threads,
        // we can have a problem because the threads can read the value of the variable, increment it, and write it back.
        // If two threads read the value of the variable at the same time, they can increment it and write it back.
        // This can cause the value of the variable to be incremented only once instead of twice.
        // To solve this problem, we can use synchronized blocks.


        Counter counter1 = new CounterWithOutSync();

        TheadSyncExample threadExample13 = new TheadSyncExample(counter1);
        TheadSyncExample threadExample14 = new TheadSyncExample(counter1);

        Thread threadExample15 = new Thread(threadExample13);
        Thread threadExample16 = new Thread(threadExample14);

        threadExample15.start();
        threadExample16.start();

        try {
            threadExample15.join();
            threadExample16.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter without sync: " + counter1.getCounter());


        Counter counter2 = new CounterWithMethodSync();

        TheadSyncExample threadExample17 = new TheadSyncExample(counter2);
        TheadSyncExample threadExample18 = new TheadSyncExample(counter2);

        Thread threadExample19 = new Thread(threadExample17);
        Thread threadExample20 = new Thread(threadExample18);

        threadExample19.start();
        threadExample20.start();

        try {
            threadExample19.join();
            threadExample20.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter with sync: " + counter2.getCounter());


        //wait() method is used to pause the current thread execution until unless the specified thread is completed.
        //notify() method is used to wake up the other thread which is paused by wait() method.
        //notifyAll() method is used to wake up all the threads which are paused by wait() method.
        //wait(), notify() and notifyAll() methods are defined in Object class.
        //wait(), notify() and notifyAll() methods can be called only from synchronized method or block.
        //wait(), notify() and notifyAll() methods are used to communicate between threads.
        //wait() method releases the lock or monitor.
        //notify() method doesn't release the lock or monitor.
        //notifyAll() method doesn't release the lock or monitor.
        //wait(), notify() and notifyAll() methods are used to avoid polling.
        //polling is a process of checking continuously the status of the condition when the condition is true.
        //polling is a wastage of CPU cycle.

        ProcessorExample processorExample = new ProcessorExample();

        Thread threadExample21 = new Thread(() -> {
            try {
                processorExample.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadExample22 = new Thread(() -> {
            try {
                processorExample.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadExample21.start();
        threadExample22.start();


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

    class TheadPriorityExample implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority() + " has started");
            }
        }
    }

    class TheadSyncExample implements Runnable {

        private Counter counter;

        TheadSyncExample(Counter counter) {
            this.counter = counter;
        }
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }

    interface Counter {
        void increment();
        int getCounter();
    }

    class CounterWithOutSync implements Counter {
        private int counter = 0;
        public void increment() {
            counter++;
        }
        public int getCounter() {
            return counter;
        }
    }

    class CounterWithMethodSync implements Counter{
        private int counter = 0;
        public synchronized void increment() {
            counter++;
        }
        public int getCounter() {
            return counter;
        }
    }

    class CounterWhitBlockSync implements Counter {
        private int counter = 0;
        public void increment() {
            // the synchronized parameter is the object that we want to lock. the name of this object is monitor. or intrinsic lock.
            // we can use any object as a monitor. but it is recommended to use the object that we want to lock.
            // good example: https://www.udemy.com/course/multithreading-and-parallel-computing-in-java/learn/lecture/6175932#overview
            synchronized (this) {
                counter++;
            }
        }
        public int getCounter() {
            return counter;
        }
    }

    class ProcessorExample {

        private List<Integer> list = new ArrayList<>();
        private static  final int LIMIT = 5;
        private static final int BOTTOM = 0;
        private final Object lock = new Object();
        private int value = 0;

        public void produce() throws InterruptedException {

            synchronized (lock) {
                while (true) {
                    if (list.size() == LIMIT) {
                        System.out.println("Waiting for removing items from the list...");
                        value = 0;
                        lock.wait();
                    } else {
                        System.out.println("Adding: " + value);
                        list.add(value);
                        value++;
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }

        public void consume() throws InterruptedException {

            synchronized (lock) {
                while (true) {
                    if (list.size() == BOTTOM) {
                        System.out.println("Waiting for adding items to the list...");
                        lock.wait();
                    } else {
                        System.out.println("Removing: " + list.remove(list.size() - 1));
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }
    }

}

