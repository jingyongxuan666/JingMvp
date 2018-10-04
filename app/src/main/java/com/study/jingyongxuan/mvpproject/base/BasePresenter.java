package com.study.jingyongxuan.mvpproject.base;

/**
 * user:jinyongxuan
 * date:2018年10月4日
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T baseView);
    void detachView();
}
