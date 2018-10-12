package com.study.jingyongxuan.mvpproject;

import android.os.Bundle;
import android.widget.TextView;

import com.study.jingyongxuan.mvpproject.base.BaseMvpActivity;
import com.study.jingyongxuan.mvpproject.contract.MainContract;
import com.study.jingyongxuan.mvpproject.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView {
    @BindView(R.id.textView)
    TextView mTxt;

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        initToolbar(true,false,true).setTitleTxt(R.string.app_name).setRightTxt(R.string.more);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }



}
