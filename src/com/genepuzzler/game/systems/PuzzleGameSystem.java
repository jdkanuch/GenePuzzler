package com.genepuzzler.game.systems;

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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.genepuzzler.game.GenePuzzler;

public class PuzzleGameSystem extends Table{
	GenePuzzler parent;

	private Skin skin;


	// Static Textures
	static final Texture triTexReg = new Texture(Gdx.files.internal("images/triangle-symbol-reg.png"));
	static final Texture triTexInv = new Texture(Gdx.files.internal("images/triangle-symbol-inv.png"));
	static final Texture cirTex = new Texture(Gdx.files.internal("images/circle-symbol.png"));
	static final Texture cirTexHollow = new Texture(Gdx.files.internal("images/circle-symbol-02.png"));


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


	Label decimalOutLable;


	final Image image0 = new Image();
	final Image image1 = new Image();
	final Image image2 = new Image();

	private int[] cellOutInt = {0,0,0,0,0,0};	
			

	public PuzzleGameSystem(GenePuzzler genePuzzler){
		// Skinning with AssetManager
		parent = genePuzzler;

		parent.assMan.queueAddSkin();
		parent.assMan.manager.finishLoading();
		skin = parent.assMan.manager.get("skin/neon-ui-changed.json");



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


		cellBox0 = new CheckBox(null, skin);
		cellBox1 = new CheckBox(null, skin);
		cellBox2 = new CheckBox(null, skin);
		cellBox3 = new CheckBox(null, skin);
		cellBox4 = new CheckBox(null, skin);
		cellBox5 = new CheckBox(null, skin);


		// Creating the Amino Output Label
//		cellOutLabel0 = new Label(setCellOut(cellBox0),skin);
//		cellOutLabel1 = new Label(setCellOut(cellBox1),skin);
//		cellOutLabel2 = new Label(setCellOut(cellBox2),skin);
//		cellOutLabel3 = new Label(setCellOut(cellBox3),skin);
//		cellOutLabel4 = new Label(setCellOut(cellBox4),skin);
//		cellOutLabel5 = new Label(setCellOut(cellBox5),skin);

		
		
		

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
		gridTable.add(new Label("",skin));

		decimalOutLable	= new Label("",skin);

		// Output Table
		outputTable.add(image0).width(100).height(100);	
		outputTable.row();
		outputTable.add(image1).width(100).height(100);
		outputTable.row();
		outputTable.add(image2).width(100).height(100);
		outputTable.row();
		outputTable.add(decimalOutLable);

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
		System.out.println(binValue.toString());
		int ci = Integer.parseInt(binValue.toString(), 2);
		char[] aminoCodonCodes = {
				'f','f','l','l','s','s','s','s','y','y','*','*','c','c','*','w','l','l','l','l','p','p','p','p','h','h','q','q','r','r','r','r','i','i','i','m','t','t','t','t','n','n','k','k','s','s','r','r','v','v','v','v','a','a','a','a','d','d','e','e','g','g','g','g'
		};
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
		image.setColor(Color.GOLD);

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


}
