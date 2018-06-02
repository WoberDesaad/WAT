package inc.sky.watgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class AnimationSet {

    int numFrames;
    int currFrame;
    int fps;
    float frameTime;
    float timePerFrame;

    Array<Texture> frames;

    /**
     * Create a new Animation Set
     * @param numFrames The number of frames in the set
     * @param fps The Frames Per Second count
     * @param animationSetName The folder that the frames will be located in
     */
    public AnimationSet(int numFrames, int fps, String animationSetName){
        this.numFrames = numFrames;
        this.fps = fps;
        this.frameTime = 0;
        this.timePerFrame = 1/((float)this.fps);
        this.currFrame = 0;

        //TODO: Load textures based on string animationSetName
    }

    /**
     * This method updates the frame time to progress the animation
     * @param dt delta time
     */
    public void update(float dt){
        this.frameTime += dt;
        while(this.frameTime >= this.timePerFrame){
            this.frameTime -= this.timePerFrame;
            this.currFrame++;
            this.currFrame = this.numFrames%this.currFrame;
        }
    }

    /**
     * This method retreives the current animation frame texture
     * @return The texture of the current animation frame
     */
    public Texture getCurrentFrame(){
        return this.frames.get(this.currFrame);
    }

    public void reset(){
        this.currFrame = 0;
        this.frameTime = 0;
    }
}
