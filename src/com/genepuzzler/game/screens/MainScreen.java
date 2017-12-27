package com.genepuzzler.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.genepuzzler.game.GenePuzzler;

public class MainScreen implements Screen {
	private GenePuzzler parent;
	

	
	
	public MainScreen(GenePuzzler genePuzzler){
		

		parent = genePuzzler; 
		

	}

	@Override
	public void show() {
		//------- TODO Stage for UI Overlay ---------//
		// Gdx.input.setInputProcessor();	// This is a trial, may move
		
		

	}

	@Override
	public void render(float delta) {

		


		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//stage.act();
		//stage.draw();

		//engine.update(delta);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}



}
