package com.politecnicomalaga.spaceinvaders.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Escuadron{

    private byte numNaves;
    private float posX, velX, width;
    private int posicion, anchoPantalla, anchoDisponible;

    private NaveEnemiga[] escuadron;

    public Escuadron(byte numNaves, int anchoPantalla, int anchoDisponible, float posY, float velX, float width, float height, String imagen){
        this.numNaves = numNaves;
        this.posX = (anchoPantalla - anchoDisponible)/2;
        this.velX = velX;
        this.width = width;
        this.anchoPantalla = anchoPantalla;
        this.anchoDisponible = anchoDisponible;
        escuadron = new NaveEnemiga[numNaves];
        posicion = 0;

        for(int i = 0;i < numNaves;i++){
            escuadron[i] = new NaveEnemiga((posX + posicion), posY, velX, width, height, imagen);
            posicion += anchoDisponible/(numNaves-1);
        }
    }

    public void moverse(){
        posX += velX;

        //escuadron[numNaves-1].getPosX() >= Gdx.graphics.getWidth() - escuadron[numNaves-1].getWidth() || escuadron[0].getPosX() <= 0f
        //posX <= 0 || (posX + anchoDisponible) >= anchoPantalla
        if(escuadron[numNaves-1].getPosX() >= Gdx.graphics.getWidth() - escuadron[numNaves-1].getWidthDiv2() || escuadron[0].getPosX() <= 0f + escuadron[0].getWidthDiv2()){
            for(NaveEnemiga miEscuadron:escuadron){
                miEscuadron.cambiarvelX();
                miEscuadron.moverY();
            }
        }
        for(NaveEnemiga miEscuadron:escuadron){
            miEscuadron.moverse();
        }
    }

    public void pintar(SpriteBatch batch){
        for(NaveEnemiga miEscuadron:escuadron){
            miEscuadron.pintar(batch);
        }
    }

    public void dispose(){
        for(NaveEnemiga miEscuadron:escuadron){
            miEscuadron.dispose();
        }
    }
}
