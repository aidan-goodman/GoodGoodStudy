package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserTest implements Comparable {
    private String name;
    private int age;

    public UserTest(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTest userTest = (UserTest) o;
        return age == userTest.age && Objects.equals(name, userTest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof UserTest) {
            UserTest userTest = (UserTest) o;
            if (this.name.equals(userTest.name)) {
                return -(this.age - userTest.age);
            } else {
                return this.name.compareTo(userTest.name);
            }
        } else {
            throw new RuntimeException("类型错误");
        }
    }

    //泛型方法
    public <E> List<E> copy(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e :
                arr) {
            list.add(e);
        }
        return list;
    }
}
