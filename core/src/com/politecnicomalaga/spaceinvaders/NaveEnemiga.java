package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NaveEnemiga extends NaveEspacial{

    //ATRIBUTOS
    private boolean positivo = true;

    //##############################################

    //MÉTODOS

    //Constructor
    public NaveEnemiga(float posX, float posY, float velX, float width, float height, String imagen){

        super(posX, posY, velX, width, height, imagen);
        /*imgNaveEnemiga = new Texture("naveEnemiga.png");

        posX = iPosX;
        posY = iPosY;

        velX = 2f; //Se pone la 'f' después del 0 porque la variable es tipo float.
        velY = 0f;*/
    }

    @Override
    public void moverse(){
        if(posX >= Gdx.graphics.getWidth() - widthDiv2*2){
            positivo = false;
        }else if(posX == 0f){
            positivo = true;
        }

        if(positivo){
            posX += velX;
        }else{
            posX -= velX;
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
    public void disparoEnemigo_dispara(){

    }
    //Morir
    public void morirse(){

    }
}