package inc.sky.watgame;

import java.util.Stack;

public class StateManager {
    static StateManager sm;

    Stack<State> stateStack;
    State tmp;

    public StateManager(){
        this.stateStack = new Stack<State>();
    }

    public static StateManager getStateManager(){
        if(sm == null){
            sm = new StateManager();
        }
        return sm;
    }

    public void pushState(State s){
        stateStack.push(s);
    }

    public void popState(){
        State tmp = stateStack.peek();
        tmp.dispose();
        stateStack.pop();
    }

    public void swapState(State s){
        stateStack.pop();
        stateStack.push(s);
    }

    public void changeState(State s){
        tmp = s;
    }

    public State getCurrentState(){
        if(tmp != null){
            swapState(tmp);
            tmp = null;
        }
        return stateStack.peek();
    }

    public void dispose(){
        while(!stateStack.empty()){
            State tmp = stateStack.peek();
            tmp.dispose();
            stateStack.pop();
        }
    }
}
