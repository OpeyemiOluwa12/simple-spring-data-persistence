package com.opeyemi.datapersistence.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flower")
public class Flower extends Plant {


    private String color;

    public Flower(String name, double price) {
        super(name, price);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
