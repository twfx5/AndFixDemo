package com.wang.zh.andfixdemo;

import android.content.Context;
import android.content.pm.PackageManager;

public class Utils {

    /**
     * 获取当前本地apk的版本
     */
    public static String getVersionName(Context mContext) {
        String versionName = "1.0.0";
        try {
            //获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionName = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
