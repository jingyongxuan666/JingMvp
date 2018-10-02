package com.study.jingyongxuan.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.study.jingyongxuan.mvpproject.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private TextView textView;

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        textView = findViewById(R.id.textView);
        setOnClick(textView);
    }



    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.textView:
                break;
            default:
                break;
        }
    }
}
