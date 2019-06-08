package com.wang.zh.andfixdemo.application;

import android.app.Application;

import com.wang.zh.andfixdemo.andfix.AndFixPatchManager;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化AndFix
        AndFixPatchManager.getInstance().initPatchManager(this);
    }
}
