package com.Mamoun.HRFDE.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loads")
public class Load {

    @Id
    @Column(name = "load_id")
    private UUID loadId;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "pickup_datetime")
    private String pickupDatetime;

    @Column(name = "delivery_datetime")
    private String deliveryDatetime;

    @Column(name = "equipment_type")
    private String equipmentType;

    @Column(name = "loadboard_rate")
    private Double loadboardRate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "commodity_type")
    private String commodityType;

    @Column(name = "num_of_pieces")
    private Integer numOfPieces;

    @Column(name = "miles")
    private Double miles;

    @Column(name = "dimensions")
    private String dimensions;

    // Getters and Setters

    public UUID getLoadId() {
        return loadId;
    }

    public void setLoadId(UUID loadId) {
        this.loadId = loadId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(String pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public String getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setDeliveryDatetime(String deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Double getLoadboardRate() {
        return loadboardRate;
    }

    public void setLoadboardRate(Double loadboardRate) {
        this.loadboardRate = loadboardRate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public Integer getNumOfPieces() {
        return numOfPieces;
    }

    public void setNumOfPieces(Integer numOfPieces) {
        this.numOfPieces = numOfPieces;
    }

    public Double getMiles() {
        return miles;
    }

    public void setMiles(Double miles) {
        this.miles = miles;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
