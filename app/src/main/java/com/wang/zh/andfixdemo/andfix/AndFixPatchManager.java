package com.wang.zh.andfixdemo.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.wang.zh.andfixdemo.Utils;

import java.io.IOException;

/**
 *  对三方AndFix的功能进行封装，方便调用
 */
public class AndFixPatchManager {

    // volatile禁止指令重排序
    private static volatile AndFixPatchManager mInstance = null;
    private PatchManager mPatchManager;

    public static AndFixPatchManager getInstance() {
        // 双检查机制
        if (mInstance == null) {
            synchronized (AndFixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化AndFix
     */
    public void initPatchManager(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));//current version
        // You should load patch as early as possible, generally,
        // in the initialization phase of your application(such as Application.onCreate()).
        mPatchManager.loadPatch();
    }

    /**
     * 加载patch文件
     * @param path path of the patch file that was downloaded
     */
    public void addPatch(String path) {
        try {
            if (mPatchManager != null)
                mPatchManager.addPatch(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
