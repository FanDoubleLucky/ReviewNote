package Foundation.DesignPattern.ObserverPattern;

import java.util.ArrayList;

public class ObserverPatternMain {
    public static void main(String[] args) {
        Subject sub = new Subject();
        ArrayList<Observer> obs = new ArrayList<Observer>();
        obs.add(new BinaryObserver((sub)));
        obs.add(new OctalObserver((sub)));
        obs.add(new HexaObserver((sub)));
        sub.setState(199);

        sub.setState(999);
    }
}
