package inc.sky.watgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WatGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameBoard gb;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	    gb = new GameBoard(3, 3);
	}

	@Override
	public void render () {
	    float dt = Gdx.graphics.getDeltaTime();
		//TODO: Get Inputs
		//TODO: Check for hits and update score if necessary
	    //TODO: Update Game State
        //gb.update(dt);


		//Clear Screen
		Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    //TODO: Draw Background
		//TODO: Draw Board
		//TODO: Draw GUI
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
