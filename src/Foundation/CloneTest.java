package Foundation;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.Objects;

public class CloneTest {

    protected void protectTest(){
        System.out.println("PROT");
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        Student xhr = new Student("xhr");

//        Student hk = xhr;
        Address add = new Address();
        add.setAdd("550");
        Age age = new Age();
        age.setYear(1995);
        age.setLife(25);

        xhr.setAddress(add);
        xhr.setAge(age);

        Student hk = xhr.clone();
        xhr.name = "XHR";
        xhr.address.setAdd("626");

//        hk.setAddress(add1);
//        hk.setAge(age);

        System.out.println(xhr);
        System.out.println(hk);
    }
}

class Student implements Cloneable{

    public Student(String name){
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    Address address;
    Age age;
    String name;
    @Override
    public String toString() {
        return "Name: "+name+" Address: "+address.toString()+" Age: "+age.toString();
    }

    public Student clone()throws CloneNotSupportedException{
        Student sub = (Student) super.clone();
        sub.address = (Address) address.clone();
        sub.age = (Age) age.clone();
        return sub;
    }
}

class Address implements Cloneable{
    String add;

    public Address(){}
    public Address(String add){
        this.add = add;
    }
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return add;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Age implements Cloneable{
    Integer year;
    int life;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return " Year: "+year.toString()+" Life: "+life;
    }

    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return clone;
    }
}