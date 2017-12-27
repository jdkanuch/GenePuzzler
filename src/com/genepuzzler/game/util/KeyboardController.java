package com.genepuzzler.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class KeyboardController implements InputProcessor {
	public boolean left,right,up,down;
	public boolean cLeft,cRight,cUp,cDown;
	public boolean isMouse1Down, isMouse2Down,isMouse3Down;
	public boolean isDragged;
	public Vector2 mouseLocation = new Vector2();

	@Override
	public boolean keyDown(int keycode) {

		boolean keyProcessed = false;
		switch (keycode) // switch code base on the variable keycode
		{
		case Keys.D:
			cRight = true;
			keyProcessed = true;
			break;
		case Keys.A:
			cLeft = true;
			keyProcessed = true;
			break;
		case Keys.W:
			cUp = true;
			keyProcessed = true;
			break;
		case Keys.S:
			cDown = true;
			keyProcessed = true;
			break;
		case Keys.LEFT:  	// if keycode is the same as Keys.LEFT a.k.a 21
		left = true;	// do this
		keyProcessed = true;
		break;	// we have reacted to a keypress so stop checking for more
		case Keys.RIGHT: 	// if keycode is the same as Keys.LEFT a.k.a 22
			right = true;	// do this
			keyProcessed = true;
			break;	// we have reacted to a keypress so stop checking for more
		case Keys.UP: 		// if keycode is the same as Keys.LEFT a.k.a 19
			up = true;		// do this
			keyProcessed = true;
			break;			// we have reacted to a keypress so stop checking for more
		case Keys.DOWN: 	// if keycode is the same as Keys.LEFT a.k.a 20
			down = true;	// do this
			keyProcessed = true;

		}
		return keyProcessed;	// no keys pressed that we care about so return false
	}

	@Override
	public boolean keyUp(int keycode) {
		boolean keyProcessed = false;
		switch (keycode) // switch code base on the variable keycode
		{
		case Keys.D:
			cRight = false;
			keyProcessed = true;
			break;
		case Keys.A:
			cLeft = false;
			keyProcessed = true;
			break;
		case Keys.W:
			cUp = false;
			keyProcessed = true;
			break;
		case Keys.S:
			cDown = false;
			keyProcessed = true;
			break;
		case Keys.LEFT:  	// if keycode is the same as Keys.LEFT a.k.a 21
		left = false;	// do this
		keyProcessed = true;	// we have reacted to a keypress 
		break;
		case Keys.RIGHT: 	// if keycode is the same as Keys.LEFT a.k.a 22
			right = false;	// do this
			keyProcessed = true;	// we have reacted to a keypress 
			break;
		case Keys.UP: 		// if keycode is the same as Keys.LEFT a.k.a 19
			up = false;		// do this
			keyProcessed = true;	// we have reacted to a keypress 
			break;
		case Keys.DOWN: 	// if keycode is the same as Keys.LEFT a.k.a 20
			down = false;	// do this
			keyProcessed = true;	// we have reacted to a keypress
		}
		return keyProcessed;	//  return our peyProcessed flag
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == 0){
			isMouse1Down = true;
		}else if(button == 1){
			isMouse2Down = true;
		}else if(button == 2){
			isMouse3Down = true;
		}
		mouseLocation.x = screenX;
		mouseLocation.y = screenY;
		//System.out.println("Gdx.graphics.getWidth() : "+Gdx.graphics.getWidth()+","+Gdx.graphics.getHeight());
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		isDragged = false;
		//System.out.println(button);
		if(button == 0){
			isMouse1Down = false;
		}else if(button == 1){
			isMouse2Down = false;
		}else if(button == 2){
			isMouse3Down = false;
		}
		mouseLocation.x = screenX;
		mouseLocation.y = screenY;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		isDragged = true;
		mouseLocation.x = screenX;
		mouseLocation.y = screenY;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
