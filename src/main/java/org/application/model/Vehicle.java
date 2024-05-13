package org.application.model;


import javax.persistence.*;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cost;
    private int year;
    private double mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_model_id")
    private VehicleModel vehicleModelId;

    public Vehicle(double cost, int year, double mileage, VehicleModel vehicleModelId) {
        this.cost = cost;
        this.year = year;
        this.mileage = mileage;
        this.vehicleModelId = vehicleModelId;
    }

    public Vehicle() {

    }
    public VehicleModel getVehicleModelId() {
        return vehicleModelId;
    }



    public void setVehicleModelId(VehicleModel vehicleModel) {
        this.vehicleModelId = vehicleModel;
    }


    public long getId() {
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

}
