package top.aidan.mybatis.model;

import java.util.List;

/**
 * Created by Aidan on 2021/8/18 15:35
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Author {
    private String name;
    private Integer age;
    private List<String> favorites;
    private List<Role> roles;



    public Author() {
    }

    public Author(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

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

    public Author(String name, Integer age, List<String> favorites) {
        this.name = name;
        this.age = age;
        this.favorites = favorites;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favorites=" + favorites +
                ", roles=" + roles +
                '}';
    }

}
