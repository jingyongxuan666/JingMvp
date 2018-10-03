package com.study.jingyongxuan.mvpproject.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.jingyongxuan.mvpproject.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * user:jingyongxuan
 * date:18-10-3
 * desc:
 */
public abstract class BaseFragment extends SupportFragment implements BaseView{
    protected Activity mActivity;
    protected View rootView;
    protected boolean isInit;
    private Unbinder unbinder;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;//防止getActivity()返回空指针
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutRes = getLayoutResId();
        if (layoutRes != 0){
            rootView = inflater.inflate(layoutRes,null);
        }else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        unbinder = ButterKnife.bind(this,rootView);
        return rootView;
    }

    protected abstract int getLayoutResId();

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        isInit = true;
        init();
    }

    protected abstract void init();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解绑butterknife
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rootView = null;
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
        BaseActivity activity = (BaseActivity) getActivity();
        /*if (activity instanceof BaseMvpActivity) {
            activity.showLoading();
        }*/
    }

    @Override
    public void hideLoading() {
        BaseActivity activity = (BaseActivity) getActivity();
        /*if (activity instanceof BaseMvpActivity) {
            activity.hideLoading();
        }*/
    }

    @Override
    public void invalidToken() {
        BaseActivity activity = (BaseActivity) getActivity();
        /*if (activity instanceof BaseMvpActivity) {
            activity.invalidToken();
        }*/
    }

    @Override
    public void myFinish() {
        onBackPressedSupport();
    }
}
