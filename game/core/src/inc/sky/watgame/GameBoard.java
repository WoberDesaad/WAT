package inc.sky.watgame;


public class GameBoard {
    //TODO: Add functionality to hold holes... Maybe not ArrayLists
    private Hole[][] holes;
    public GameBoard(int rows, int cols){
        this.holes = new Hole[cols][rows];
        //TODO: INIT ALL HOLES
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
    public void render(){
        for(Hole[] ha : this.holes){
            for(Hole h : ha){
                h.render();
            }
        }
    }

}
