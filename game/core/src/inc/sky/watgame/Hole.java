package inc.sky.watgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Map;


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

    private Texture img;

    public Hole(int x, int y, int width, int height){
        this.state = states.empty;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = new Texture("badlogic.jpg");

    }

    public void render(SpriteBatch batch){
        //Dummy draw for now
        batch.draw(this.img, this.x, this.y);
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
        switch(this.state) {
            case empty:
                break;
            case movingUp:
                break;
            case occupied:
                break;
            case hit:
                break;
            case movingDown:
                break;
            default:
                System.err.println("You should not be here!");
                System.exit(-1);
        }
    }


    /**
     * @param x The x position of the finger
     * @param y The y position of the finger
     * @return True if the finger is within the hole's hitbox
     */
    public boolean hits(int x, int y){
        return (x > this.x && x < this.x+this.width && y > this.y && y > this.y + this.height);
    }

    public void dispose(){
        this.img.dispose();
    }
}
