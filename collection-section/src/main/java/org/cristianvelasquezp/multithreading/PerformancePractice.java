package org.cristianvelasquezp.multithreading;

import org.cristianvelasquezp.PrintExamples;

public class PerformancePractice implements PrintExamples {
    @Override
    public void printExamples() {
        // some time we want to run a task in parallel to improve performance. it is because we want more speed.
        // in this case the performance is measured in latency. so the faster, the better.
        // an example can be when we want to reproduce a video, we want to reproduce the video as fast as possible so the
        // user can see the video without any delay.
        // other way to measure performance is throughput. in this case we want to process as many requests as possible.
        // an example can be when we have a web server, we want to process as many requests as possible so the users
        // can see the web page as fast as possible.

        // Latency - The time to complete a single task. Measured in time units.
        // Throughput - The number of tasks completed in a given period. Measured in tasks/time unit.

        // how many threads should we use?
        // it depends on the number of cores of the CPU. if we have a CPU with 4 cores, we can use 4 threads.
        // if we use more threads than cores, the performance can decrease because the CPU needs to switch between
        // threads and this can take time.

        // Cost of parallelism and aggregation
        // for the cost of parallelism and aggregation we need to consider the cost of breaking tasks into smaller tasks
        // cost of creation of threads
        // cost of time between thread,start to thread getting scheduled
        // Time the last thread finishes and signals
        // time until the aggregating thread runs.
        // aggregating the subtask in to a single result.
    }
}
