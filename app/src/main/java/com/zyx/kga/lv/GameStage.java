package com.zyx.kga.lv;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.graphics.Color;

public class GameStage extends Stage {
    
    Texture texture;
    Image bg;
    Label label;
    Label.LabelStyle labelstyle = new Label.LabelStyle();
    
    int progress = 1;
    int progressss = 1;
    
    public void onCreate(){
        
        labelstyle.font = mFont.mainbitmapFont;
        labelstyle.fontColor = Color.BLACK;
        
        //3840 2160
        texture = new Texture(Gdx.files.internal("level/a/pict/bg/lv0bg1.png"));
        bg = new Image(texture);
        bg.setSize(Gdx.graphics.getHeight()*3840/2160,Gdx.graphics.getHeight());
        bg.setPosition((Gdx.graphics.getWidth()-Gdx.graphics.getHeight()*3840/2160)/2,0);
        this.addActor(bg);
        this.addActor(new Image(dialogWindow()));
        
    

        label = new Label("请输入你的昵称（按下回车确认！）：",labelstyle);
        label.setPosition((Gdx.graphics.getWidth()-Gdx.graphics.getHeight()*3840/2160)/2,0.4f*Gdx.graphics.getHeight()-64);
        this.addActor(label);
    }
    
     
    private Texture dialogWindow() {
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(0xffffffdd);
       //绘制对话区背景 
        pixmap.fillRectangle(0,(int)(0.6f*pixmap.getHeight()),pixmap.getWidth(),(int)(0.4f*pixmap.getHeight()));
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }
    
    public static class mLabel extends com.badlogic.gdx.scenes.scene2d.ui.Widget{
        

        public mLabel(java.lang.CharSequence text, com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle style) {}

    }
}
