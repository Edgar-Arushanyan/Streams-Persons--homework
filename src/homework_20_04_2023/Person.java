package homework_20_04_2023;

public class Person {

    String name;

    int age;

    String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }



    public int getAge() {
        return age;
    }

    public String toString() {
        return  name ;
    }
}
