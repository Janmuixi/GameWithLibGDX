package com.testinglibgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestingLibGDX extends ApplicationAdapter {
	SpriteBatch batch;
	Texture imgBomb, imgBackground;
	int personY, personX;
	Texture [] animPerson;
	int contadorAnimacion;
	@Override
	public void create () {
		contadorAnimacion = 0;
		batch = new SpriteBatch();
		animPerson = new Texture[4];
		animPerson[0] = new Texture("frame-1.png");
		animPerson[1] = new Texture("frame-2.png");
		animPerson[2] = new Texture("frame-3.png");
		animPerson[3] = new Texture("frame-4.png");
		imgBackground = new Texture("bg.png");
		imgBomb = new Texture("bomb.png");
		personY = Gdx.graphics.getHeight() / 2 - 450;
		personX = Gdx.graphics.getWidth() / 2 - 150;
	}

	@Override
	public void render () {

		if(Gdx.input.isTouched()) {
			personY += 50;
			if (contadorAnimacion < 3 ) {
				contadorAnimacion++;
			} else {
				contadorAnimacion = 0;
			}

		}
		if (personY >= 0) {
			personY -= 20;
		}

		batch.begin();
		batch.draw(imgBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(imgBomb, 500, 500);
		batch.draw(animPerson[contadorAnimacion], personX, personY);

		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
