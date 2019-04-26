package Foundation;

import java.io.Serializable;

public class SerializableObject extends SerializableFather implements Serializable {
    public String name;

    public String getAddress() {
        return this.address;
    }
    public SerializableObject(){
        super("");
    }
    public SerializableObject(String name){
        super(name);
        this.name = name;
    }
    private String address;
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }


    public void setAddress(String address){
        this.address = address;
    }
}
