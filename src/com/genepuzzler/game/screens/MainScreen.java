package com.genepuzzler.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.genepuzzler.game.GenePuzzler;

public class MainScreen implements Screen {
	private GenePuzzler parent;
	private Stage stage;
	private Skin skin;
	private Group cellBoxesGroup;
	private ShapeRenderer sr;



	public MainScreen(GenePuzzler genePuzzler){
		parent = genePuzzler; 
		stage = new Stage(new ScreenViewport());
		
		cellBoxesGroup = new Group();
		
		// Skinning with AssetManager
		parent.assMan.queueAddSkin();
		parent.assMan.manager.finishLoading();
		skin = parent.assMan.manager.get("skin/neon-ui-changed.json");
		
		sr = new ShapeRenderer();

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);	// This is a trial, may move
		Table superTable = new Table();
		Table gridTable = new Table();
		Table outputTable = new Table();
		superTable.setFillParent(true);
		
		superTable.padTop(stage.getHeight()*0.1f);
		superTable.padLeft(stage.getWidth()*0.1f); 
		superTable.left().top();
		outputTable.center().top().padLeft(stage.getWidth()*0.05f);
		
		stage.addActor(superTable);
		superTable.add(gridTable);
		superTable.add(outputTable);
		
		superTable.setFillParent(true);
		gridTable.setDebug(true);
		outputTable.setDebug(true);
			
		
		// Simple Widget
		final CheckBox cellBox0 = new CheckBox(null, skin);
		final CheckBox cellBox1 = new CheckBox(null, skin);
		final CheckBox cellBox2 = new CheckBox(null, skin);
		final CheckBox cellBox3 = new CheckBox(null, skin);
		final CheckBox cellBox4 = new CheckBox(null, skin);
		final CheckBox cellBox5 = new CheckBox(null, skin);
		
		
		final Label cellOutLabel0 = new Label(setCellOut(cellBox0),skin);
		final Label cellOutLabel1 = new Label(setCellOut(cellBox1),skin);
		final Label cellOutLabel2 = new Label(setCellOut(cellBox2),skin);
		final Label cellOutLabel3 = new Label(setCellOut(cellBox3),skin);
		final Label cellOutLabel4 = new Label(setCellOut(cellBox4),skin);
		final Label cellOutLabel5 = new Label(setCellOut(cellBox5),skin);
		
		// Creating the blank box
		final Label decimalOutLable = new Label(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()),skin);
		Texture boxTexture = new Texture(Gdx.files.internal("images/grid-button-_0000_ON.png"));
		Image boxImage = new Image();
		boxImage.setDrawable(new TextureRegionDrawable(new TextureRegion(boxTexture)));
		boxImage.setSize(boxTexture.getWidth(), boxTexture.getHeight());
		boxImage.setColor(1,0,0,1);
		
		// Listeners for Grid
		cellBox0.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel0.setText(setCellOut(cellBox0));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		cellBox1.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel1.setText(setCellOut(cellBox1));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		cellBox2.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel2.setText(setCellOut(cellBox2));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		cellBox3.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel3.setText(setCellOut(cellBox3));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		cellBox4.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel4.setText(setCellOut(cellBox4));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		cellBox5.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				cellOutLabel5.setText(setCellOut(cellBox5));
				decimalOutLable.setText(setDecimalOut(cellOutLabel0.getText(),cellOutLabel1.getText(),cellOutLabel2.getText(),cellOutLabel3.getText(),cellOutLabel4.getText(),cellOutLabel5.getText()));
				return false;
			}
		});
		
		
		
		
		
		// Grid Table		
		gridTable.add(cellBox0);
		gridTable.add(cellBox1);
		gridTable.row();
		gridTable.add(cellBox2);
		gridTable.add(cellBox3);
		gridTable.row();
		gridTable.add(cellBox4);
		gridTable.add(cellBox5);
		gridTable.row();
		
		
		// Output Table
		//outputTable.add(cellOutLabel0).width(100).height(100);
		outputTable.add(boxImage);
		outputTable.add(cellOutLabel1).width(100).height(100);
		outputTable.row();
		outputTable.add(cellOutLabel2).width(100).height(100);
		outputTable.add(cellOutLabel3).width(100).height(100);
		outputTable.row();
		outputTable.add(cellOutLabel4).width(100).height(100);
		outputTable.add(cellOutLabel5).width(100).height(100);
		outputTable.row();
		outputTable.add(decimalOutLable);
		
	}

	@Override
	public void render(float delta) {




		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

		
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
		stage.dispose();
	}

	
	
	public String setCellOut(CheckBox c){
		if(c.isChecked()){
			return "1";
		} else {
			return "0";
		}
	}
	
	public String setDecimalOut(com.badlogic.gdx.utils.StringBuilder stringBuilder, com.badlogic.gdx.utils.StringBuilder stringBuilder2, com.badlogic.gdx.utils.StringBuilder stringBuilder3, com.badlogic.gdx.utils.StringBuilder stringBuilder4, com.badlogic.gdx.utils.StringBuilder stringBuilder5, com.badlogic.gdx.utils.StringBuilder stringBuilder6){
		String cb = ""+stringBuilder+stringBuilder2 + stringBuilder3 + stringBuilder4+ stringBuilder5+ stringBuilder6;
		int ci = Integer.parseInt(cb, 2);
		char[] aminoCodonCodes = {
				'f','f','l','l','s','s','s','s','y','y','*','*','c','c','*','w','l','l','l','l','p','p','p','p','h','h','q','q','r','r','r','r','i','i','i','m','t','t','t','t','n','n','k','k','s','s','r','r','v','v','v','v','a','a','a','a','d','d','e','e','g','g','g','g'
		};
		return ""+aminoCodonCodes[ci];
	}

}
