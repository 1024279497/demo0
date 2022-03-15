package com.sjtu.team.domain;

public class PC implements Equipment{
    private String model;
    private String display;

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return  model + display ;
    }

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String getDescription() {
        return model +"("+display+")";
    }
}
