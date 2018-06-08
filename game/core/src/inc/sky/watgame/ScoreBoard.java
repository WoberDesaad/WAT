package inc.sky.watgame;

public class ScoreBoard {
    private static ScoreBoard sb = new ScoreBoard();
    private int score;

    private ScoreBoard(){
        this.score = 0;
    }

    static ScoreBoard getScoreBoard(){
        return sb;
    }

    public void resetScoreBoard(){
        this.score = 0;
    }

    public int getScore(){
        return score;
    }

    public void addToScore(int points){
        this.score += points;
    }

    //TODO: Implement Later
    public void render(){

    }
}
