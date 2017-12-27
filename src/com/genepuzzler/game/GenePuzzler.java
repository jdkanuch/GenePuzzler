package com.genepuzzler.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.genepuzzler.game.screens.EndScreen;
import com.genepuzzler.game.screens.MainScreen;
import com.genepuzzler.game.screens.MenuScreen;
import com.genepuzzler.game.screens.PreferencesScreen;
import com.genepuzzler.game.util.AppPreferences;
import com.genepuzzler.game.util.GameAssetManager;



public class GenePuzzler extends Game {
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = (int)(WIDTH * 0.75);
	
	SpriteBatch batch;
	Texture img;
	
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private AppPreferences preferences;
	
	// Screens
	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	
	// asset Manager
	public GameAssetManager assMan = new GameAssetManager();
	
	
	public void changeScreen(int screen){
		switch(screen){
		case MENU:
			if(menuScreen == null){

				menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
			} else {
				this.setScreen(menuScreen);
			}
			break;			
		case PREFERENCES:
			if(preferencesScreen == null){
				preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
			} else {
				this.setScreen(preferencesScreen);
			}
			break;
		case APPLICATION:
			if(mainScreen == null){
				mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
			} else {

				this.setScreen(mainScreen);
			}
			break;
		case ENDGAME:
			if(endScreen == null){
				endScreen = new EndScreen(this);
				this.setScreen(endScreen);
			} else {
				this.setScreen(endScreen);

			}
			break;


		}
	}

	public AppPreferences getPreferences(){		
		return this.preferences; 
	}
	
	
	
	@Override
	public void create () {
		menuScreen = new MenuScreen(this);
		preferences = new AppPreferences();
		setScreen(menuScreen);
	}

	
}
