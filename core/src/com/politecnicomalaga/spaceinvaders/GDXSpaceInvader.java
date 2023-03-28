package com.politecnicomalaga.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class GDXSpaceInvader extends ApplicationAdapter {

	private SpriteBatch batch;

    private Texture fondo;
	//private ArrayList<ObjetoVolador> listaElementos;
    private Disparo disparo;
    //private NaveEspacial nave;
    private ObjetoVolador naveLider;
	private NaveEnemiga naveEnemiga;
    private Random r;
	//private Escuadron escuadron;
	private Batallon batallon;

	@Override
	public void create () {
		batch = new SpriteBatch();
		r = new Random();
		//listaElementos = new ArrayList<ObjetoVolador>();
		naveEnemiga = new NaveEnemiga(0, 0, 3, 100, 100, "badlogic.jpg");
		fondo = new Texture("espacio.png");
		//nave = new NaveEspacial(0, 350, 3, 80, 100, "naveEnemiga.png");
		disparo = new Disparo(r.nextInt(600), 0, 5, 25, 50, "laserBullet.png");
		naveLider = new ObjetoVolador(Gdx.graphics.getWidth()/2f - 300, 450, 0,(-0.2f), 600,384, "naveLider.png");

		//escuadron = new Escuadron((byte) 5, Gdx.graphics.getWidth(), Gdx.graphics.getWidth()-100,150,0,60,75,"naveEnemiga.png");
		batallon = new Batallon((byte) 2, (byte) 8, Gdx.graphics.getWidth(), Gdx.graphics.getWidth()-200,400,1,60,75,"naveEnemiga.png", 85);
		/*int segmento = Gdx.graphics.getWidth()/6; //Queremos 5 naves, entonces se divide el ancho de la pantalla en 6 (nºnaves + 1)
		int posicion = 0;
		for(int i = 0;i < 5;i++){
			posicion += segmento;
			listaElementos.add(new NaveEspacial(posicion - 40, 350, 0, 80, 100, "naveEnemiga.png"));
		}*/
	}

	@Override
	public void render () {
		//Gestiono lo que pasa
		batch.begin();
		//nave.moverse();
		disparo.moverse();
		if(disparo.getPosY() > Gdx.graphics.getHeight()){
			disparo.setPosY(0f);
			disparo.setPosX(r.nextInt((int) (Gdx.graphics.getWidth()-disparo.getWidth())));
		}

		//escuadron.moverse();
		batallon.moverse();
		if(naveLider.getPosY() > 225.0f && naveLider.getVelY() > 0) {
			naveLider.setVelY(naveLider.getVelY() * (-1));
		}
		if(naveLider.getPosY() <= 175f) {
			naveLider.setVelY(naveLider.getVelY() * (-1));
		}
		naveLider.moverse();
		naveEnemiga.moverse();

		/*for(ObjetoVolador naves : listaElementos){
			naves.moverse();
			if(naves.getPosX() >= Gdx.graphics.getWidth() - naves.getWidth() || naves.getPosX() <= 0f) {
				naves.setVelX(naves.getVelX() * (-1));
			}
		}*/

		//Después lo pinto
		ScreenUtils.clear(1, 0, 0, 1);
		batch.draw(fondo, 0, 0);
		naveLider.pintar(batch);
		//nave.pintar(batch);
		disparo.pintar(batch);
		naveEnemiga.pintar(batch);
		//escuadron.pintar(batch);
		batallon.pintar(batch);

		/*for(ObjetoVolador naves : listaElementos){
			naves.pintar(batch);
		}*/

		/*for(int pasos = 0; pasos < 5;pasos++){
			escuadron.add(nave);
		}*/
		/*
		//Cálculo Array

		pasos++;

		if(pasos == 1){

		}else if(pasos == 30){

		}else if(pasos == 60){
			pasos = 0;
		}
		*/
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//nave.dispose();
		disparo.dispose();
		naveLider.dispose();
		naveEnemiga.dispose();
		//escuadron.dispose();
		batallon.dispose();
		fondo.dispose();

		/*for(ObjetoVolador naves : listaElementos){
			naves.dispose();
		}*/
		/*for(NaveEnemiga naves: escuadron){
			naves.dispose();
		}*/
	}
}