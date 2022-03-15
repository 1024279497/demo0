package com.sjtu.team.domain;

public class Designer extends Programmer{
    private double bonus;

    public Designer() {
    }

    public Designer(int id, int age, String name, double salary, Equipment equipment, double bonus) {
        super(id, age, name, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+"\t"+"设计师" +
                "\t"+getStatus()+ "\t"+bonus+
                "\t\t\t" + getEquipment();
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public String getDetailsTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return getBaseDetail()+"设计师"+"\t"+bonus;
    }
}
