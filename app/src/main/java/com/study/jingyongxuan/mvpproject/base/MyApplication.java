package com.study.jingyongxuan.mvpproject.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * user:jingyongxuan
 * date:18-9-21
 * desc:初始化应用只需要初始化一次的内容
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public MyApplication getInstance() {
        return instance;
    }

    public static void setInstance(MyApplication instance) {
        MyApplication.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        initLeakCanary();
    }

    /**
     * 初始化内存检测工具
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
