package org.application.dto;


public class DriverDTO {
    private Long id;
    private String name;
    private double salary;


    private Long enterpriseId;
    //private List<DriverTask> driverTasks;


    public DriverDTO(Long id, String name, double salary, Long enterpriseId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.enterpriseId = enterpriseId; //this.driverTasks = driverTasks;
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

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }


}
