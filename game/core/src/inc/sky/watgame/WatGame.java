package inc.sky.watgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class WatGame extends ApplicationAdapter {
	Input i;
	float dt;
	StateManager sm;

	@Override
	public void create () {
		this.i = new Input();
		Gdx.input.setInputProcessor(i);
		this.sm = new StateManager();
		this.sm.putState(new PlayState(i));
	}

	@Override
	public void render () {
		this.dt = Gdx.graphics.getDeltaTime();
		this.sm.getCurrentState().render(dt);
	}

	@Override
	public void dispose () {
		sm.dispose();
	}
}
