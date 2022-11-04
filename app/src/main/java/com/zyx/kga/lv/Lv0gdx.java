package com.zyx.kga.lv;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


public class Lv0gdx implements ApplicationListener
{
    
    //加载相机
    OrthographicCamera camera,cam;
    
    //字体
    BitmapFont font;
    //笔刷
    Batch batch;
    
    //音乐
    Music music;
    //菜单
    mMenu e;
    //按钮
    ctrBtn e2;
    //文本编辑框
    mEditText edittext;
    //游戏舞台
    GameStage gamestage;
    
    
    
    @Override
    public void create()
    {

        //加载字体
        mFont.load();
        //FONT
        font = new BitmapFont(Gdx.files.internal("font/font-cn.fnt"),Gdx.files.internal("font/font-cn.png"),false);
        //font.setScale(0.5f);

        //BGM
        //music = Gdx.audio.newMusic(Gdx.files.internal("are_you_lost.mp3"));
        //music.play();
        
        
        
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        configureCamera();

        
        //控制几个按钮
        e = new mMenu();
        e.create();
        
        e2 = new ctrBtn();
        e2.create();
        
        edittext = new mEditText();
        edittext.create();
        
        e.stage.addActor(e2.btnL);
        e.stage.addActor(e2.btnR);
        edittext.edittext.setPosition((Gdx.graphics.getWidth()-Gdx.graphics.getHeight()*3840/2160)/2,0.4f*Gdx.graphics.getHeight()-64*2);
        e.stage.addActor(edittext.edittext);
        
        
        //游戏舞台
        gamestage = new GameStage();
        gamestage.onCreate();

        Gdx.input.setInputProcessor(e.stage);
        
        //DiyDialog2();
    }

    @Override
    public void render()
    {        
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
        }

        camera.update();
        //batch.setProjectionMatrix(camera.combined);
        
        gamestage.act();
        gamestage.draw();
        
        if(e.state == mMenu.STATE.idle){
            e.stage.addActor(e.btn2);
            e.stage.addActor(e.btn3);
            e.stage.addActor(e.btn4);
        }
        if(e.state == mMenu.STATE.hide){
            e.setA(0);
            e.btn.setStyle(e.normal);
            e.btn2.remove();
            e.btn3.remove();
            e.btn4.remove();
        }


        
        e.stage.act();
        e.stage.draw();
        
        batch.begin();
        font.setColor(Color.GREEN);
        
        font.draw(batch,"FPS:"+Gdx.graphics.getFramesPerSecond(),(Gdx.graphics.getWidth()-Gdx.graphics.getHeight()*3840/2160)/2,Gdx.graphics.getHeight());
        batch.end();
        
        if(gamestage.progressss != gamestage.progress){
            gamestage.progressss ++;
            GameStage.mLabel b = new GameStage.mLabel("bbb",gamestage.labelstyle);
            b.setPosition((Gdx.graphics.getWidth()-Gdx.graphics.getHeight()*3840/2160)/2,0.4f*Gdx.graphics.getHeight()-128);
            gamestage.addActor(b);
        }
        
        
    }

    private void configureCamera()
    {
        int size = 800;
        if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
            camera.setToOrtho(false, size, size * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        else
            camera.setToOrtho(false, size * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), size);
    }
    @Override
    public void dispose()
    {
        font.dispose();
        batch.dispose();
        if(music != null){
            music.dispose();
        }
        gamestage.dispose();
    }

    @Override
    public void resize(int width, int height)
    {
        configureCamera();
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }
    
    
    
}
