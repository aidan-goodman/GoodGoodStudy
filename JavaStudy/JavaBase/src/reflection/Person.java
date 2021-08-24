package reflection;

import java.util.Objects;

public class Person {
    private String name;
    int age;
    String nation;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name, int age, String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) &&
                Objects.equals(nation, person.nation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }

    private String show() {
        return name+"'s nation=" + nation;
    }
}
