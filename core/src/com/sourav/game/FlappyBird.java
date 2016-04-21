package com.sourav.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sourav.game.States.GameStateManager;
import com.sourav.game.States.MenuState;

public class FlappyBird extends ApplicationAdapter {
	public static final int WIDTH=640;
	public static final int HEIGHT=480;
	/*public static final int WIDTH=480;
	public static final int HEIGHT=800;*/

	SpriteBatch batch;
	Texture img;
	private GameStateManager gameStateManager;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStateManager=new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gameStateManager.push(new MenuState(gameStateManager));
		/*img = new Texture("badlogic.jpg");*/

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
		/*batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
}
