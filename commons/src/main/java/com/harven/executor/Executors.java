package com.harven.executor;

import java.util.concurrent.Executor;

/**
 * 常用自定义执行器常量
 */
public class Executors {
    public static final Executor IO  = new IOExecutor();
    public static final Executor CPU = new CPUExecutor();
}
