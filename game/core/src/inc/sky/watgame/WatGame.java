package inc.sky.watgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class WatGame extends ApplicationAdapter {
	Input i;
	float dt;

	@Override
	public void create () {
		this.i = new Input();
		Gdx.input.setInputProcessor(i);
		StateManager.getStateManager().pushState(new MenuState());
	}

	@Override
	public void render () {
		this.dt = Gdx.graphics.getDeltaTime();
		StateManager.getStateManager().getCurrentState().render(dt);
	}

	@Override
	public void dispose () {
		StateManager.getStateManager().dispose();
	}
}
