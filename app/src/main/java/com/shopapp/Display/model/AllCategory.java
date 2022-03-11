package com.shopapp.Display.model;

import java.util.List;

public class AllCategory {
    private String name;
    private String lastname;
    private int age;
    List<ItemCategory> categoryList;


    public AllCategory(String name, String lastname, int age, List<ItemCategory> categoryList) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.categoryList=categoryList;

    }



    public List<ItemCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<ItemCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
