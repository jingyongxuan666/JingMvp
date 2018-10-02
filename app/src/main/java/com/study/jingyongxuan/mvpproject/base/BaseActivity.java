package com.study.jingyongxuan.mvpproject.base;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.study.jingyongxuan.mvpproject.R;
import com.study.jingyongxuan.mvpproject.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity implements BaseView, View.OnClickListener {

    private AlertDialog loadingDialog;
    public static List<BaseActivity> activities = new ArrayList<>();
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private TextView txtBack;
    private TextView txtMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
        //强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        int layoutId = getLayoutId(savedInstanceState);
        //将布局文件加载到toolbar中去
        View inflate = getLayoutInflater().inflate(R.layout.activity_base, toolbar, false);
        ConstraintLayout rootLayout = inflate.findViewById(R.id.ct_layout_base);
        //设置布局
        if (layoutId == 0) {
            //没有布局返回为0
            setContentView(rootLayout);
        } else {
            //有就添加toolbar
            View rootView = getLayoutInflater().inflate(layoutId, rootLayout, true);
            setContentView(rootView);
        }
        stateBar();
        initView();
        initToolbar(toolbar);
        initData();
        setOnClick(R.id.txt_back_base);
    }

    /**
     * 如果需求和默认toolbar不同，可重写此方法
     *
     * @param toolbar
     */
    protected void initToolbar(Toolbar toolbar) {

    }

    protected void initData() {

    }

    /**
     * 初始化控件
     */
    protected void initView() {
        toolbar = findViewById(R.id.toolbar_base);
        toolbarTitle = findViewById(R.id.txt_title_base);
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

    public BaseActivity setOnClick(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
        return this;
    }

    public BaseActivity setOnClick(@IdRes int... ids) {
        View view;
        for (int id : ids) {
            view = findViewById(id);
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
        return this;
    }

    /**
     * 设置title
     *
     * @param title
     * @return
     */
    public BaseActivity setTitleTxt(CharSequence title) {
        toolbarTitle.setText(title);
        return this;
    }

    protected BaseActivity initToolbar(boolean isShowToolbar, boolean isShowBack, boolean isShowMore) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (isShowToolbar) {
                actionBar.show();
                txtBack = findViewById(R.id.txt_back_base);
                txtMore = findViewById(R.id.txt_more_base);
                if (txtBack != null && txtMore != null) {
                    txtBack.setVisibility(isShowBack?View.VISIBLE:View.GONE);
                    txtMore.setVisibility(isShowMore?View.VISIBLE:View.GONE);
                }
            }
        }
        return this;
    }

    /**
     * 设置toolbar背景色
     * @param color
     * @return
     */
    public BaseActivity setToolbarBgColor(int color){
        toolbar.setBackgroundColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置toolbar背景
     * @param drawableId
     * @return
     */
    public BaseActivity setToolbarBg(@DrawableRes int drawableId){
        toolbar.setBackgroundResource(drawableId);
        return this;
    }

    /**
     * 获取当前布局对象
     *
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
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null) {
            if (loadingDialog.isShowing()) {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_back_base:
                onBackPressedSupport();
                break;
            default:
                break;
        }
    }
}
