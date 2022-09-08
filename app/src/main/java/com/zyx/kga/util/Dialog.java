package com.zyx.kga.util;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.app.Activity;
import com.zyx.kga.R;

public class Dialog {
    
    public static void Dialog(final Activity a,String msg,String btxt){
        AlertDialog dialog = new AlertDialog.Builder(a)
            //.setTitle("AlerDialog")
            .setMessage(msg)
            //.setNegativeButton("",null)
            .setPositiveButton(btxt,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   a.finish(); 
                }
            })
            .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);
        
    }
    
    public static void Dialog(final Activity a,String msg){
        AlertDialog dialog = new AlertDialog.Builder(a)
            //.setTitle("AlerDialog")
            .setMessage(msg)
            //.setNegativeButton("",null)
            .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   
                }
            })
            .create();
        dialog.show();
        //dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);

    }
    
    public static void tip(final Activity a,String msg){
        AlertDialog dialog = new AlertDialog.Builder(a)
            //.setTitle("AlerDialog")
            .setMessage(msg)
            .create();
        dialog.show();
    }
    
    
}
