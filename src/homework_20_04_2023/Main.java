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

        ageIsKeyPerson(personList)
                .forEach((k,v) ->System.out.println(k+ "->"+v.stream()
                .map(Person::getName)
                .collect(Collectors.toList())));
        //------------------------------- 2 --------------------------------------------------

        System.out.println("total sge of person older than 17 is: "+personName(personList));
        System.out.println("total sge of person older than 17 is: "+personAgeReduce(personList));
        //total sge of person older than 17 is: 65
        //total sge of person older than 17 is: 65

        //-------------------------------- 3 --------------------------------------------------

        System.out.println(isLegalAge(personList));

    }
// 1.задача
    public static Map<Integer, List<Person>> ageIsKeyPerson(List<Person> list ){
        return list.stream()
                .collect(Collectors.groupingBy(Person::getAge));

    }

    //-------------------// 2 \\---------------------------------------\\
    //Задача2
    //Используя тот же класс Person, написать метод, принимающий список персонов
    // и возвращающий общий возраст тех, кто старше 17 лет.


    // Type 1
   public static int personName (List<Person> list){
        return list.stream()
                .filter(p -> p.getAge()>17)
                .mapToInt(Person::getAge)
                .sum();
                //.collect(Collectors.summingInt(Person::getAge));
   }
   // Type 2

    public static int personAgeReduce(List<Person> list){
        return list.stream()
                .filter(s -> s.getAge() >17)
                .map(Person::getAge)
                .reduce(0, Integer::sum); // reduce суммирует а+б функция акумулятор
    }

    // Задача 3.
    /*
    Написать метод, принимающий список персонов и возвращающий имена тех,
    кто является совершеннолетним в Германии (старше 18 лет).
    Должна быть возвращена примерно следующая строка:
     in Germany Jack and John are of legal age (имена по вашему выбору, это пример)
     */

    public static String isLegalAge (List<Person> list){
        return list.stream()
                .filter(p -> p.getAge()>18)
                .map(Person::getName)
                .collect(Collectors.joining(" and ","in Germany ", "are of legal age"));
    }

}

