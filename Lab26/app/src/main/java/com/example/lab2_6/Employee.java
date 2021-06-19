package com.example.lab2_6;


public class Employee {
    private String _id;
    private String _fullName;
    private boolean _mangager;
    public void setId(String id){
        this._id = id;
    }

    public void setFullName(String fullName){
        this._fullName = fullName;
    }

    public String getId(){
        return this._id;
    }

    public String getFullName(){
        return this._fullName;
    }

    public boolean isManager(){
        return this._mangager;
    }

    public void setManager(boolean Manager) {
        this._mangager = Manager;
    }
}

