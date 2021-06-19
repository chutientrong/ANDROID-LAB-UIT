package com.example.lab2_3;

public class EmployeeFullTime extends Employee {

    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        // Auto-generated method stub
        return super.toString() +" -->FullTime="+TinhLuong();
    }
}