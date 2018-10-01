package com.study.jingyongxuan.mvpproject.base;


import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.study.jingyongxuan.mvpproject.R;
import com.study.jingyongxuan.mvpproject.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity implements BaseView {

    private AlertDialog loadingDialog;
    public static List<BaseActivity> activities = new ArrayList<>();
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private TextView toolbarRight;
    private TextView tvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
        //强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        int layoutId = getLayoutId(savedInstanceState);
        //将布局文件加载到toolbar中去
        View inflate = getLayoutInflater().inflate(R.layout.activity_base,toolbar,false);
        ConstraintLayout rootLayout = inflate.findViewById(R.id.ct_layout_base);
        //设置布局
        if (layoutId == 0){
            //没有布局返回为0
            setContentView(rootLayout);
        }else {
            //有就添加toolbar
            View rootView = getLayoutInflater().inflate(layoutId,rootLayout,true);
            setContentView(rootView);
        }
        stateBar();
    }

    /**
     * 设置沉浸状态栏
     */
    private void stateBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    /**
     * 获取当前布局对象
     * @param savedInstanceState 这个是当前activity保存的数据，最常见的就是横竖屏切换时，数据丢失问题
     * @return 当前布局的int值
     */
    protected abstract int getLayoutId(Bundle savedInstanceState);

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
