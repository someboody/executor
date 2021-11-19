package com.harven.executor.android;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;


/**
 * 安卓的主线程执行者
 */
class MainThreadExecutor implements Executor {
    final Handler handler;

    public MainThreadExecutor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable command) {
        handler.post(command);
    }
}
