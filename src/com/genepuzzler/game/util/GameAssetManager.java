package com.genepuzzler.game.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
	public final AssetManager manager = new AssetManager();

	// Textures
	public final String gameImages = "images/game.atlas";
	public final String loadingImages = "images/loading.atlas";
	
	public void queueAddImages(){
		manager.load(gameImages, TextureAtlas.class);
	}
	// a small set of images used by the loading screen
	public void queueAddLoadingImages(){
		manager.load(loadingImages, TextureAtlas.class);
	}
	// Sounds
	public final String boingSound = "sounds/boing.wav";
	public final String pingSound = "sounds/ping.wav";
		
	public void queueAddSounds(){
		manager.load(boingSound,Sound.class);
		manager.load(pingSound,Sound.class);
	}
	
	// Music
	public final String playingSong = "music/chip_fun-consolidated.wav";
		
	public void queueAddMusic(){
		manager.load(playingSong, Music.class);
	}
	
	// Skin
	public final String skin = "skin/glassy-ui.json";
		
	public void queueAddSkin(){
		SkinParameter params = new SkinParameter("skin/glassy-ui.atlas");
		manager.load(skin, Skin.class, params);
	}
	
	public void queueAddFonts(){
		
	}
	
	public void queueAddParticleEffects(){
		
	}
}
