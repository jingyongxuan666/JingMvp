package com.study.jingyongxuan.mvpproject.utils;

import android.annotation.SuppressLint;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.study.jingyongxuan.mvpproject.base.MyApplication;

/**
 * user:jingyongxuan
 * date:18-10-1
 * desc:toast工具类
 */
public class ToastUtils {
    private static Toast toast;

    private ToastUtils() {
        throw new RuntimeException("工具类不允许创建对象");
    }

    @SuppressLint("all")
    private static void init(){
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getInstance(),"",Toast.LENGTH_SHORT);
        }
    }

    public static void showTipMsg(String msg){
        if (toast == null) {
            init();
        }
        toast.setText(msg);
        toast.show();
    }

    public static void showTipMsg(@StringRes int msg){
        if (toast == null) {
            init();
        }
        toast.setText(msg);
        toast.show();
    }


}
