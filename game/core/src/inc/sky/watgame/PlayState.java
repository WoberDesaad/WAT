package inc.sky.watgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
    int ScreenX, ScreenY;
    BitmapFont font;
    int hits;
    SpriteBatch batch;
    GameBoard gb;
    Input i;

    public PlayState(Input i){
        //Getting Screen Dimensions
		ScreenX = Gdx.graphics.getWidth();
		ScreenY = Gdx.graphics.getHeight();
        this.i = i;
        hits = 0;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(8.0f);
        gb = new GameBoard(3, 3 , ( ScreenX - 900 ) / 2, 0, 900, 900, i);
    }

    @Override
    public void render(float dt) {
        //Inputs are now handled by Input i... Modify that class for more functionality
        //TODO: Check for hits and update score if necessary
        //TODO: Update Game State
        gb.update(dt);


        //Clear Screen
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //TODO: Draw Background
        //TODO: Draw Board
        font.draw(batch, "fps: " + Float.toString(1/dt), 100, ScreenY-100);
        font.draw(batch, "Score: " + Integer.toString(ScoreBoard.getScoreBoard().getScore()), 100, ScreenY- 200);
        gb.render(batch);
        //TODO: Draw GUI
        batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.font.dispose();
    }
}
