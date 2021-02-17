package com.opeyemi.datapersistence.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "delivery")
@NamedQueries({
        @NamedQuery(name = "Delivery.getByName", query = "select d from Delivery d where d.recipientName = :name")
})
public class Delivery {


    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String recipientName;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    private Boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    List<Plant> plants;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Delivery(String recipientName, String address, LocalDateTime deliveryTime, List<Plant> plantList) {
        this.recipientName = recipientName;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.plants = plantList;
    }
}
