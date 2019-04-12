package Foundation.DesignPattern;

public class Driver {
    Car car;
     public void setCar(Car car){
         this.car = car;
     }

     public void drive(){
         System.out.println("I drive by "+car.getId());
     }
}
