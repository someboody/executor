package com.harven.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CPU 线程执行器实现
 */
class CPUExecutor implements Executor {

    private final java.util.concurrent.Executor delegate;

    public CPUExecutor() {
        int cpuCount = Runtime.getRuntime().availableProcessors(); // CPU核心数
        if (cpuCount < 2) {
            cpuCount = 2;
        }
        // 核心线程数量: cpu核心数多于4个时比cpu核心数少1,否则为cpu核心数,最低不小于2
        int corePoolSize = Math.max(cpuCount << 1, cpuCount > 4 ? cpuCount - 1 : cpuCount);
        // 最大线程数:核心线程数的两倍
        int maximumPoolSize = corePoolSize << 1;
        // concurrent包下同步队列
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();
        // 默认工厂,Executors类下静态内部类私有构造
        ThreadFactory threadFactory = java.util.concurrent.Executors.defaultThreadFactory();
        // 超出队列时报抛异常
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        this.delegate = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                60L, TimeUnit.MINUTES,
                workQueue,
                threadFactory,
                handler);
    }

    @Override
    public void execute(Runnable command) {
        delegate.execute(command);
    }

}
