package com.example.lab2_4;

public class Employee {
    private String id;
    private String name;
    private boolean manager;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }
    @Override
    public String toString() {
        return this.id+"-"+this.name;
    }

}