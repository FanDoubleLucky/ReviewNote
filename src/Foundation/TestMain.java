package Foundation;

import java.io.IOException;
import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {
        Animal an = new Cat();
        an.eat();
        ArrayList<Animal> ans = new ArrayList<Animal>();
        ans.add(new Cat());
        ans.add(new Dog());
        //运行多态的体现
        for (Animal oneAnimal: ans) {
            oneAnimal.call();
        }

        Cat tom = new Cat();
        Cat jack = new Cat();
        Cat frank;
        tom.life = 10;
        jack = tom;
        tom.life = 100;
        frank = jack;
        System.out.println(tom.life);
        System.out.println(jack.life);
        System.out.println(frank.life);

        MyArrayList<Animal> animalsWorld = new MyArrayList<Animal>();
        animalsWorld.add(tom);
    }
}
