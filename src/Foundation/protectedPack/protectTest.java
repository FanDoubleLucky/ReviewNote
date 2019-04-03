package Foundation.protectedPack;

public class protectTest {
    public void testPublic(){
        System.out.println("protectPublic");
    }
    protected void test(){
        System.out.println("protectTest");
    }

    public static void main(String[] args) {
        Student fyz = new Student("fyz");
        Student hm = fyz;
        fyz = new Student("hm");
        System.out.println(fyz.name+" "+hm.name);
    }
}

class Student{
    String name;
    public Student(String name){
        this.name = name;
    }
}
