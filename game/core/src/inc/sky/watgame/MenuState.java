package inc.sky.watgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuState extends State {
    private Stage stage;
    Skin mySkin;

    public MenuState(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        mySkin = new Skin(Gdx.files.internal("flatEarth/flat-earth-ui.json"));
        TextButton playButton = new TextButton("Play",mySkin,"default");
        playButton.getLabel().setFontScale(3.0f);
        playButton.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/6);
        playButton.setPosition(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/3);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                StateManager.getStateManager().changeState(new PlayState());
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);
    }

    @Override
    public void render(float dt){
        Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}
