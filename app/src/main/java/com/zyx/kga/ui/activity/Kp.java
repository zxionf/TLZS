package com.zyx.kga.ui.activity;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;
import com.zyx.kga.R;
import com.zyx.kga.common.activity.BaseActivity;
import com.zyx.kga.util.ZipUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
public class Kp extends BaseActivity {

    private boolean allow = true;
    private boolean allowsss = true;
    private boolean isfi = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kp);

        //
        request_permissions();


    }

    // 请求多个权限
    private void request_permissions() {
        // 创建一个权限列表，把需要使用而没用授权的的权限存放在这里
        List<String> permissionList = new ArrayList<>();

        // 判断权限是否已经授予，没有就把该权限添加到列表中
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        // 如果列表为空，就是全部权限都获取了，不用再次获取了。不为空就去申请权限
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                                              permissionList.toArray(new String[permissionList.size()]), 1002);
            //Toast.makeText(getApplication(), "无法存储游戏数据，重启应用重新授权", Toast.LENGTH_SHORT).show();

        } else {
            new myThread().start();
            new testThread().start();
            //Toast.makeText(this, "多个权限你都有了，不用再次申请", Toast.LENGTH_LONG).show();
        }
    }

    // 请求权限回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1002:

                // 判断权限是否处于不再询问状态
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Toast.makeText(this, "手动给👴权限", Toast.LENGTH_LONG).show();
                        allowsss = false;

                    } else {
                        //Toast.makeText(this, "权限未被授予！", Toast.LENGTH_SHORT).show();
                        allowsss = false;
                        request_permissions();
                    }
                } else {
                    //Toast.makeText(this, "权限已被授予！", Toast.LENGTH_SHORT).show();
                    new myThread().start();
                    new testThread().start();
                }

                break;
        }
    }
    public void onGoClick(View v) {
        if (allowsss) {
            allow = false;
            newac();
            finish();
        }
    }

    public void newac() {
       startActivity(new Intent(this, MainActivity.class));
    }
    public void testthr(){
        try {
            ZipUtils.UnZipAssetsFolder(this, "res.zip", "/storage/emulated/0/0000/");
        } catch (Exception e) {}

    }
    public class testThread extends Thread {
        @Override
        public void run() {
            super.run();
            File f = new File("/storage/emulated/0/0000");
            if(!f.exists()){
                f.mkdir();
            }
            f = new File("/storage/emulated/0/0000/achieve_data");
            if(!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException e) {}
            }
            
            File file=new File("/storage/emulated/0/0000/x");
            if(!file.exists()){
                try {
                    file.createNewFile();
                    //解压资源
                    allow = false;
                    //testthr();
                    allow = true;
                    if(isfi){
                        newac();
                    }
                    
                    } catch (IOException e) {
                } 
            }
        }
    }
    
    public class myThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                sleep(3000);
            } catch (Exception ex) {
            }

            
            cha(findViewById(R.id.kpView1), true);
            cha(findViewById(R.id.kpView2), false);
            try {
                sleep(1000);
            } catch (Exception e) {}
            cha(findViewById(R.id.kpView3), false);
            try {
                sleep(1000);
            } catch (Exception e) {}
            isfi = true;
            if (allow) {
                newac();//进入主页
                finish();}
        }
    }

    public void cha(View v, boolean b) {
        if (b == true) {
            v.setAlpha(0);
        } else {v.setAlpha(1);}
    }

    protected void onResume() {
        /**

         * 设置为横屏

         */

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();

    }

    @Override public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
