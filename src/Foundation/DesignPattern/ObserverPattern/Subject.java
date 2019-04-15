package Foundation.DesignPattern.ObserverPattern;

import java.util.ArrayList;

public class Subject {
    ArrayList<Observer> obs = new ArrayList<Observer>();
    int state = 0;
    public void attend(Observer ob){
        this.obs.add(ob);
    }

    public void setState(int state){
        this.state = state;
        this.notifyAllObs();
    }
    
    public int getState(){
        return this.state;
    }
    
    public void notifyAllObs(){
        for (Observer ob :
                obs) {
            ob.update();
        }
    }
}
