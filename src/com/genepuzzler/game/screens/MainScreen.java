package com.genepuzzler.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.genepuzzler.game.GenePuzzler;
import com.genepuzzler.game.systems.PuzzleGameSystem;

public class MainScreen implements Screen {
	private GenePuzzler parent;
	private Stage stage;
	private PuzzleGameSystem puzzleGame; 


	public MainScreen(GenePuzzler genePuzzler){
		parent = genePuzzler; 
		stage = new Stage(new ScreenViewport());
		puzzleGame = new PuzzleGameSystem(parent);

		stage.addActor(puzzleGame);


	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);	// This is a trial, may move
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

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
		stage.dispose();
	}

}
