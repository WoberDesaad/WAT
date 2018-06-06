package inc.sky.watgame;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameBoard {
    //TODO: Add functionality to hold holes... Maybe not ArrayLists
    private Hole[][] holes;
    private Input in;
    public GameBoard(int rows, int cols, int x, int y, int width, int height, Input in){
        this.holes = new Hole[cols][rows];
        this.in = in;
        //TODO: INIT ALL HOLES
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                holes[j][i] = new Hole(x + j * width / cols, y + i * height / rows, width / cols, height / rows, this.in);
            }
        }
    }

    //TODO: Make sure dt as a float will work
    public void update(float dt){
        for(Hole[] ha : this.holes){
            for(Hole h : ha){
                h.update(dt);
            }
        }
    }

    //TODO: Include necessary params to render stuff
    public void render(SpriteBatch batch){
        for(Hole[] ha : this.holes){
            for(Hole h : ha){
                h.render(batch);
            }
        }
    }

    public void dispose(){
        for(Hole[] ha : this.holes){
            for(Hole h : ha){
                h.dispose();
            }
        }
    }
}
