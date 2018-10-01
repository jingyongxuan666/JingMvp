package com.study.jingyongxuan.mvpproject.base;


import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.ProgressBar;

import com.study.jingyongxuan.mvpproject.utils.ToastUtils;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity implements BaseView {

    private AlertDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showTipMsg(String msg) {
        ToastUtils.showTipMsg(msg);
    }

    @Override
    public void showTipMsg(int msg) {
        ToastUtils.showTipMsg(msg);
    }

    @Override
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new AlertDialog.Builder(this).setView(new ProgressBar(this)).create();
            loadingDialog.setCanceledOnTouchOutside(false);
            Window window = loadingDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
        if (!loadingDialog.isShowing()){
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null) {
            if (loadingDialog.isShowing()){
                loadingDialog.dismiss();
            }
            loadingDialog = null;
        }
    }

    @Override
    public void invalidToken() {
        //用于检测token是否过期
    }

    @Override
    public void myFinish() {
        onBackPressedSupport();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }
}
