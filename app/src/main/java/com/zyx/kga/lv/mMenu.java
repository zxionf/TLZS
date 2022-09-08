package com.zyx.kga.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.audio.Music;

public class mMenu{
    
    private int a = 0;
    private int b = 0;
    
    Stage stage;
    Texture tex;
    
    Music music;
    
    ImageButton btn,btn2,btn3,btn4;
    TextureRegionDrawable up1,down1,
                          up2,down2,
                          up3,down3,
                          up4,down4;
    TextureRegion buttonMainUp,buttonMainDown,
                  buttonHomeUp,buttonHomeDown,
                  buttonSaveUp,buttonSaveDown,
                  buttonMusicUp,buttonMusicDown;
                  
    ImageButton.ImageButtonStyle down =new ImageButton.ImageButtonStyle();
    ImageButton.ImageButtonStyle normal =new ImageButton.ImageButtonStyle();
    
    ImageButton.ImageButtonStyle dis_M =new ImageButton.ImageButtonStyle();
    ImageButton.ImageButtonStyle normal_M =new ImageButton.ImageButtonStyle();
    
    
    enum STATE{
        idle,hide
    }
    
    STATE state;
    
    public void create(){
        stage = new Stage();
        
        //BGM
        music = Gdx.audio.newMusic(Gdx.files.internal("music/are_you_lost.mp3"));
        music.setLooping(true);
        music.play();
        
        
        tex = new Texture(Gdx.files.internal("UI/ui_2.png"));
        TextureRegion[][] temp = TextureRegion.split(tex,40,40);
        
        buttonMainUp = temp[0][0];
        buttonMainDown = temp[0][1];
        
        buttonHomeUp = temp[1][0];
        buttonHomeDown = temp[1][1];
        
        buttonSaveUp = temp[2][0];
        buttonSaveDown = temp[2][1];
        
        buttonMusicUp = temp[5][0];
        buttonMusicDown = temp[5][1];
        
        up4 = new TextureRegionDrawable(buttonMusicUp);
        up4.setMinWidth(80);
        up4.setMinHeight(80);
        down4 = new TextureRegionDrawable(buttonMusicDown);
        down4.setMinWidth(80);
        down4.setMinHeight(80);
        btn4 = new ImageButton(up4,down4);
        btn4.setPosition(0,Gdx.graphics.getHeight()-320);
        
        up3 = new TextureRegionDrawable(buttonSaveUp);
        up3.setMinWidth(80);
        up3.setMinHeight(80);
        down3 = new TextureRegionDrawable(buttonSaveDown);
        down3.setMinWidth(80);
        down3.setMinHeight(80);
        btn3 = new ImageButton(up3,down3);
        btn3.setPosition(0,Gdx.graphics.getHeight()-240);
        
        up2 = new TextureRegionDrawable(buttonHomeUp);
        up2.setMinWidth(80);
        up2.setMinHeight(80);
        down2 = new TextureRegionDrawable(buttonHomeDown);
        down2.setMinWidth(80);
        down2.setMinHeight(80);
        btn2 = new ImageButton(up2,down2);
        btn2.setPosition(0,Gdx.graphics.getHeight()-160);
        
        up1 = new TextureRegionDrawable(buttonMainUp);
        up1.setMinWidth(80);
        up1.setMinHeight(80);
        down1 = new TextureRegionDrawable(buttonMainDown);
        down1.setMinWidth(80);
        down1.setMinHeight(80);
        btn = new ImageButton(up1,down1);
        btn.setPosition(0,Gdx.graphics.getHeight()-80);
        
        down.imageDown = down1;
        down.imageUp = down1;
        normal.imageDown = down1;
        normal.imageUp = up1;
        
        dis_M.imageUp = down4;
        dis_M.imageDown = down4;
        normal_M.imageUp = up4;
        normal_M.imageDown = down4;
        
        btn.addListener(new InputListener(){

                
                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    if(a ==0){
                        btn.setStyle(down);
                      state = STATE.idle;
                      a  = 1;}
                    else if(a == 1){
                        btn.setStyle(normal);
                      state = STATE.hide;
                      a = 0;}
                    //super.touchUp(event,x,y,pointer,button);
                }
            });
            
        btn2.addListener(new InputListener(){


                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    Gdx.app.exit();
                    //super.touchUp(event,x,y,pointer,button);
                }
            });
            
        btn3.addListener(new InputListener(){


                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    state = STATE.hide;
                    //super.touchUp(event,x,y,pointer,button);
                }
            });
        btn4.addListener(new InputListener(){


                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){
                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    
                    if(b ==0){
                        btn4.setStyle(dis_M);
                        if(music.isPlaying()){
                            music.pause();
                        }
                        state = STATE.hide;
                        b  = 1;}
                    else if(b == 1){
                        btn4.setStyle(normal_M);
                        if(!music.isPlaying()){
                            music.play();
                        }
                        state = STATE.hide;
                        b = 0;}
                    //super.touchUp(event,x,y,pointer,button);
                }
            });
        stage.addActor(btn);

    }
    
    public void display(){
        
    }
    
    public void setA(int a){
        this.a = a;
    }
    
}
