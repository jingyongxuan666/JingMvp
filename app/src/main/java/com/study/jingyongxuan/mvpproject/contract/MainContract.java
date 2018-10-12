package com.study.jingyongxuan.mvpproject.contract;

import com.study.jingyongxuan.mvpproject.base.BasePresenter;
import com.study.jingyongxuan.mvpproject.base.BaseView;

/*
 * user:jingiyongxuan
 * date:18-10-8
 * desc:
 */
public interface MainContract {
    interface IView extends BaseView{

    }
    interface Presenter extends BasePresenter<IView>{
        void loadData();
    }
}
