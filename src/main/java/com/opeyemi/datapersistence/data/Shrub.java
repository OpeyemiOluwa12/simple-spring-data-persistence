package com.opeyemi.datapersistence.data;

import javax.persistence.Entity;

@Entity(name = "shrub")
public class Shrub extends Plant {

    Double height;
    Double weight;

    public Shrub(String name, double price) {
        super(name, price);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
