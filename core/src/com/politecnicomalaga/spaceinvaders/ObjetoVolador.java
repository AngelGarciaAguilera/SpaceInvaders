package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//Toda clase tiene como padre Object, aunque no se señale.
//Por ejemplo, ObjetoVolador esta extend de Object.
public class ObjetoVolador {

    protected float posX;
    protected float posY;
    protected float velX;
    protected float velY;
    //Los divido porque los voy a usar más así
    protected float widthDiv2;
    protected float heightDiv2;
    protected Texture imagen;

    public ObjetoVolador(float posX, float posY, float velX, float velY, float width, float height, String imagen){
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.widthDiv2 = width/2;
        this.heightDiv2 = height/2;
        this.imagen = new Texture(imagen);
    }
    public void pintar(SpriteBatch batch){
        //Debería poner posX - widthDiv2 y posY - heightDiv2 para que se pinte desde el centro de la imagen
        //Después de esto debería tocar mucho código
        batch.draw(imagen, posX - widthDiv2, posY - heightDiv2, widthDiv2*2, heightDiv2*2);
    }
    public void moverse(){
        posX += velX;
        posY += velY;
    }

    public boolean colisiona(ObjetoVolador otro){
        boolean resultado, colisionX, colisionY;

        //La posicion está en el centro del objeto
        //Resto las posiciones, para saber la distancia que hay entre el centro de un objeto y otro
        //Si este es menor o igual a la suma de la mitad del ancho o alto, significa que han chocado
        colisionX = (Math.abs(posX - otro.getPosX()) <= (widthDiv2 + otro.getWidthDiv2()));
        colisionY = (Math.abs(posY - otro.getPosY()) <= (heightDiv2 + otro.getHeightDiv2()));
        resultado = colisionX && colisionY;

        return resultado;
    }

    public void dispose(){
        if(imagen != null){
            this.dispose();
        }
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public float getWidth() {
        return widthDiv2*2;
    }

    public float getHeight() {
        return heightDiv2*2;
    }

    public float getWidthDiv2() {
        return widthDiv2;
    }

    public float getHeightDiv2() {
        return heightDiv2;
    }

    public Texture getImagen() {
        return imagen;
    }

    public void setPosX(float posX){
        this.posX = posX;
    }

    public void setPosY(float posY){
        this.posY = posY;
    }

    public void setVelX(float velX){
        this.velX = velX;
    }

    public void setVelY(float velY){
        this.velY = velY;
    }
}
