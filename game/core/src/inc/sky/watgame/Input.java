package inc.sky.watgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor {
    private boolean isTouching;
    private int touchX, touchY;

    public Input(){
        this.touchY = 0;
        this.touchX = 0;
    }

    public boolean isTouching(){
        return isTouching;
    }

    public Point touchPosition(){
        return new Point(this.touchX, this.touchY);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer == 0) {
            this.touchX = screenX;
            this.touchY = Gdx.graphics.getHeight() - screenY;
            this.isTouching = true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer==0) {
            this.isTouching = false;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(pointer == 0){
            this.touchX = screenX;
            this.touchY = screenY;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
