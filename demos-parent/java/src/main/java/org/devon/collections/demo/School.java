package org.devon.collections.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */
public class School {
    private String name;
    private List<Student> allStudents;

    public School() {
        allStudents = new ArrayList <>();
    }

    public School(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List <Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List <Student> allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public String toString() {
        return "School{" + "name='" + name + '\'' + '}';
    }
}
