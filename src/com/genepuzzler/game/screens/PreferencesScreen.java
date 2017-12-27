package com.genepuzzler.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.genepuzzler.game.GenePuzzler;


public class PreferencesScreen implements Screen{

	private GenePuzzler parent;
	private Stage stage;

	// Labels for UI Element
	private Label titleLabel; 
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;

	public PreferencesScreen(GenePuzzler genePuzzler){
		parent = genePuzzler; // orchestrator
		stage = new Stage(new ScreenViewport());

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage); // This tells the screen to send any input from the user to the stage so it can respond.
		// Create a table that fills the screen. Everything else will go inside this table.
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(false);
		stage.addActor(table);

		// Using GDX Skins and Scene2D UI, so AWESOME!
		Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		// UI Elements
		//volume Music
		final Slider volumeMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
		volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
		//volumeMusicSlider.setValue( parent.getPreferences().getMusicVolume() );
		volumeMusicSlider.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setMusicVolume( volumeMusicSlider.getValue() );
				return false;
			}
		});

		//music enabled
		final CheckBox musicCheckbox = new CheckBox(null, skin);
		musicCheckbox.setChecked( parent.getPreferences().isMusicEnabled() );
		musicCheckbox.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean enabled = musicCheckbox.isChecked();
				parent.getPreferences().setMusicEnabled( enabled );
				return false;
			}
		});

		//volume sound FX
		final Slider volumeSoundSlider = new Slider( 0f, 1f, 0.1f,false, skin );
		volumeSoundSlider.setValue( parent.getPreferences().getSoundVolume() );
		volumeSoundSlider.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setSoundVolume( volumeSoundSlider.getValue() );
				return false;
			}
		});
		//Sound FX enabled
		final CheckBox soundCheckbox = new CheckBox(null, skin);
		soundCheckbox.setChecked( parent.getPreferences().isSoundEffectsEnabled() );
		soundCheckbox.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean enabled = soundCheckbox.isChecked();
				parent.getPreferences().setSoundEffectsEnabled(enabled);
				return false;
			}
		});

		// return to main screen button
		final TextButton backButton = new TextButton("Back", skin, "small"); // the extra argument here "small" is used to set the button to the smaller version instead of the big default version
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("BCLIK");
				stage.clear();
				parent.changeScreen(GenePuzzler.MENU);

			}
		});

		// Creating Labels
		titleLabel = new Label( "Preferences", skin );
		volumeMusicLabel = new Label( "Music Volume", skin );
		volumeSoundLabel = new Label( "Sound FX Volume", skin );
		musicOnOffLabel = new Label( "Music Enabled", skin );
		soundOnOffLabel = new Label( "Sound Enabled", skin );

		// Adding it all to the table
		table.add(titleLabel).colspan(2); // makes this 2-columns
		table.row();
		table.add(volumeMusicLabel).left(); // left aligned in cell
		table.add(volumeMusicSlider);
		table.row().pad(10, 0,0, 20);
		table.add(musicOnOffLabel).left();
		table.add(musicCheckbox);
		table.row().pad(10, 0,0, 20);
		table.add(volumeSoundLabel).left();
		table.add(volumeSoundSlider);
		table.row().pad(10, 0,0, 20);
		table.add(soundOnOffLabel).left();
		table.add(soundCheckbox);
		table.row().pad(10, 0,0, 20);
		table.add(backButton).colspan(2);

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
		stage.getViewport().update(width, height, true);
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
