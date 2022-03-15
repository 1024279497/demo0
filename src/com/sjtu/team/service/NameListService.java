package com.sjtu.team.service;

import com.sjtu.team.domain.*;

public class NameListService {

    private Employee[] employees;

    /**
     * 给Employee[]进行初始化
     */
    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];
        for(int i =0;i<employees.length;i++){
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            String name = Data.EMPLOYEES[i][2];
            Equipment equipment;
            double bonus;
            switch(type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,age,name,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = getEquipment(i);
                    employees[i] = new Programmer(id,age,name,salary,equipment);
                    break;
                case Data.DESIGNER:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    equipment = getEquipment(i);
                    employees[i] = new Designer(id,age,name,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    equipment = getEquipment(i);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,age,name,salary,equipment,bonus,stock);
                    break;
            }

        }

    }
    //如下的EQIPMENTS数组与上面的EMPLOYEES数组元素一一对应
    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, type, name
    private Equipment getEquipment(int i) {
        int index = Integer.parseInt(Data.EQIPMENTS[i][0]);
        String modelOrType = Data.EQIPMENTS[i][1];
        switch(index){
            case Data.PC:
                String display = Data.EQIPMENTS[i][2];
                //equipment = new PC(modelOrType,display);
                return new PC(modelOrType,display);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(Data.EQIPMENTS[i][2]);
                //equipment = new NoteBook(modelOrType,price);
                return new NoteBook(modelOrType,price);
            case Data.PRINTER:
                String name = Data.EQIPMENTS[i][2];
                //equipment = new Printer(modelOrType,name);
                return new Printer(modelOrType,name);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到员工");
    }
}
