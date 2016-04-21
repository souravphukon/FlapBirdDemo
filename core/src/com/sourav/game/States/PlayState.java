package com.sourav.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.sourav.game.FlappyBird;
import com.sourav.game.Sprites.Bird;
import com.sourav.game.Sprites.Tube;

/**
 * Created by sourav on 25-02-2016.
 */
public class PlayState extends State
    {
        private static final int TUBE_SPACING=125;//spacing b/w tubes not including tube itself
        private static final int TUBE_COUNT=4;//no of tube in a given time
        private Bird bird;
        private Texture bg;
        //private Tube tube;

        private Array<Tube>tubes; //libGDX array for encoding module

        protected PlayState(GameStateManager gameStateManager)
            {
                super(gameStateManager);
                //bird = new Texture("bird.png");
                bird =new Bird(50,300);
                //zoom the view port
                orthographicCamera.setToOrtho(false, FlappyBird.WIDTH/2,FlappyBird.HEIGHT/2);
                //set background
                bg=new Texture("game_bg.png");
               // tube=new Tube(100);

                tubes=new Array<Tube>();



                for (int i = 1; i <=TUBE_COUNT ; i++)
                    {
                        tubes.add(new Tube(i*(TUBE_SPACING + Tube.TUBE_WIDTH)));
                    }
            }

        @Override
        protected void handleInPut()
            {
            if(Gdx.input.justTouched())
                {
                    bird.jump();
                }

            }

        @Override
        public void update(float dt)
            {
                handleInPut();
                bird.update(dt);

                //update the camera with the bird
                orthographicCamera.position.x=bird.getPosition().x+80;//off set the camera by 80 in front of the bird view

                for(Tube tube:tubes)
                    {
                      if(orthographicCamera.position.x-(orthographicCamera.viewportWidth/2)>tube.getPositionTopTube().x+tube.getTopTube().getWidth())
                          {
                              tube.reposition(tube.getPositionTopTube().x+((tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
                          }

                   //If collision occurred restar the game
                    if(tube.collides(bird.getBirdBounds()))
                        {

                            gameStateManager.set(new PlayState(gameStateManager));
                        }
                    }
                orthographicCamera.update();
            }

        @Override
        public void render(SpriteBatch spriteBatch)
            {
                spriteBatch.setProjectionMatrix(orthographicCamera.combined);
                spriteBatch.begin();
                spriteBatch.draw(bg,orthographicCamera.position.x-(orthographicCamera.viewportWidth/2),0);
                spriteBatch.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);

               for(Tube tube:tubes)
                   {
                       spriteBatch.draw(tube.getTopTube(), tube.getPositionTopTube().x, tube.getPositionTopTube().y);
                       spriteBatch.draw(tube.getBottomTube(), tube.getPositionBotTube().x, tube.getPositionBotTube().y);
                   }

                spriteBatch.end();
            }

        @Override
        public void dispose()
            {

            }
    }
