package com.study.jingyongxuan.mvpproject.base;

import android.support.annotation.StringRes;

public interface BaseView {
    //toast
    void showTipMsg(String msg);
    void showTipMsg(@StringRes int msg);//@StringRes对应资源文件id
    void showLoading();//网络请求loading显示
    void hideLoading();//网络请求loading隐藏
    void invalidToken();//token检测
    void myFinish();

}
