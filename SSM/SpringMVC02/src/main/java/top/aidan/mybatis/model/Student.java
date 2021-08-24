package top.aidan.mybatis.model;


import top.aidan.validation.ValidationGroup1;
import top.aidan.validation.ValidationGroup2;

import javax.validation.constraints.*;

/**
 * Created by Aidan on 2021/8/18 23:56
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Student {
    @NotNull(message = "{student.name.notnull}", groups = {ValidationGroup1.class, ValidationGroup2.class})
    @Size(min = 2, max = 10, message = "学生名称长度应该介于 2-10 之间",groups = ValidationGroup1.class)
    private String name;
    @NotNull
    private Integer id;
    @Email
    private String email;
    @Max(30)
    @Min(15)
    private Integer age;
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
