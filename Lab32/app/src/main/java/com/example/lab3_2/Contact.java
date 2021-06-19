package com.example.lab3_2;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phone){
        this.name = name;
        this.phoneNumber = phone;
    }

    public Contact(){};
}
