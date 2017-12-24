package com.collections.demo;

import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */
public class Student {
    private String name;
    private int age;
    private School school;
    private List<Course> allCourses;


    public Student(String name, int age) {
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List <Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List <Course> allCourses) {
        this.allCourses = allCourses;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", school=" + school + '}';
    }
}
