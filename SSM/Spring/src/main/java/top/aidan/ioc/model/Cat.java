package top.aidan.ioc.model;

/**
 * Created by Aidan on 2021/8/15 15:52
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class Cat {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
