package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.spaceinvaders.controlador.Controlador;
import com.politecnicomalaga.spaceinvaders.modelo.Batallon;
import com.politecnicomalaga.spaceinvaders.modelo.Disparo;
import com.politecnicomalaga.spaceinvaders.modelo.NaveAmiga;
import com.politecnicomalaga.spaceinvaders.modelo.NaveLider;

import java.util.Random;

public class GDXSpaceInvader extends ApplicationAdapter {

	private SpriteBatch batch;
    private Texture fondo;

	/*
	private Random r;
    private Disparo disparo;
    //private NaveEspacial nave;
	private NaveLider naveLider;
	private NaveAmiga naveAmiga;
	private Batallon batallon;

 	*/

	@Override
	public void create () {
		batch = new SpriteBatch();
		fondo = new Texture("espacio.png");
		//Llamo la clase controlador y hago que se cree el objeto singleton de esta.
		Controlador.getInstance();

		/*
		r = new Random();
		naveAmiga = new NaveAmiga(70, 65, 3, 140, 125, "naveAmiga.png");
		//nave = new NaveEspacial(0, 350, 3, 80, 100, "naveEnemiga.png");
		disparo = new Disparo(r.nextInt(600), -25, 5, 25, 50, "laserBullet.png");
		naveLider = new NaveLider(Gdx.graphics.getWidth()/2f, 642, (-0.2f), 600,384, "naveLider.png");
		batallon = new Batallon((byte) 2, (byte) 8, Gdx.graphics.getWidth(), Gdx.graphics.getWidth()-200,425,1,60,75,"naveEnemiga.png", 85);
		 */
	}

	@Override
	public void render () {
		//Gestiono lo que pasa
		batch.begin();
		//Le digo al objeto singleton que se mueva, por lo que se mueven todos los objetos que contiene.
		Controlador.getInstance().moverse();
		//nave.moverse();
		/*
		disparo.moverse();
		if(disparo.getPosY() > Gdx.graphics.getHeight()){
			disparo.setPosY(0f);
			disparo.setPosX(r.nextInt((int) (Gdx.graphics.getWidth()-disparo.getWidth())));
		}
		batallon.moverse();
		naveLider.moverse();
		naveAmiga.moverse();

		 */
		//Después lo pinto

		ScreenUtils.clear(1, 0, 0, 1);
		batch.draw(fondo, 0, 0);
		//Le digo al objeto singleton que se pinte, por lo que se pintan todos los objetos que contiene.
		Controlador.getInstance().pintar(batch);

		/*
		naveLider.pintar(batch);
		//nave.pintar(batch);
		disparo.pintar(batch);
		naveAmiga.pintar(batch);
		batallon.pintar(batch);

		 */
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//Le digo al objeto singleton que se disposen, por lo que se disposan todos los objetos que contiene.
		Controlador.getInstance().dispose();

		//nave.dispose();
		/*
		disparo.dispose();
		naveLider.dispose();
		naveAmiga.dispose();
		batallon.dispose();

		 */
		fondo.dispose();
	}
}
