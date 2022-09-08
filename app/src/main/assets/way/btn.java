package com.zyx.x;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import android.widget.Toast;


public class MyGdxGame implements ApplicationListener
{
    OrthographicCamera camera,cam;

    Stage stage;
    Texture tex;
    Image img;
    ImageButton btn;
    TextureRegionDrawable up,down;
    TextureRegion buttonup,buttondown;
    Music music;

    enum VB{
        no
        }
    VB c;


    @Override
    public void create()
    {

        music = Gdx.audio.newMusic(Gdx.files.internal("are_you_lost.mp3"));

        music.play();

        camera = new OrthographicCamera();
        configureCamera();
        stage = new Stage();

        tex = new Texture(Gdx.files.internal("UI.png"));
        TextureRegion[][] temp = TextureRegion.split(tex,20,20);
        buttonup = temp[5][0];
        buttondown = temp[5][1];
        up = new TextureRegionDrawable(buttonup);
        up.setMinWidth(400);
        up.setMinHeight(400);
        down = new TextureRegionDrawable(buttondown);
        down.setMinWidth(400);
        down.setMinHeight(400);
        btn = new ImageButton(up,down);
        btn.setPosition(50,1000);

        btn.addListener(new InputListener(){
                public boolean touchDown(InputEvent event,float x,float y,int pointer,int button){

                    return true;
                }
                public void touchUp(InputEvent event,float x, float y, int pointer, int button){
                    btn.setPosition(50,500);
                    super.touchUp(event,x,y,pointer,button);
                }
            });

        stage.addActor(btn);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render()
    {        
        Gdx.gl.glClearColor(0.89f, 0.67f, 0.32f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        stage.act();
        stage.draw();

        if(c == VB.no){
            btn.setPosition(50,500);
        }

    }

    private void configureCamera()
    {
        int size = 400;
        if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
            camera.setToOrtho(false, size, size * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        else
            camera.setToOrtho(false, size * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), size);
    }
    @Override
    public void dispose()
    {
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
