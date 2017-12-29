package com.genepuzzler.game.systems;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.genepuzzler.game.GenePuzzler;

public class PuzzleGameSystem extends Table{
	GenePuzzler parent;

	JsonReader reader = new JsonReader();
	JsonValue gm = reader.parse(Gdx.files.internal("data/gene-mappings.json"));
	
	
	
	private Skin skin;


	// Static Textures
	static final Texture triTexReg = new Texture(Gdx.files.internal("images/triangle-symbol-reg.png"));
	static final Texture triTexInv = new Texture(Gdx.files.internal("images/triangle-symbol-inv.png"));
	static final Texture cirTex = new Texture(Gdx.files.internal("images/circle-symbol.png"));
	static final Texture cirTexHollow = new Texture(Gdx.files.internal("images/circle-symbol-02.png"));
	static final Texture hexTex = new Texture(Gdx.files.internal("images/hex-symbol.png"));


	Table gridTable = new Table();
	Table outputTable = new Table();
	Table superTable = new Table();



	// Simple Widget
	final CheckBox cellBox0;
	final CheckBox cellBox1 ;
	final CheckBox cellBox2 ;
	final CheckBox cellBox3 ;
	final CheckBox cellBox4 ;
	final CheckBox cellBox5 ;


	TextButton saveAA;
	
	Label decimalOutLable;


	final Image image0 = new Image();
	final Image image1 = new Image();
	final Image image2 = new Image();

	final Image hex = new Image();
	
	// Definitions for Amino Processing
	private int[] cellOutInt = {0,0,0,0,0,0};	
	char[] aminoCodonCodes;
	String[] aminoColors;
	
	

	public PuzzleGameSystem(GenePuzzler genePuzzler){
		// Skinning with AssetManager
		parent = genePuzzler;

		parent.assMan.queueAddSkin();
		parent.assMan.manager.finishLoading();
		skin = parent.assMan.manager.get("skin/neon-ui-changed.json");

		// Getting the amino Codes
		
		aminoCodonCodes = gm.get("aminoList").asCharArray();
		//aminoColors = gm.get("colorMapping").asStringArray();
		
		//System.out.println(gm.get("aminoList"));
//		for(JsonValue entry = gm.child; entry !=null; entry = entry.next()){
//			System.out.println(entry.child);
//		}
		
		// Table Manager
		setFillParent(true);

		superTable.setFillParent(true);
		superTable.padTop(80);
		superTable.padLeft(80); 
		superTable.left().top();


		outputTable.center().top().padLeft(40);


		superTable.add(gridTable);
		superTable.add(outputTable);

		addActor(superTable);


		superTable.setFillParent(true);
		gridTable.setDebug(false);
		outputTable.setDebug(false);



		// Widget Managing

		image0.setVisible(false);
		image1.setVisible(false);
		image2.setVisible(false);
		
		hex.setVisible(false);
		
		image0.setColor(Color.FOREST);
		image1.setColor(Color.FOREST);
		image2.setColor(Color.FOREST);


		cellBox0 = new CheckBox(null, skin);
		cellBox1 = new CheckBox(null, skin);
		cellBox2 = new CheckBox(null, skin);
		cellBox3 = new CheckBox(null, skin);
		cellBox4 = new CheckBox(null, skin);
		cellBox5 = new CheckBox(null, skin);

		saveAA = new TextButton("Commit",skin);
		
		// Adding to the tables
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
		gridTable.add(new Label("",skin)).height(100);

		decimalOutLable	= new Label("",skin);

		// Output Table
		outputTable.add(image0).width(100).height(100);	
		outputTable.row();
		outputTable.add(image1).width(100).height(100);
		outputTable.row();
		outputTable.add(image2).width(100).height(100);
		outputTable.row();
		//outputTable.add(decimalOutLable);
		outputTable.add(hex).width(100).height(100);
		outputTable.add(saveAA).width(100).height(100);

	}


	@Override
	public void act(float delta){
		super.act(delta);

		// Listeners for Grid
		cellBox0.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				// Image managing
				image0.setVisible(true);
				int i = getInteger(cellBox0,cellBox1);
				setNucliotideSymbol(i,image0);
				
				// Codon Updating
				cellOutInt[0] = setCellOut(cellBox0);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
		cellBox1.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				// Image managing
				image0.setVisible(true);
				int i = getInteger(cellBox0,cellBox1);
				setNucliotideSymbol(i,image0);
				
				// Codon Updating
				cellOutInt[1] = setCellOut(cellBox1);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
		cellBox2.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {
				// Image managing
				image1.setVisible(true);
				int i = getInteger(cellBox2,cellBox3);
				setNucliotideSymbol(i,image1);
				
				// Codon Updating
				cellOutInt[2] = setCellOut(cellBox2);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
		cellBox3.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {				
				// Image managing
				image1.setVisible(true);
				int i = getInteger(cellBox2,cellBox3);
				setNucliotideSymbol(i,image1);
				
				// Codon Updating
				cellOutInt[3] = setCellOut(cellBox3);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
		cellBox4.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {			
				// Image managing
				image2.setVisible(true);
				int i = getInteger(cellBox4,cellBox5);
				setNucliotideSymbol(i,image2);
				
				// Codon Updating
				cellOutInt[4] = setCellOut(cellBox4);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
		cellBox5.addListener( new EventListener() {
			@Override
			public boolean handle(Event event) {	
				// Image managing
				image2.setVisible(true);
				int i = getInteger(cellBox4,cellBox5);
				setNucliotideSymbol(i,image2);
				
				// Codon Updating
				cellOutInt[5] = setCellOut(cellBox5);
				decimalOutLable.setText(setDecimalOut(cellOutInt));
				setCodonSymbol(decimalOutLable.getText().toString());
				return false;
			}
		});
	}


	public int getInteger(CheckBox c0, CheckBox c1){
		int n0 = c0.isChecked() ? 1 : 0;
		int n1 = c1.isChecked() ? 1 : 0;
		int n = Integer.parseInt(""+n0+n1,2);

		return n;
	}

	public String setDecimalOut(int[] a){
		StringBuilder binValue = new StringBuilder();
		for(int i=0;i<a.length;i++){
			binValue.append(a[i]);
		}
		
		int ci = Integer.parseInt(binValue.toString(), 2);		
		return ""+aminoCodonCodes[ci];
	}


	public Integer setCellOut(CheckBox c){
		if(c.isChecked()){
			return 1;
		} else {
			return 0;
		}
	}

	public void setNucliotideSymbol(int i, Image image){
		

		switch(i){
		case 0:
			// set for U
			image.setDrawable(new TextureRegionDrawable(new TextureRegion(triTexInv)));
			break;
		case 1:
			// set for C
			image.setDrawable(new TextureRegionDrawable(new TextureRegion(cirTex)));
			break;
		case 2:
			// set for A
			image.setDrawable(new TextureRegionDrawable(new TextureRegion(triTexReg)));
			break;
		case 3:
			// set for G
			image.setDrawable(new TextureRegionDrawable(new TextureRegion(cirTexHollow)));
			break;
		}
	}

	public void setCodonSymbol(String aa){
		hex.setDrawable(new TextureRegionDrawable(new TextureRegion(hexTex)));
		hex.setVisible(true);
		String[] blueCodes = {"f","l","s","y","x","c","w"};
		String[] redCodes = {"r","i","m","t","n","k","v"};
		String[] yellowCodes = {"a","d","e","g","p","h","q"};
		if(Arrays.asList(blueCodes).contains(aa)){
			hex.setColor(Color.BLUE);
		} else if(Arrays.asList(redCodes).contains(aa)){
			hex.setColor(Color.SCARLET);
		} else if(Arrays.asList(yellowCodes).contains(aa)){
			hex.setColor(Color.GOLD);
		}
		
	}

}
