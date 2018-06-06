package inc.sky.watgame;

import java.util.Stack;

public class StateManager {
    Stack<State> stateStack;

    public StateManager(){
        this.stateStack = new Stack<State>();
    }

    public void putState(State s){
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

    public State getCurrentState(){
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