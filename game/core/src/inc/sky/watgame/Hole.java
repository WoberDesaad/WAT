package inc.sky.watgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Hole {
    public enum states{
        empty,
        movingUp,
        occupied,
        hit,
        movingDown
    };

    private states state;
    private int x, y, width, height;
    float stateTime;

    private HashMap<states, Texture> imgs;

    Input in;

    public Hole(int x, int y, int width, int height, Input in){
        this.in = in;
        imgs = new HashMap<states, Texture>();
        imgs.put(states.empty, new Texture("green.jpg"));
        imgs.put(states.movingUp, new Texture("yellow.jpg"));
        imgs.put(states.movingDown, new Texture("yellow.jpg"));
        imgs.put(states.hit, new Texture("blue.jpg"));
        imgs.put(states.occupied, new Texture("red.jpg"));

        this.state = states.empty;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void render(SpriteBatch batch){
        //Dummy draw for now
        batch.draw(this.imgs.get(this.state), this.x, this.y);
        //TODO: Draw Back of hole
        switch(this.state) {
            case empty:
                //Do nothing just like this
                break;
            case movingUp:
                //Character moving from empty to occupied
                break;
            case occupied:
                //Character in position for some amount of time
                break;
            case hit:
                //character hit, moves to moving down after a few seconds
                break;
            case movingDown:
                //character returning to empty state
                break;
            default:
                System.err.println("You should not be here!");
                System.exit(-1);
        }
        //TODO: Draw Front of hole
    }

    /**
     * This method should update the animation state that the hole is in
     * @param dt delta time
     */
    public void update(float dt){
        Random r = new Random();
        switch(this.state) {
            case empty:
                if(r.nextFloat() < 0.001){
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
                break;
            case occupied:
                if(this.in.isTouching()){
                    int x = in.touchPosition().x;
                    int y = in.touchPosition().y;
                    System.out.print(x);
                    System.out.print(" ");
                    System.out.println(y);
                    if(x > this.x && x < this.x+this.width && y > this.y && y > this.y + this.height){
                        this.state = states.hit;
                        this.stateTime = 0;
                    }
                }

                stateTime += dt;
                if(stateTime > 2){
                    this.state = states.movingDown;
                    stateTime = 0;
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
            default:
                System.err.println("You should not be here!");
                System.exit(-1);
        }
    }

    public void dispose(){
        for(states s : this.imgs.keySet()){
            Texture t = this.imgs.get(s);
            this.imgs.remove(t);
            t.dispose();
        }
    }
}
