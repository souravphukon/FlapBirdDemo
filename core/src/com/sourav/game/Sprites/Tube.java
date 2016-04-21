package com.sourav.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by sourav on 05-04-2016.
 */
public class Tube
    {

     /*/*//**   public static final int WIDTH=640;
        public static final int HEIGHT=480;*//**//*
        private static final int FLUCTUATION=130;//up and down randomly b/w 0-130
        private static final int TUBE_GAP=100;//diff of b/w opening b/w tubes
        private static final int LOWEST_OPENING=120;//lowest available opening*/

        public static final int TUBE_WIDTH=52;
        private static final int FLUCTUATION=100;//up and down randomly b/w 0-130
        private static final int TUBE_GAP=80;//diff of b/w opening b/w tubes
        private static final int LOWEST_OPENING=30;//lowest available opening
        private Texture topTube,bottomTube;
        private Vector2 positionTopTube,positionBotTube;
        private Rectangle boundsTop,boundsBottom;
        private Random rand;

        public Tube(float x)
            {
                topTube=new Texture("toptube.png");
                bottomTube=new Texture("bottomtube.png");
                rand=new Random();
              //TODO have to understand the coordinates
                positionTopTube=new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
                positionBotTube=new Vector2(x,positionTopTube.y-TUBE_GAP-bottomTube.getHeight());

              //Invisible rectangles for collision
                boundsTop=new Rectangle(positionTopTube.x,positionTopTube.y,topTube.getWidth(),topTube.getHeight());
                boundsBottom=new Rectangle(positionBotTube.x,positionBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());

            }

        public Texture getBottomTube()
            {
                return bottomTube;
            }

        public Texture getTopTube()
            {
                return topTube;
            }

        public Vector2 getPositionTopTube()
            {
                return positionTopTube;
            }

        public Vector2 getPositionBotTube()
            {
                return positionBotTube;
            }

        public void reposition(float x)
            {
                positionTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
                positionBotTube.set(x,positionTopTube.y-TUBE_GAP-bottomTube.getHeight());

                //rest invisible tube

                boundsTop.setPosition(positionTopTube.x,positionTopTube.y);
                boundsBottom.setPosition(positionBotTube.x,positionBotTube.y);
            }


        public boolean collides(Rectangle player)
            {
                return player.overlaps(boundsTop)||player.overlaps(boundsBottom);
            }
    }
