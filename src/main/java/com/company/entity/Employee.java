package com.company.entity;

public class Row {

    private String name;
    private Integer id;
    private Integer mid;

    Row(String name, Integer id, Integer mid) {
        this.name = name;
        this.id = id;
        this.mid = mid;
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
