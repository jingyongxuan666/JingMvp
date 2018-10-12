package com.study.jingyongxuan.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.study.jingyongxuan.mvpproject.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
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


}
