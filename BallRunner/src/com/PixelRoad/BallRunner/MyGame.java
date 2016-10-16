package com.PixelRoad.BallRunner;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private Texture dropImage;
	private Texture bucketImage;
	
	private Rectangle bucket;
	
	Array<Rectangle> raindrops;
	
	
	long lastDropTime;
	
	float w;
	float h;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		batch = new SpriteBatch();

		
		
		
		// load the images for the droplet and the bucket, 48x48 pixels each
		/*dropImage = new Texture(Gdx.files.internal("data/droplet.png"));
	    bucketImage = new Texture(Gdx.files.internal("data/bucket.png"));*/
	    
	    bucket = new Rectangle();
	    bucket.x = 720 / 2 - 240 / 2;
	    bucket.y = 80;
	    bucket.width = 240;
	    bucket.height = 20;
	    
	    raindrops = new Array<Rectangle>();
	    //spawnRaindrop();
	}

	@Override
	public void dispose() {
		/*dropImage.dispose();
	    bucketImage.dispose();*/
	    batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		/*batch.draw(bucketImage, bucket.x, bucket.y);
		for(Rectangle raindrop: raindrops) {
		      batch.draw(dropImage, raindrop.x, raindrop.y);
		   }*/
		batch.end();
		
		if(Gdx.input.isTouched()) {
			/*Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    bucket.x = touchPos.x - 240 / 2;*/
		    }
		/*if(bucket.x < 0) bucket.x = 0;
		if(bucket.x > 800 - 240) bucket.x = 800 - 240;
		if(TimeUtils.nanoTime() - lastDropTime > 900000000) spawnRaindrop();*/
		
		
		
		/*Iterator<Rectangle> iter = raindrops.iterator();
		   while(iter.hasNext()) {
		      Rectangle raindrop = iter.next();
		      raindrop.y -= 500 * Gdx.graphics.getDeltaTime();
		      if(raindrop.y + 60 < 0) iter.remove();
		      if(raindrop.overlaps(bucket)) {
		    	  iter.remove();
			      }
		   }*/
		
		   
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	 /*private void spawnRaindrop() {
	      Rectangle raindrop = new Rectangle();
	      float h = Gdx.graphics.getHeight();
	      float w = Gdx.graphics.getWidth();
	      raindrop.x = MathUtils.random(0, 720-100);
	      raindrop.y = h;
	      raindrop.width = 100;
	      raindrop.height = 100;
	      raindrops.add(raindrop);
	      lastDropTime = TimeUtils.nanoTime();
	   }*/
}
