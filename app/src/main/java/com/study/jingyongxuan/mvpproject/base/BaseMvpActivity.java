package com.study.jingyongxuan.mvpproject.base;

import android.os.Bundle;

import javax.inject.Inject;

/*
 * user:jingiyongxuan
 * date:18-10-4
 * desc:带MVP的activity基类
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity {
    @Inject
    protected T basePresenter;

    /**
     * 绑定view
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void initView() {
        super.initView();
        initInject();
        if (basePresenter != null) {
            basePresenter.attachView(this);
        }
    }

    protected abstract void initInject();

    /**
     * 解绑
     */
    @Override
    protected void onDestroy() {
        if (basePresenter != null) {
            basePresenter.detachView();
            basePresenter = null;
        }
        super.onDestroy();
    }
}
