package inc.sky.watgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Hole extends InputListener {
    public enum states{
        empty,
        movingUp,
        occupied,
        hit,
        movingDown,
        missed
    };

    private states state;
    private int x, y, width, height;
    float stateTime;

    private HashMap<states, Texture> imgs;

    public Hole(int x, int y, int width, int height){
        imgs = new HashMap<states, Texture>();
        imgs.put(states.empty, new Texture("black.jpg"));
        imgs.put(states.movingUp, new Texture("yellow.jpg"));
        imgs.put(states.movingDown, new Texture("yellow.jpg"));
        imgs.put(states.hit, new Texture("blue.jpg"));
        imgs.put(states.occupied, new Texture("red.jpg"));
        imgs.put(states.missed, new Texture("purple.jpg"));

        this.state = states.empty;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void render(SpriteBatch batch){
        //Dummy draw for now
        batch.draw(this.imgs.get(this.state), this.x, this.y);
    }

    /**
     * This method should update the animation state that the hole is in
     * @param dt delta time
     */
    public void update(float dt){
        Random r = new Random();
        switch(this.state) {
            case empty:
                if(r.nextFloat() < 0.01){
                    this.state = states.movingUp;
                    this.stateTime = 0;
                }
                break;
            case movingUp:
                stateTime += dt;
                if(stateTime > 1){
                    this.state = states.occupied;
                    stateTime = 0;
                }

                if(this.isHit()){
                    this.state = states.missed;
                    this.stateTime = 0;
                }
                break;
            case occupied:
                this.stateTime += dt;

                if(this.stateTime >= 2){
                    this.state = states.movingDown;
                    this.stateTime = 0;
                }else if(this.isHit()){
                    this.state = states.hit;
                    ScoreBoard.getScoreBoard().addToScore((int)(10.0f * (2.0f / (2.0f - this.stateTime))));
                    this.stateTime = 0;
                }

                break;
            case hit:
                stateTime += dt;
                if(stateTime > 0.5){
                    this.state = states.empty;
                    stateTime = 0;
                }
                break;
            case movingDown:
                stateTime += dt;
                if(stateTime > 1){
                    this.state = states.empty;
                    stateTime = 0;
                }
                break;
            case missed:
                stateTime += dt;
                if(stateTime > 1){
                    this.state = states.empty;
                    stateTime = 0;
                }
                break;
            default:
                System.err.println("You should not be here!");
                System.exit(-1);
        }
    }

    public boolean isHit(){
        //if(this.in.isTouching()){
        //    Point tp = in.touchPosition();
        //    if(tp.x > this.x && tp.x < this.x + this.imageWidth() && tp.y > this.y && tp.y < this.y + this.imageHeight()){
        //        return true;
        //    }
        //}
        return false;
    }

    public int imageWidth(){
        Texture t = this.imgs.get(this.state);
        if(t != null){
            return t.getWidth();

        }
        return -1;
    }

    public int imageHeight(){
        Texture t = this.imgs.get(this.state);
        if(t != null){
            return t.getHeight();

        }
        return -1;
    }

    public void dispose(){
        for(states s : this.imgs.keySet()){
            Texture t = this.imgs.get(s);
            this.imgs.remove(t);
            t.dispose();
        }
    }
}
