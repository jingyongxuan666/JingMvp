package com.study.jingyongxuan.mvpproject.presenter;

import com.study.jingyongxuan.mvpproject.base.BaseMvpPresenter;
import com.study.jingyongxuan.mvpproject.contract.MainContract;

import javax.inject.Inject;

/*
 * user:jingiyongxuan
 * date:18-10-12
 * desc:
 */
public class MainPresenter extends BaseMvpPresenter<MainContract.IView> implements MainContract.Presenter {

    @Inject
    MainPresenter(){

    }

    @Override
    public void loadData() {
        baseView.showTipMsg("load data");
    }
}
