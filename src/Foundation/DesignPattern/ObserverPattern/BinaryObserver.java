package Foundation.DesignPattern.ObserverPattern;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        subject.attend(this);
    }

    public void update(){
        System.out.println("BinaryObserver State is "+subject.getState());
    }
}
