package org.application.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @ManyToMany
    @JoinTable(
            name= "manager_enterprise",
            joinColumns = @JoinColumn(name = "enterprise_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    Set<Manager> managers;

    public Enterprise(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Enterprise() {

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Set<Manager> getManagerId() {
        return managers;
    }
}
