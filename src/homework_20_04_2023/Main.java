package homework_20_04_2023;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    /*
    Задача1
Есть класс Person с полями
String name
int age
String address

1.  Используя стримы, написать метод, принимающий список персонов и возвращающий мапу,
 где возраст является ключом, а список персонов этого возраста значением
     */
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                        new Person("Jack",40,"Berliner"),
                        new Person("John",25,"Gasse"),
                        new Person("Helen",15,"Dilingen"),
                        new Person("Ann",17,"Vogteistraße"));

        System.out.println(ageIsKeyPerson(personList)); // output-{17=[Ann], 40=[Jack], 25=[John], 15=[Helen]}

        //------------------------------- 2 --------------------------------------------------

        System.out.println(personName(personList));  // output - 65
    }

    public static Map<Integer, List<Person>> ageIsKeyPerson(List<Person> list ){
        return list.stream()
                .collect(Collectors.groupingBy(Person::getAge));

    }

    //-------------------// 2 \\---------------------------------------\\
    //Задача2
    //Используя тот же класс Person, написать метод, принимающий список персонов
    // и возвращающий общий возраст тех, кто старше 17 лет.


   public static int personName (List<Person> list){
        return list.stream()
                .filter(p->p.getAge()>17)
                .collect(Collectors.summingInt(Person::getAge));
   }

}

