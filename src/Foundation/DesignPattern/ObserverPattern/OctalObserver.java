package Foundation.DesignPattern.ObserverPattern;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        subject.attend(this);
    }

    public void update(){
        System.out.println("OctalObserver State is "+subject.getState());
    }
}
