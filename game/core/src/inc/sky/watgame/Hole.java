package inc.sky.watgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Hole {
    public enum states{
        empty,
        occupied
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
        batch.draw(this.img, this.x, this.y);
        //TODO: Draw Back of hole
        if(this.state == states.empty){
            //TODO: Draw character in animation state
        }
        //TODO: Draw Front of hole
    }

    public void update(float dt){
        if(this.state == states.empty){
            //TODO: Randomly change to occupied
        }
        if(this.state == states.occupied){
            //TODO: Add dt to animation time, Change frame if necessary
        }
    }

    //TODO: Add method to get hole to have a mole

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
