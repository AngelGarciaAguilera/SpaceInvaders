package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class Disparo extends ObjetoVolador{

    private Random r = new Random();
    public Disparo(float posX, float posY, float velY, float width, float height, String imagen){
        super(posX, posY, 0, velY, width, height, imagen);
    }

    @Override
    public void moverse() {
        posY += velY;
        /*if(posY > Gdx.graphics.getHeight()){
            posY = 0f;
        }
        if(posY >= Gdx.graphics.getHeight()){
            posX = r.nextInt(600);
        }*/
    }
}
