package com.aidan.json;

import com.aidan.pojo.Person;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonTest {
    @Test
    public void test1() {
        Person person = new Person(123, "Aidan");

        // 创建一个Gson实例
        Gson gson = new Gson();
        // 将对象转换为JSON字符串
        String personToJsonString = gson.toJson(person);
        System.out.println(personToJsonString);

        // 从字符串转换为Person对象（参数2表示对象类）
        Person personFromJsonClass = gson.fromJson(personToJsonString, Person.class);
        System.out.println(person);
        System.out.println(personFromJsonClass);
    }

    @Test
    public void test2() {
        // 创建多个对象
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(123, "Aidan"));
        personList.add(new Person(124, "Edward"));
        personList.add(new Person(125, "Jack"));

        Gson gson = new Gson();

        String personListToJsonString = gson.toJson(personList);
        System.out.println(personListToJsonString);

        // 将字符串转换会List集合时不能直接通过获取类的方式进行转换，需要使用辅助类
        // List fromJson = gson.fromJson(personListToJsonString, personList.getClass());

        // 创建类型辅助的匿名类，获取其 Type
        List personListFromJson = gson.fromJson(personListToJsonString, new PersonListType().getType());
        System.out.println(personListFromJson.get(0));
    }

    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();

        personMap.put(1, new Person(123, "Aidan"));
        personMap.put(2, new Person(124, "Edward"));
        personMap.put(3, new Person(125, "Tom"));

        Gson gson = new Gson();

        String personMapToJsonString = gson.toJson(personMap);
        System.out.println(personMapToJsonString);

        Map personMapFromJson = gson.fromJson(personMapToJsonString, new personMapType().getType());
        System.out.println(personMapFromJson.get(1));
    }
}
