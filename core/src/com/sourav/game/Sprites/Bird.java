package com.sourav.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by sourav on 31-03-2016.
 */
public class Bird
    {
        private static final int GRAVITY=-15;
        private static final int MOVEMENT =100;//horizontal movement
        private Vector3 birdPosition;
        private Vector3 velocity;
        private Rectangle birdBounds;
        private Texture bird;

        public Bird(int x, int y)
            {
                birdPosition=new Vector3(x,y,0);
                velocity = new Vector3(0,0,0);
                bird =new Texture("bird.png");
                birdBounds=new Rectangle(x,y,bird.getWidth(),bird.getHeight());
            }


        public void update (float dt)
            {
         //add gravity only if position is greater then zero ie bird in the screen
          if(birdPosition.y>0)
              {
                  //add velocity to gravity
                  velocity.add(0, GRAVITY, 0);
                  //multiply every thing by delta time
              }
                velocity.scl(dt);

                birdPosition.add(100*dt,velocity.y,0);
                //place the bird in the bottom screen
                 if(birdPosition.y<0)
                     birdPosition.y=0;

                velocity.scl(1/dt);

                ///every time birds move we need to updates its bounds
                birdBounds.setPosition(birdPosition.x,birdPosition.y);
            }

        public Vector3 getPosition()
            {
                return birdPosition;
            }

        public Texture getBird()
            {
                return bird;
            }
        public void jump()
            {
                velocity.y=300;
            }

        public Rectangle getBirdBounds(){
            return birdBounds;
        }
    }
