package com.sourav.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by sourav on 16-02-2016.
 */
public abstract class State
    {
        protected OrthographicCamera orthographicCamera;
        protected Vector3 mouse;
        protected  GameStateManager gameStateManager;
        protected State(GameStateManager gameStateManager)
           {
               this.gameStateManager=gameStateManager;
               this.mouse=new Vector3();
               this.orthographicCamera=new OrthographicCamera();
           }
        protected abstract void handleInPut();
        public abstract void update(float dt);
        public abstract void render(SpriteBatch spriteBatch);
        public abstract void dispose();


    }
