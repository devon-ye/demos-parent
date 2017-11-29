package com.collections.demo;

import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */
public class Course {
    private String name;
    private int credit;
    private List<Student> allStudents;

    public Course() {
    }

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List <Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List <Student> allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public String toString() {
        return "Course{" + "name='" + name + '\'' + ", credit=" + credit + '}';
    }
}
