package com.aidan.json;

import com.aidan.pojo.Person;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

// 通过 TypeToken 进行类型的声明
public class PersonListType extends TypeToken<ArrayList<Person>> {
}
