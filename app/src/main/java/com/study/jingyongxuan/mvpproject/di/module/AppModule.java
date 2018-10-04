package com.study.jingyongxuan.mvpproject.di.module;

import com.study.jingyongxuan.mvpproject.base.MyApplication;

import dagger.Module;

/*
 * user:jingiyongxuan
 * date:18-10-4
 * desc:
 */
@Module
public class AppModule {
    private MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }
}
