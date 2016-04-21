package com.sourav.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sourav.game.FlappyBird;

/**
 * Created by sourav on 25-02-2016.
 */
public class MenuState extends State
    {
        private Texture background;
        private Texture btnPlay;
        public MenuState(GameStateManager gameStateManager)
            {
                super(gameStateManager);
                background=new Texture("game_bg.png");
                btnPlay=new Texture("play.png");
            }

        @Override
        public void handleInPut()
            {
                if(Gdx.input.justTouched())
                    {
                        gameStateManager.set(new PlayState(gameStateManager));
                        dispose();
                    }
            }

        @Override
        public void update(float dt)
            {
                handleInPut();
            }

        @Override
        public void render(SpriteBatch spriteBatch)
            {
                spriteBatch.begin();
                spriteBatch.draw(background,0,0, FlappyBird.WIDTH,FlappyBird.HEIGHT);
                spriteBatch.draw(btnPlay,(FlappyBird.WIDTH/2)-(btnPlay.getWidth()/2),FlappyBird.HEIGHT/2);
                spriteBatch.end();
            }

        @Override
        public void dispose()
            {
                background.dispose();
                btnPlay.dispose();
            }
    }
