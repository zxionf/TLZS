package com.zyx.kga.lv;

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


public class Lv0gdx implements ApplicationListener
{
    float size = 1600;
    final int ipi = 80;

    BitmapFont font,font2;
    SpriteBatch batch2;


    Texture texture;
    Texture command_block_back;
    Texture dirt,stone;
    Animation command_bock_back_animation;
    SpriteBatch batch;
    Sprite sprite = new Sprite();
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
    int c = 1;
    int c2 = 1;
    float y ;
    float x;
    float time;
	
	float xx= 0,yy = 0;
	int n = 1;
	
	float[][] as = new float[10000][];
	  
    @Override
    public void create()
    {
        float[] a = {0,0};
		as[0] = a;
		
        batch2 = new SpriteBatch();
        font2 = new BitmapFont(Gdx.files.internal("font/font-cn.fnt"),Gdx.files.internal("font/font-cn.png"),false);

        font = new BitmapFont(Gdx.files.internal("font/font-cn.fnt"),Gdx.files.internal("font/font-cn.png"),false);
        //三倍
        font.setScale(2);

        texture = new Texture(Gdx.files.internal("logo.png"));
        dirt = new Texture(Gdx.files.internal("dirt.png"));
        stone = new Texture(Gdx.files.internal("stone.png"));
        command_block_back = new Texture(Gdx.files.internal("command_block_back.png"));
        sprite.setTexture(dirt);
        sprite.setOrigin(ipi/2,ipi/2);
        sprite.setSize(ipi,ipi);
        sprite.setPosition(300,300);
        //sprite.setColor(1,0,1,1);
        //动画分割
       int FRAME_COLS = 1;
        int FRAME_ROWS = 4;
        TextureRegion[][] tmp = TextureRegion.split(command_block_back, command_block_back.getWidth() / FRAME_COLS, command_block_back.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++)
            for (int j = 0; j < FRAME_COLS; j++)
                walkFrames[index++] = tmp[i][j];
        command_bock_back_animation = new Animation(1, walkFrames);

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        configureCamera();

        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void render()
    {        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
		
        batch.begin();

        batch.draw(command_block_back,0,0,ipi,ipi);
        for(int i = 0; i< 10;i++){//10列
            for(int j = 0; j< 18; j++){//18行
                batch.draw(dirt,i*ipi,j*ipi,ipi,ipi);
            }
        }
        for(int i =0;i
            <18;i++){
            if(i%2 ==0 ){
                batch.draw(stone,ipi*10,ipi*i,ipi,ipi);
            }if(i%2==1){
                batch.draw(dirt,ipi*10,ipi*i,ipi,ipi);
            }
        }
        batch.draw(command_bock_back_animation.getKeyFrame(time, true), 0, 0, ipi, ipi);
        sprite.draw(batch);

        int op = ipi + 32;
        font.setColor(0,0,0,0.8f);
        font.draw(batch,"/effect @e speed 2 9527",4,op-4);
        font.setColor(Color.WHITE);
        font.draw(batch, "/effect @e speed 2 9527",0 , op);
		
		font.setColor(Color.BLUE);
        font.draw(batch,"x"+(int)x+"y"+(int)y+"\nxx"+(int)xx+"yy"+(int)yy,x,y);
        batch.draw(texture, x, y,300, 50);

        batch.end();

		drawline();
        

        batch2.begin();
        font2.setScale(5);
        font2.setColor(Color.GREEN);
        batch2.setProjectionMatrix(camera.combined);
        for(int i = 0;i
            <19;i++){
            font2.draw(batch2,i+"",0,(i+1)*ipi);
            font2.draw(batch2,i+"",i*ipi,ipi);

        }
        batch2.end();

        time += Gdx.graphics.getDeltaTime();

        if((int) y+50 >= camera.viewportHeight){
            c = -1;
			mn();
        }if((int) y < 0){
            c = 1;
			mn();
        }if((int) x+300 >= camera.viewportWidth){
            c2 = -1;
			mn();
        }if((int) x < 0){
            c2 = 1;
			mn();
        }

        sprite.setRotation(time*50);

        switch(c){
            case 1:
                y = y + 300*Gdx.graphics.getDeltaTime();
                break;
            case -1:
                y = y - 300*Gdx.graphics.getDeltaTime();
                break;
            default: 
        }
        switch(c2){
            case 1:
                x = x + 360*Gdx.graphics.getDeltaTime();
                break;
            case -1:
                x = x - 360*Gdx.graphics.getDeltaTime();
                break;
            default: 
        }
        /*
         if(Gdx.input.isTouched()){
         size = y;
         configureCamera();
         camera.update();
         }*/
        //camera.translate(0,10*Gdx.graphics.getDeltaTime());


    }
	public void mn(){
		xx = x;
		yy = y;
		float a[] = {x,y};
		as[n] = a;
		n++;
	}
	public void drawline(){
		shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        //shapeRenderer.rect(0,100, 100,100 );
		try{
		for(int i = 0;i <= as.length;i++){
			shapeRenderer.line(as[i][0],as[i][1],as[i+1][0],as[i+1][1]);
		}}catch(Exception e){}

		//shapeRenderer.point(x,y,0);
        shapeRenderer.end();
	}

    private void configureCamera()
    {
        if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
            camera.setToOrtho(false, size, size * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        else
            camera.setToOrtho(false, size * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), size);
    }
    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
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
