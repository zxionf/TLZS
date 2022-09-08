package com.zyx.kga.util;


import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zyx.kga.R;
import com.zyx.kga.util.zFiles;
import java.io.InputStream;
import java.io.IOException;
import android.widget.Toast;

public class Achieve {

    public static void getahieve(String a) {
        String w = "";
        try {
            for (int i = 1;i <= zFiles.getTextLines("/storage/emulated/0/0000/achieve_data");i++) {
                w = w + zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3];
            }
        } catch (IOException e) {}

        if(!w.contains(a)){
            zFiles.writeFileAppend("/storage/emulated/0/0000/achieve_data", (a + "\n").getBytes());
        }

    }


    public static void load(Activity activity) throws IOException {
//        String[] w = new String[zFiles.getTextLines("/storage/emulated/0/0000/achieve_data")] ;
//        for (int i = 1;i <= zFiles.getTextLines("/storage/emulated/0/0000/achieve_data");i++) {
//            w[i - 1] = zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3];
//        }

        String w = "";
        for (int i = 1;i <= zFiles.getTextLines("/storage/emulated/0/0000/achieve_data");i++) {
            w =w + zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3];
        }
//        String ww = "";
//        for (int i = 1;i <= zFiles.getTextLinesfromassets(activity, "achieve_ic/list.txt");i++) {
//            ww = ww + zFiles.bplus(activity, "achieve_ic/list.txt", i)[2];
//        }
//        Toast.makeText(activity, ww, Toast.LENGTH_SHORT).show();
//
        /*        for(int i= 0;i<zFiles.getTextLines("/storage/emulated/0/0000/achievedata");i++){
         //Toast.makeText(activity,w[i], Toast.LENGTH_SHORT).show();
         }
         */       
        LinearLayout a = activity.findViewById(R.id.mainachievementLinearLayout1);


        try {
            for (int i = 1;i <= zFiles.getTextLines("/storage/emulated/0/0000/achieve_data");i++) {

                LinearLayout e =new LinearLayout(activity);
                //横向填充 纵向100
                LinearLayout.LayoutParams s = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
                //s.setMarginStart(10);
                e.setLayoutParams(s);

                //已获取的成就颜色
                e.setBackgroundColor(Color.argb(30, 0, 0, 0));
                //e.setBackgroundColor(Color.argb(30, 255, 0, 0));

                e.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams s2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10);
                View n= new View(activity);
                n.setLayoutParams(s2);
                a.addView(e);
                a.addView(n);


                // 4.创建“+”按钮
                ImageView vi = new ImageView(activity);
                RelativeLayout.LayoutParams btnAddParam = new RelativeLayout.LayoutParams(
                    150,
                    150);
                // 靠右放置
                //btnAddParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                vi.setLayoutParams(btnAddParam);
                // 设置属性
                AssetManager assetManager=activity.getAssets();
                try {
                    InputStream in=assetManager.open("achieve_ic/" + zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3] + ".png");
                    Bitmap bmp=BitmapFactory.decodeStream(in);
                    vi.setImageBitmap(bmp);
                } catch (Exception ee) {
                    // TODO: handle exception
                }

                //vi.setBackgroundDrawab
                //vi.setId(btnIDIndex);
                // 设置点击操作
                /*vi.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {
                 addContent(v);
                 }
                 });*/
                // 将“+”按钮放到RelativeLayout里
                e.addView(vi);

                /*   //e.setOrientation(LinearLayout.VERTICAL);

                 e.addView(t);
                 e.addView(tsub);*/
                LinearLayout f =new LinearLayout(activity);
                //横向填充 纵向100
                LinearLayout.LayoutParams h = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                //s.setMarginStart(10);
                f.setLayoutParams(h);
                //f.setBackgroundColor(Color.argb(50,255,0,0));
                f.setOrientation(LinearLayout.VERTICAL);
                e.addView(f);

                TextView t = new TextView(activity);
                t.setTextSize(20);
                t.setTextColor(Color.BLACK);
                //名称
                //获取已有成就的编号
                //zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3]
                t.setText(zFiles.bplus(activity, "achieve_ic/list.txt", Integer.valueOf(zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3]).intValue())[0]);
                TextView tsub = new TextView(activity);
                tsub.setTextSize(15);
                //描述
                tsub.setText(zFiles.bplus(activity, "achieve_ic/list.txt", Integer.valueOf(zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3]).intValue())[1]);



                f.addView(t);
                f.addView(tsub);
            }
        } catch (IOException e) {}



        for (int i= 0;i < zFiles.getTextLines("/storage/emulated/0/0000/achieve_data");i++) {
            //Toast.makeText(activity,w[i], Toast.LENGTH_SHORT).show();
        }


        try {
            for (int i = 1;i <= zFiles.getTextLinesfromassets(activity, "achieve_ic/list.txt");i++) {

                if(!w.contains(zFiles.bplus(activity, "achieve_ic/list.txt", i)[2])){
                LinearLayout e =new LinearLayout(activity);
                //横向填充 纵向100
                LinearLayout.LayoutParams s = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
                //s.setMarginStart(10);
                e.setLayoutParams(s);

                //已获取的成就颜色
                //e.setBackgroundColor(Color.argb(30,0,0,0));
                e.setBackgroundColor(Color.argb(30, 255, 0, 0));

                e.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams s2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10);
                View n= new View(activity);
                n.setLayoutParams(s2);
                a.addView(e);
                a.addView(n);


                // 4.创建“+”按钮
                ImageView vi = new ImageView(activity);
                RelativeLayout.LayoutParams btnAddParam = new RelativeLayout.LayoutParams(
                    150,
                    150);
                // 靠右放置
                //btnAddParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                vi.setLayoutParams(btnAddParam);
                // 设置属性
                AssetManager assetManager=activity.getAssets();
                try {
                    InputStream in=assetManager.open("achieve_ic/" + zFiles.bplus(activity, "achieve_ic/list.txt", i)[2] + ".png");
                    Bitmap bmp=BitmapFactory.decodeStream(in);
                    vi.setImageBitmap(bmp);
                } catch (Exception ee) {
                    // TODO: handle exception
                }

                //Toast.makeText(activity, zFiles.bplus(activity,"achieve_ic/list.txt", i)[2], Toast.LENGTH_SHORT).show();

                //vi.setBackgroundDrawab
                //vi.setId(btnIDIndex);
                // 设置点击操作
                /*vi.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {
                 addContent(v);
                 }
                 });*/
                // 将“+”按钮放到RelativeLayout里
                e.addView(vi);

                /*   //e.setOrientation(LinearLayout.VERTICAL);

                 e.addView(t);
                 e.addView(tsub);*/
                LinearLayout f =new LinearLayout(activity);
                //横向填充 纵向100
                LinearLayout.LayoutParams h = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
                //s.setMarginStart(10);
                f.setLayoutParams(h);
                //f.setBackgroundColor(Color.argb(50,255,0,0));
                f.setOrientation(LinearLayout.VERTICAL);
                e.addView(f);

                TextView t = new TextView(activity);
                t.setTextSize(20);
                t.setTextColor(Color.BLACK);
                //名称
                //获取已有成就的编号
                //zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3]
                t.setText(zFiles.bplus(activity, "achieve_ic/list.txt", i)[0]);
                TextView tsub = new TextView(activity);
                tsub.setTextSize(15);
                //描述
                // tsub.setText(zFiles.bplus(activity, "achieve_ic/list.txt", Integer.valueOf(zFiles.bplus("/storage/emulated/0/0000/achieve_data", i)[3]).intValue())[1]);
                tsub.setText(zFiles.bplus(activity, "achieve_ic/list.txt", i)[1]);


                f.addView(t);
                f.addView(tsub);
              }
            }
        } catch (IOException e) {}

    }

}
