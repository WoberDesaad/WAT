package inc.sky.watgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PlayState extends State {
    int ScreenX, ScreenY;
    BitmapFont font;
    int hits;
    SpriteBatch batch;
    GameBoard gb;
    private Stage stage;
    Skin mySkin;

    public PlayState(){
        //Getting Screen Dimensions
		ScreenX = Gdx.graphics.getWidth();
		ScreenY = Gdx.graphics.getHeight();
        hits = 0;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(8.0f);
        gb = new GameBoard(3, 3 , ( ScreenX - 900 ) / 2, 0, 900, 900);

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        mySkin = new Skin(Gdx.files.internal("flatEarth/flat-earth-ui.json"));
        TextButton playButton = new TextButton("Play",mySkin,"default");
        playButton.getLabel().setFontScale(3.0f);
        playButton.setSize(Gdx.graphics.getWidth()/9,Gdx.graphics.getHeight()/12);
        playButton.setPosition(Gdx.graphics.getWidth()*5.0f/3.0f,Gdx.graphics.getHeight()*5.0f/3.0f);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                StateManager.getStateManager().changeState(new MenuState());
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);

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

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.font.dispose();
    }
}
