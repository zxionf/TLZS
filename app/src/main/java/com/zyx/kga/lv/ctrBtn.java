package com.zyx.kga.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.audio.Sound;

public class ctrBtn{


    Texture tex;
    ImageButton btnL,btnR;
    TextureRegionDrawable up1,down1,
    up2,down2;
    TextureRegion buttonRightUp,buttonRightDown,
    buttonLeftUp,buttonLeftDown;
    
    Sound s;
    
    
    int x = 800;

    ImageButton.ImageButtonStyle down =new ImageButton.ImageButtonStyle();
    ImageButton.ImageButtonStyle normal =new ImageButton.ImageButtonStyle();

    public void create(){

        //BGM
        s= Gdx.audio.newSound(Gdx.files.internal("sound/sound_5.wav"));
        
        

        tex = new Texture(Gdx.files.internal("UI/ui_2.png"));
        TextureRegion[][] temp = TextureRegion.split(tex,40,40);

        buttonRightUp = temp[3][0];
        buttonRightDown = temp[3][1];

        buttonLeftUp = temp[4][0];
        buttonLeftDown = temp[4][1];


        up2 = new TextureRegionDrawable(buttonRightUp);
        up2.setMinWidth(120);
        up2.setMinHeight(120);
        down2 = new TextureRegionDrawable(buttonRightDown);
        down2.setMinWidth(120);
        down2.setMinHeight(120);
        btnR = new ImageButton(up2,down2);
        btnR.setPosition(Gdx.graphics.getWidth()-120,0);

        up1 = new TextureRegionDrawable(buttonLeftUp);
        up1.setMinWidth(120);
        up1.setMinHeight(120);
        down1 = new TextureRegionDrawable(buttonLeftDown);
        down1.setMinWidth(120);
        down1.setMinHeight(120);
        btnL = new ImageButton(up1,down1);
        btnL.setPosition(0,0);

        down.imageDown = down1;
        down.imageUp = down1;
        normal.imageDown = down1;
        normal.imageUp = up1;

        btnL.addListener(new InputListener(){


                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    //s.play();
                    setX(0);
                    //super.touchUp(event,x,y,pointer,button);
                }
            });

        btnR.addListener(new InputListener(){


                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    //s.play();
                    setX(1);
                    
                    //super.touchUp(event,x,y,pointer,button);
                }
            });


    }
    void setX(int s){
        if(s == 0){
            x--;
        }else if(s == 1){
            x++;
        }
    }
}
