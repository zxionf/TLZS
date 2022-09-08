package com.zyx.kga.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bumptech.glide.Glide;
import com.zyx.kga.R;
import com.zyx.kga.lv.Lv0;
import com.zyx.kga.util.Achieve;
import com.zyx.kga.util.Dialog;
import com.zyx.kga.util.Loading;
import com.zyx.kga.util.MyImageView;
import com.zyx.kga.util.zFiles;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import android.widget.Toast;

public class MainActivity extends Activity { 


	public int v = 4;
	public int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //全屏
        //UiUtils.full_sreen(this);

        super.onCreate(savedInstanceState);


        setTheme(android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);

        setContentView(R.layout.activity_main);
        
        

        ImageView gif = findViewById(R.id.activitymainImageView1);
        
        Glide.with(this).load(R.drawable.hfv).into(gif);
        
        TextView b= findViewById(R.id.activitymainTextView1);
        b.setText(zFiles.b(this,"info"));
        
		
        
        //BGM
        //new Tmusic().start();
    }

    @Override
    public void onBackPressed() {
        Dialog.Dialog(this,"确定退出游戏？","退出");
    }
    @Override

    protected void onResume() {
        /**

         * 设置为横屏

         */

        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }
        
        super.onResume();
        
        setContentView(R.layout.activity_main);
        
        TextView b= findViewById(R.id.activitymainTextView1);
        b.setText(zFiles.b(this,"info"));
        
        
        roll();                                                   


    }

    @Override public void onWindowFocusChanged(boolean hasFocus){
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

    
    //进入选关
    public void onEnterClick (View view){
        setContentView(R.layout.LevelSelect);
    }
    //评级相关
    public void pingjiHelp(View v){
        Dialog.Dialog(this,"评级分为.........");
    }
    int lv = 0;
    //lv0
    public void op0(View v){
        lv = 0;
        Loading.load(this);
        new T().start();

    }
    //返回主页
    public void onBackClick (View view){
        setContentView(R.layout.activity_main);
        roll();
        
    }
    //进入成就
    public void onAcClick(View view){
        
        Loading.load(this);
        new Tc().start();

       
    }
    //AC界面重置
    public void onAcbgClick(View view){
        TextView sp = findViewById(R.id.mainachievementTextView3);
        TextView cd = findViewById(R.id.mainachievementTextView4);
        cd.setBackgroundColor(Color.WHITE);
        sp.setBackgroundColor(Color.WHITE);
    }
    //进入关于
    public void onMainAboutClick(View view){
        setContentView(R.layout.main_about);
        //更新几位主力军的头像
        MyImageView m1 = findViewById(R.id.mainaboutMyImageView1);
        m1.isUseCache = true;
        m1.setImageURL("http://q1.qlogo.cn/g?b=qq&nk=1342409224&s=640");
        MyImageView m2 = findViewById(R.id.mainaboutMyImageView2);
        m1.isUseCache = true;
        m2.setImageURL("http://q1.qlogo.cn/g?b=qq&nk=2386663986&s=640");
        MyImageView m3 = findViewById(R.id.mainaboutMyImageView3);
        m3.isUseCache = true;
        m3.setImageURL("http://q1.qlogo.cn/g?b=qq&nk=2170049968&s=640");
        MyImageView m4 = findViewById(R.id.mainaboutMyImageView4);
        m4.isUseCache = true;
        m4.setImageURL("http://q1.qlogo.cn/g?b=qq&nk=717444103&s=640");
        
    }
    public void onAbout_1Click (View view){
        Dialog.tip(this,"你再点！");
    }
    public void onAbout_2Click (View view){
        Dialog.tip(this,"屑!");
    }
    public void onAbout_3Click (View view){
        Dialog.tip(this,"");
    }
    //问题反馈
    public void wtfkui(View v){
//        try{
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&version=1&uin=717444103")));//跳转到临时会话
//        }catch(Exception e){
//            Dialog.Dialog(this,"你安装QQ了吗？");
//        }
        Dialog.Dialog(this,"功能暂时关闭");
//		new Thread(new Runnable() {
//				@Override
//				public void run() {
//					
//				}
//			}).start();
    }
    //获取更新
    public void hqgxin(View v){
//        try{
//        Uri uri = Uri.parse("https://wwb.lanzouy.com/b03j1tzmf");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//        }catch(Exception e){}
        Dialog.Dialog(this,"功能暂时关闭");
    }
	
    //进入设置
    public int ts = 10;
    public void onSettingClick(View view){
		
        setContentView(R.layout.settings);
        
        
        
        
        //item1
        TextView tsize = findViewById(R.id.settingsitem1);
        tsize.setText(ts+"");
        TextView exam = findViewById(R.id.settingsitem1example);
        exam.setTextSize(ts);
        
        
        //item2
        
        final EditText e = findViewById(R.id.settingsEditText2);
        final TextView t = findViewById(R.id.settingsTextView2);
        final Button b= findViewById(R.id.settingsButton2);
        
        b.setEnabled(false);
        File v = new File("/storage/emulated/0/0000/a");
        
        if(v.length()==0){
        
        final EditText r = findViewById(R.id.settingsEditText1);
        r.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(r.getText().toString().equals("35126083101224157548zx")){
                        File f = new File("/storage/emulated/0/0000/a");
                        if(!f.exists()){
                            try {
                                f.createNewFile();
                                zFiles.writeFileAppend("/storage/emulated/0/0000/a","35126083101224157548zx".getBytes());
                            } catch (IOException e) {}
                        }
                        b.setEnabled(true);
                        TextView n = findViewById(R.id.settingsTextView3);
                        EditText b = findViewById(R.id.settingsEditText1);
                        LinearLayout c = findViewById(R.id.settingsLinearLayout1);
                        c.removeView(b);
                        n.setText("");
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }else if(zFiles.bplus("/storage/emulated/0/0000/a", 1)[3].equals("35126083101224157548zx")){
            b.setEnabled(true);
            TextView n = findViewById(R.id.settingsTextView3);
            EditText bb = findViewById(R.id.settingsEditText1);
            LinearLayout c = findViewById(R.id.settingsLinearLayout1);
            c.removeView(bb);
            n.setText("");
        }
        
        b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String s = e.getText().toString();
                    //t.setText(e.getText().toString());

                    try{
                        String[] str = s.split(" ");
                        Pattern pattern = Pattern.compile( "[a-z]+ [0-9]{4}" );  
                        Matcher matcher = pattern.matcher( s );  
                        
                        if(matcher.find()&&str[1].length()==4){
                          Achieve.getahieve(str[1]);
                          t.setText("已获取成就"+str[1]);
                        }else t.setText("指令错误");
                    }catch (Exception c ){
                        t.setText("指令错误");
                    }
                }
            });
       
    }
    public void settingsitem1a(View V){
        ts--;
        TextView tsize = findViewById(R.id.settingsitem1);
        tsize.setText(ts+"");
        TextView exam = findViewById(R.id.settingsitem1example);
        exam.setTextSize(ts);
    }
    public void settingsitem1b(View V){
        ts++;
        TextView tsize = findViewById(R.id.settingsitem1);
        tsize.setText(ts+"");
        TextView exam = findViewById(R.id.settingsitem1example);
        exam.setTextSize(ts);
    }
    public void ets(int a){
        if(a==0){
            ts--;
        }else{
            ts++;
        }
    }
    
    //启动关卡
    public void sat(){

        switch(lv){
            case 0:
                startActivity(new Intent(this, Lv0.class));
                break;
            case 1:
                break;
            default: 
        }
    }
    
    
    public class T extends Thread {
        @Override
        public void run() {
            super.run();
            sat();
        }
    }
    
    //
    public void c(){
        
        setContentView(R.layout.main_achievement);
        
        
        try {
            Achieve.load(this);
        } catch (IOException e) {}

        TextView tx = findViewById(R.id.mainachievementTextView2);
        try {
            tx.setText(zFiles.getTextLines("/storage/emulated/0/0000/achieve_data") + "/" + zFiles.getTextLinesfromassets(this,"achieve_ic/list.txt"));
        } catch (IOException e) {}
        
        //两个分类按钮
        final TextView sp = findViewById(R.id.mainachievementTextView3);
        final TextView cd = findViewById(R.id.mainachievementTextView4);
        sp.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    sp.setBackgroundColor(Color.GRAY);
                    cd.setBackgroundColor(Color.WHITE);
                }
            });
        cd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    cd.setBackgroundColor(Color.GRAY);
                    sp.setBackgroundColor(Color.WHITE);
                }
            });
        
    }
    public class Tc extends Thread {
        @Override
        public void run() {
            super.run();
            
            TextView gif = findViewById(R.id.loadingTextView1);
            gif.post(new Runnable() {
                    @Override
                    public void run() {
                        c();
                    }
                });
        }
    }
    public class Tmusic extends Thread {
        @Override
        public void run() {
            super.run();

            ImageView gif = findViewById(R.id.activitymainImageView1);
            gif.post(new Runnable() {
                    @Override
                    public void run() {
                        //Music.start("/storage/emulated/0/0000/music/are_you_lost.mp3");
                    }
                });
        }
    }
    
    //滚动卡片
    public void roll(){
        ViewFlipper mFlipper;
       mFlipper = findViewById(R.id.activitymainViewFlipper1);
        mFlipper.startFlipping();

       mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                                                            R.anim.push_up_in));
        mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_up_out));
        
        ImageView gif = findViewById(R.id.activitymainImageView1);
        Glide.with(this).load(R.drawable.hfv).into(gif);
        
        //BGM
        //new Tmusic().start();
    }
	
	
}
