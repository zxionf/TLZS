package com.zyx.kga.lv;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import java.io.File;
import java.io.IOException;
import com.zyx.kga.util.Dialog;
import android.app.AlertDialog;
import android.app.Activity;
import com.zyx.kga.R;

public class Lv0 extends AndroidApplication {
    
    
    
    @Override
    public void onBackPressed() {
        
    }
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().addFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        // 延伸显示区域到刘海
/*        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        window.setAttributes(lp);
        // 设置页面全屏显示
        final View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
*/
        setTheme(android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);

        //setContentView(R.layout.activity_main);

        File f = new File("/storage/emulated/0/0000/data/lv0");
        if(!f.exists()){
            //try {
                f.mkdirs();
                //f.createNewFile();
            //} catch (IOException e) {}
        }
        f = new File("/storage/emulated/0/0000/data/lv0/data");
        if(!f.exists()){
            try {
            //f.mkdirs();
            f.createNewFile();
            } catch (IOException e) {}
        }
        

        
        final Lv0gdx n = new Lv0gdx();
        /*AlertDialog dialog = new AlertDialog.Builder(this)
         //.setTitle("AlerDialog")
         .setMessage("")
         //.setNegativeButton("",null)
         .setPositiveButton("v",new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
         n.size =  100;
         }
         })
         .setNegativeButton("z",new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
         n.size = 0;
         }
         })
         .create();
         dialog.show();*/


        //启动游戏
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();

        initialize(n, cfg);
        

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
