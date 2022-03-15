package com.sjtu.team.domain;

public class Architect extends Designer{

    private int stock;

    public Architect(int id, int age, String name, double salary, Equipment equipment, double bonus, int stock) {
        super(id, age, name, salary, equipment, bonus);
        this.stock = stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t"+"设计师" +
                "\t"+getStatus()+ "\t"+getBonus()+"\t"+getStock()+
                "\t" + getEquipment();
    }

    public int getStock() {
        return stock;
    }

    public Architect() {
    }

    public String getDetailsTeam(){
        //TID/ID	姓名	年龄	工资	职位	奖金	股票
        return getBaseDetail()+"设计师"+"\t"+getBonus()+"\t"+stock;
    }

}
