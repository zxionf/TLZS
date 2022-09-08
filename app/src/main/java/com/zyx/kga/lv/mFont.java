package com.zyx.kga.lv;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class mFont {
    
    public static BitmapFont mainbitmapFont;
    
    public static void load(){
        mainbitmapFont = new BitmapFont(Gdx.files.internal("font/font-zkklt.fnt"),Gdx.files.internal("font/font-zkklt.png"),false);
    }
}
