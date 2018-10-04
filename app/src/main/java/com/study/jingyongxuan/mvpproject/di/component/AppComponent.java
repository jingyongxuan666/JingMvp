package com.study.jingyongxuan.mvpproject.di.component;

import com.study.jingyongxuan.mvpproject.di.module.AppModule;
import com.study.jingyongxuan.mvpproject.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/*
 * user:jingiyongxuan
 * date:18-10-4
 * desc:dagger2
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
}
