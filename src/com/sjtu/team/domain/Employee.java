package com.sjtu.team.domain;

import com.sjtu.team.service.Status;

public class Employee {
    private int id;
    private int age;
    private String name;
    private double salary;


    public Employee() {
    }


    public Employee(int id, int age, String name, double salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDetails(){
        return id +
                "\t" + age +
                "\t" + name  +
                "\t" + salary;
    }
    @Override
    public String toString() {
        return  getDetails();
    }
}
