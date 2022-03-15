package com.sjtu.team.domain;

public class Printer implements Equipment{

    private String name;
    private String type;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name + type ;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Printer() {
    }

    public Printer(String type, String name) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
}
