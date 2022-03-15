package com.sjtu.team.domain;

import com.sjtu.team.service.Status;

public class Programmer extends Employee{

    private int memberId;
    private Equipment equipment;
    private Status status = Status.FREE;
    public Programmer() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getDetails()+"\t"+"程序员"+
                "\t"+status+
                "\t\t\t\t\t" + equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public Programmer(int id, int age, String name, double salary, Equipment equipment) {
        super(id, age, name, salary);
        this.equipment = equipment;
    }

    public String getBaseDetail(){
        return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t";
    }
    public String getDetailsTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return getBaseDetail()+"程序员";
    }
}
