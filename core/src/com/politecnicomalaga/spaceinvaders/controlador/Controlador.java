package com.politecnicomalaga.spaceinvaders.controlador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.politecnicomalaga.spaceinvaders.modelo.Batallon;
import com.politecnicomalaga.spaceinvaders.modelo.Disparo;
import com.politecnicomalaga.spaceinvaders.modelo.NaveAmiga;
import com.politecnicomalaga.spaceinvaders.modelo.NaveLider;

public class Controlador {

    private static Controlador singleton = null;

    private NaveAmiga naveAmiga;
    private Disparo disparo;
    private NaveLider naveLider;
    private Batallon batallon;

    private Controlador() {
        naveAmiga = new NaveAmiga(70, 65, 3, 140, 125, "naveAmiga.png");
        disparo = new Disparo(300, -25, 5, 25, 50, "laserBullet.png");
        naveLider = new NaveLider(Gdx.graphics.getWidth()/2f, 642, (-0.2f), 600,384, "naveLider.png");
        batallon = new Batallon((byte) 2, (byte) 8, Gdx.graphics.getWidth(), Gdx.graphics.getWidth()-200,425,1,60,75,"naveEnemiga.png", 85);
    }

    //Al llamar a este método se crea el objeto singleton si no se ha creado ya. Este objeto contiene todos los objetos del juego.
    public static Controlador getInstance(){
        if(singleton == null){
            singleton = new Controlador();
        }
        //Devuelvo el objeto singleton, es decir, todos los objetos del juego.
        return singleton;
    }

    public void moverse(){
        naveAmiga.moverse();
        disparo.moverse();
        naveLider.moverse();
        batallon.moverse();
    }

    public void pintar(SpriteBatch batch){
        naveLider.pintar(batch);
        naveAmiga.pintar(batch);
        disparo.pintar(batch);
        batallon.pintar(batch);
    }

    public void dispose(){
        naveAmiga.dispose();
        disparo.dispose();
        naveLider.dispose();
        batallon.dispose();
    }

}
