package org.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<DriverTask> driverTasks;

    public DriverTask getActiveTask() {
        return driverTasks.stream()
                .filter(DriverTask::getIsActive)
                .findFirst()
                .orElse(null);
    }



    public Driver(Long id, String name, double salary, Enterprise enterprise) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.enterprise = enterprise;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    public List<DriverTask> getDriverTasks() {
        return driverTasks;
    }

    public void setDriverTasks(List<DriverTask> driverTasks) {
        this.driverTasks = driverTasks;
    }
}
