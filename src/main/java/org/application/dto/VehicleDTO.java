package org.application.dto;

import org.application.model.VehicleModel;

public class VehicleDTO {
    private Long id;
    private double cost;
    private int year;
    private double mileage;
    private VehicleModelDTO vehicleModelId;

    public VehicleDTO(Long id, double cost, int year, double mileage, VehicleModelDTO vehicleModelId) {
        this.id = id;
        this.cost = cost;
        this.year = year;
        this.mileage = mileage;
        this.vehicleModelId = vehicleModelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public VehicleModelDTO getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(VehicleModelDTO vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }
}
