package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NaveLider extends ObjetoVolador{

    //private boolean bajar;

    //##############################################

    //MÉTODOS

    //Constructor
    public NaveLider(float posX, float posY, float velY, float width, float height, String imagen){
        super(posX, posY, 0, velY, width, height, imagen);
    }

    @Override
    public void moverse(){
        /*
        if(posY > 225f+162f){
            bajar = true;
        }
        else if (posY <= 175f+162){
            bajar = false;
        }
        if(bajar){
            posY -= velY;
        }
        else{
            posY += velY;
        }*/
        posY += velY;
        if(posY > 225.0f+162 && velY > 0) {
            this.setVelY(velY * (-1));
        }
        if(posY <= 175f+162) {
            this.setVelY(velY * (-1));
        }
    }
}
