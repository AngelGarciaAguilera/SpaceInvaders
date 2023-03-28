package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;

public class NaveEspacial extends ObjetoVolador{

    public NaveEspacial(float posX, float posY, float velX, float width, float height, String imagen){
        super(posX, posY, velX, 0, width, height, imagen); //En velY pongo 0 ya que no necesito ponerla porque no voy a usarla en esta clase.
    }

    @Override
    public void moverse(){
        posX += velX;
    }
}
