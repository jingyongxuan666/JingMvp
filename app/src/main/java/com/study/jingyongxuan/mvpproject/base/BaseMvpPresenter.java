package com.study.jingyongxuan.mvpproject.base;

/*
 * user:jingiyongxuan
 * date:18-10-4
 * desc:带mvp的presenter基类
 */
public class BaseMvpPresenter<T extends BaseView> implements BasePresenter<T> {

     protected T baseView;
    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        this.baseView = null;
    }
}
