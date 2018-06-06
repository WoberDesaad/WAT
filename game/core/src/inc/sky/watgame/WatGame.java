package inc.sky.watgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class WatGame extends ApplicationAdapter {
	Input i;
	float dt;
	StateManager sm;

	@Override
	public void create () {
		i = new Input();
		Gdx.input.setInputProcessor(i);
		sm = new StateManager();
		sm.putState(new PlayState(i));
	}

	@Override
	public void render () {
		dt = Gdx.graphics.getDeltaTime();
		sm.getCurrentState().render(dt);
	}

	@Override
	public void dispose () {
		sm.dispose();
	}
}
