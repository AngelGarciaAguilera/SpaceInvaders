package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Escuadron{

    private byte numNaves;
    private float posX, velX, width;
    private int posicion, anchoPantalla, anchoDisponible;

    private NaveEspacial[] escuadron;

    public Escuadron(byte numNaves, int anchoPantalla, int anchoDisponible, float posY, float velX, float width, float height, String imagen){
        this.numNaves = numNaves;
        this.posX = ((anchoPantalla - anchoDisponible)/2)-width/2;
        this.velX = velX;
        this.width = width;
        this.anchoPantalla = anchoPantalla;
        this.anchoDisponible = anchoDisponible;
        escuadron = new NaveEspacial[numNaves];
        posicion = 0;

        for(int i = 0;i < numNaves;i++){
            escuadron[i] = new NaveEspacial((posX + posicion), posY, velX, width, height, imagen);
            posicion += anchoDisponible/(numNaves-1);
        }
    }

    public void moverse(){

        posX += velX;
        //escuadron[numNaves-1].getPosX() >= Gdx.graphics.getWidth() - escuadron[numNaves-1].getWidth() || escuadron[0].getPosX() <= 0f
        //posX <= 0 || (posX + anchoDisponible) >= anchoPantalla
        if(escuadron[numNaves-1].getPosX() >= Gdx.graphics.getWidth() - escuadron[numNaves-1].getWidth() || escuadron[0].getPosX() <= 0f){
            velX = velX * (-1);
            for(NaveEspacial miEscuadron:escuadron){
                miEscuadron.setVelX(velX);
                //miEscuadron.setPosY(miEscuadron.getPosY()-50);
            }
        }
        for(NaveEspacial miEscuadron:escuadron){
            miEscuadron.moverse();
        }
    }

    public void pintar(SpriteBatch batch){
        for(NaveEspacial miEscuadron:escuadron){
            miEscuadron.pintar(batch);
        }
    }

    public void dispose(){
        for(NaveEspacial miEscuadron:escuadron){
            miEscuadron.dispose();
        }
    }
}
