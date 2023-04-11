package com.politecnicomalaga.spaceinvaders.modelo;

import com.badlogic.gdx.Gdx;

public class NaveAmiga extends NaveEspacial{

    //ATRIBUTOS

    //##############################################

    //MÉTODOS

    //Constructor
    public NaveAmiga(float posX, float posY, float velX, float width, float height, String imagen){
        super(posX, posY, velX, 0, width, height, imagen);
    }

    @Override
    public void moverse(){
        posX += velX;
        if(posX >= Gdx.graphics.getWidth() - widthDiv2) {
            this.setVelX(velX * (-1));
        }
        if(posX < 0f + widthDiv2) {
            this.setVelX(velX * (-1));
        }
    }

    /*public void cambiarvelX() {
        velX = -velX;
    }

    public void cambiarvelY() {
        if(velY == 0f){
            velY = 5F;
        }else{
            velY = 0f;
        }
    }*/

    public void disparoAmigo_dispara(){

    }

    public void morirse(){

    }
}
