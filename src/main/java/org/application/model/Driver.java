package org.application.model;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise_id;

    public Driver(Long id, String name, double salary, Enterprise enterprise_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.enterprise_id = enterprise_id;
    }

    public Driver() {

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

    public Enterprise getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(Enterprise enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
