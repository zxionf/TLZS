package com.zyx.kga;

import android.app.Application;
import com.zyx.kga.common.crash.CrashHandler;

public class App extends Application {

    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        CrashHandler.init(this);
    }

   

    public static App getApp() {
        return sApp;
    }

}
