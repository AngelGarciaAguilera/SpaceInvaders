package com.politecnicomalaga.spaceinvaders.modelo;

public class NaveEnemiga extends NaveEspacial{

    //ATRIBUTOS

    //##############################################

    //MÉTODOS

    //Constructor
    public NaveEnemiga(float posX, float posY, float velX, float width, float height, String imagen) {
        super(posX, posY, velX, 5, width, height, imagen);
    }

    public void cambiarvelX() {
        velX = -velX;
    }

    public void moverY() {
        posY -= velY;
    }

    //Disparar
    public void disparoEnemigo_dispara(){

    }

    //Morir
    public void morirse(Disparo disparo){
        if(colisiona(disparo)){

        }
    }
}