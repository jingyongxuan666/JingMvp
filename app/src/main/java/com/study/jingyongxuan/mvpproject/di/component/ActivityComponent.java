package com.study.jingyongxuan.mvpproject.di.component;


import com.study.jingyongxuan.mvpproject.MainActivity;
import com.study.jingyongxuan.mvpproject.di.module.ActivityModule;
import com.study.jingyongxuan.mvpproject.di.scope.ActivityScope;

import dagger.Component;

/*
 * user:jingiyongxuan
 * date:18-10-4
 * desc:dagger2
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
