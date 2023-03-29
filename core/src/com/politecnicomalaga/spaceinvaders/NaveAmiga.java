package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;

public class NaveAmiga extends NaveEspacial{

    //ATRIBUTOS
    private boolean positivo = true;

    //##############################################

    //MÉTODOS

    //Constructor
    public NaveAmiga(float posX, float posY, float velX, float width, float height, String imagen){
        super(posX, posY, velX, width, height, imagen);
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

    //Disparar
    public void disparoAmigo_dispara(){

    }
    //Morir
    public void morirse(){

    }
}
