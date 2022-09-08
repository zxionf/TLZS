package com.zyx.kga.util;

import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.app.Activity;
import com.zyx.kga.R;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.content.Intent;
import com.zyx.kga.lv.Lv0;

public class Loading extends Activity{
    
    public static void load(Activity activity){
        activity.setContentView(R.layout.loading);
/*        
        ImageView image = activity.findViewById(R.id.loadingView1);
        
        
        Animation mRotate;
        mRotate = new RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f);
        // 初始话插值器并设置线性插值器，变化率，并不是运行速度。一个插补动画，可以将动画效果设置为加速、减速、反复、反弹等
        //linearInterpolator为匀速
        mRotate.setInterpolator(new LinearInterpolator());
        // 设置动画从fromDegrees转动到toDegrees花费的时间，毫秒。可以用来计算速度
        mRotate.setDuration(2000);
        // 设置重复的次数（旋转圈数），Animation.INFINITE = -1，无限循环
        mRotate.setRepeatCount(Animation.INFINITE);

        image.setAnimation(mRotate);
        // 注意这里，在设置完动画一定要start动画才会执行
        image.startAnimation(mRotate);


        //mImgLoading.clearAnimation();
*/
        
    }
    
    
    
}
