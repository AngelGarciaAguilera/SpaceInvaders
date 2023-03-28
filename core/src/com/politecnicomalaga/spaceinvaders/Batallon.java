package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Batallon {

    private Escuadron[] batallon;

    public Batallon(byte numEscuadrones, byte numNaves, int anchoPantalla, int anchoDisponible, float posY, float velX, float width, float height, String imagen, int separacionEscuadrones){
        batallon = new Escuadron[ numEscuadrones];

        for(int i = 0;i <  numEscuadrones;i++){
            batallon[i] = new Escuadron(numNaves, anchoPantalla, anchoDisponible, posY, velX, width, height, imagen);
             posY -=  separacionEscuadrones;
        }
    }

    public void moverse(){
        for (Escuadron miBatallon : batallon){
            miBatallon.moverse();
        }
    }

    public void pintar(SpriteBatch batch){
        for (Escuadron miBatallon : batallon){
            miBatallon.pintar(batch);
        }
    }

    public void dispose(){
        for (Escuadron miBatallon : batallon){
            miBatallon.dispose();
        }
    }
}
