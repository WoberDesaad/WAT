package inc.sky.watgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WatGame extends ApplicationAdapter {
	SpriteBatch batch;
	GameBoard gb;
	Input i;
	int ScreenX, ScreenY;
	BitmapFont font;
	int hits;
	float dt;

	@Override
	public void create () {
		//Getting Screen Dimensions
		ScreenX = Gdx.graphics.getWidth();
		ScreenY = Gdx.graphics.getHeight();

		hits = 0;
		batch = new SpriteBatch();
	    font = new BitmapFont();
		font.getData().setScale(8.0f);
		gb = new GameBoard(3, 3, ( ScreenX - 900 ) / 2, 0, 900, 900);
		i = new Input();
		Gdx.input.setInputProcessor(i);
	}

	@Override
	public void render () {
	    dt = Gdx.graphics.getDeltaTime();
	    //Inputs are now handled by Input i... Modify that class for more functionality
		if(i.isTouching()){
			if(gb.checkForHits(i.touchPosition())){
				hits ++;
			}
		}
		//TODO: Check for hits and update score if necessary
	    //TODO: Update Game State
        //gb.update(dt);


		//Clear Screen
		Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
	    //TODO: Draw Background
		//TODO: Draw Board
		font.draw(batch, Integer.toString(hits), 100, ScreenY-100);
		gb.render(batch);
		//TODO: Draw GUI
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		gb.dispose();
	}
}
