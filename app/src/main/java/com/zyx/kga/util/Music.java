package com.zyx.kga.util;
import android.media.MediaPlayer;
import java.io.File;

public class Music {
    
    public static void start(String jpath){
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
         File file = new File(jpath);
         mediaPlayer.setDataSource(file.getPath()); //指定音频文件的路径
         mediaPlayer.prepare(); //让MediaPlayer进入到准备状态
         } catch (Exception e) {
         e.printStackTrace();
         }
         if(!mediaPlayer.isPlaying()){
             mediaPlayer.start();
         }

         //mediaPlayer.pause(); //暂停播放
         //mediaPlayer.reset(); //停止播放,之后需要重复上面的
         
         
    }
    
    public void Music(){
        
    }
    
}


