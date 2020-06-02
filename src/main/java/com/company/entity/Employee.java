package com.company.entity;

public class Employee {

    private String name;
    private Integer id;
    private Integer mid;

    public Employee(String name, Integer id, Integer mid) {
        this.name = name;
        this.id = id;
        this.mid = mid;
    }


    @Override
    public String toString() {
        return "name:" + this.name + " id:"+ id + " mid:" + mid;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMid() {
        return mid;
    }

}
