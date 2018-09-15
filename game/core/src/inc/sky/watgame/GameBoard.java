package inc.sky.watgame;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameBoard {
    //TODO: Add functionality to hold holes... Maybe not ArrayLists
    private Hole[][] holes;
    public GameBoard(int rows, int cols, int x, int y, int width, int height){
        this.holes = new Hole[cols][rows];
        //TODO: INIT ALL HOLES
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                holes[j][i] = new Hole(x + j * width / cols, y + i * height / rows, width / cols, height / rows);
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
