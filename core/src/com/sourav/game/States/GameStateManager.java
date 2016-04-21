package com.sourav.game.States;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by sourav on 23-02-2016.
 */
public class GameStateManager
    {
        private Stack<State> stateStack;

        public GameStateManager()
            {
                stateStack = new Stack<State>();
            }

        public void push(State state)
            {
                stateStack.push(state);
            }

        public void pop(State state)
            {
                stateStack.pop();
            }

        public void set(State state)
            {
                stateStack.pop();
                stateStack.push(state);
            }

        public void update(float dt)
            {
               stateStack.peek().update(dt);
            }

        public void render(SpriteBatch spriteBatch)
            {
                stateStack.peek().render(spriteBatch);
            }
    }
