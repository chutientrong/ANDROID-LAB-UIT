package com.example.lab2_3;

public class EmployeePartTime extends Employee {

    @Override
    public double TinhLuong() {
        // Auto-generated method stub
        return 150;
    }
    @Override
    public String toString() {
        // Auto-generated method stub
        return super.toString() +" -->PartTime="+TinhLuong();
    }
}
