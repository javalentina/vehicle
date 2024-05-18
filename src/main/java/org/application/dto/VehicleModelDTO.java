package org.application.dto;

import org.application.model.BodyType;
import org.application.model.Vehicle;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class VehicleModelDTO {
    private Long id;
    private BodyType bodyType;
    private String name;
    private double tankCapacity;
    private int seatingCapacity;

    public VehicleModelDTO(Long id, BodyType bodyType,  String name, double tankCapacity, int seatingCapacity) {
        this.id = id;
        this.bodyType = bodyType;
        this.name = name;
        this.tankCapacity = tankCapacity;
        this.seatingCapacity = seatingCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
