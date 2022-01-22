package common;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Person("shixian", 13);
        people[1] = new Person("aili", 17);
        people[2] = new Person("leijiayin", 17);
        people[3] = new Person("pinru", 15);
        Arrays.sort(people);
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (!(o1.age == o2.age)) {
                    return Integer.compare(o1.age, o2.age);
                } else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}

class Person implements Comparable {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            if (!this.name.equals(person.name)) {
                return this.name.compareTo(person.name);
            } else {
                return Integer.compare(this.age, person.age);
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = this.name + ":" + this.age;
        return str;
    }
}