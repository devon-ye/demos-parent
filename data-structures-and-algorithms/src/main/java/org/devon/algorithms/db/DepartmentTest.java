package org.devon.algorithms.db;

import java.util.*;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/5/31 20:41
 */
public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);
        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);


        List<Department> subDepartments = DepartmentTest.getSub(3, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门)
     *
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        TreeMap<Integer, List<Department>> parentPartList = new TreeMap<>();
        for (Department department : allDepartment) {
            List<Department> departments = parentPartList.get(department.getPid());
            if (departments == null) {
                departments = new ArrayList<>();
            }
            departments.add(department);
            parentPartList.put(id, departments);
        }
        return null;
    }

    private void build(Node node,Map<Integer, List<Department>> map){
        for (Map.Entry<Integer, List<Department>> entry : map.entrySet()) {
            Node  root = new Node(entry.getKey(),entry.getValue());
        }
    }




    private class Node {
        int pid;
        List<Department> departments;

        public Node() {
        }

        public Node(int pid, List<Department> departments) {
            this.pid = pid;
            this.departments = departments;
        }
    }
}

class Department {
    /**
     * id
     */
    private int id;
    /**
     * parent id
     */
    private int pid;
    /**
     * 名称
     */
    private String name;

    public Department(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}