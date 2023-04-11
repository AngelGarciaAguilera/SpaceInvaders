package com.politecnicomalaga.spaceinvaders.modelo;

public class NaveEspacial extends ObjetoVolador{

    public NaveEspacial(float posX, float posY, float velX, float velY, float width, float height, String imagen){
        super(posX, posY, velX, velY, width, height, imagen); //En velY pongo 0 ya que no necesito ponerla porque no voy a usarla en esta clase.
    }

    @Override
    public void moverse(){
        posX += velX;
    }
}
