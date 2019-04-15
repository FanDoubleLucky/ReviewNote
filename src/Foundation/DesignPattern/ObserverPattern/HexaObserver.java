package Foundation.DesignPattern.ObserverPattern;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attend(this);
    }

    @Override
    public void update() {
        System.out.println("HexaObserver State is "+subject.getState());
    }
}