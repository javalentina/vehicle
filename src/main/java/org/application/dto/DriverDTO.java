package org.application.dto;

import org.application.dto.EnterpriseDTO;
import org.application.model.DriverTask;

import javax.persistence.*;
import java.util.List;


public class DriverDTO {
    private Long id;
    private String name;
    private double salary;


    private EnterpriseDTO enterprise;
    //private List<DriverTask> driverTasks;


    public DriverDTO(Long id, String name, double salary, EnterpriseDTO enterprise) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.enterprise = enterprise; //this.driverTasks = driverTasks;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EnterpriseDTO getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseDTO enterprise) {
        this.enterprise = enterprise;
    }


}
