package com.harven.executor.android;

import java.util.concurrent.Executor;

/**
 * Executors Android 平台下常用的线程执行者常量
 *
 * @author pc
 * @date 2021/7/14 14:58
 */
public class Executors {
    public static final Executor IO   = com.harven.executor.Executors.IO;
    public static final Executor CPU  = com.harven.executor.Executors.CPU;
    public static final Executor MAIN = new MainThreadExecutor();
}
