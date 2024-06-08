package org.application.dto;

import org.application.model.Manager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class EnterpriseDTO {
    private Long id;
    private String name;
    private String city;
    private Set<Long> managerId;

    public EnterpriseDTO(Long id, String name, String city, Set<Manager> managers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.managerId= managers.stream().map(Manager::getId).collect(Collectors.toSet());
    }

    public EnterpriseDTO() {

    }

    public Set<Long> getManagerId() {
        return managerId;
    }

    public void setManagerId(Set<Long> managerId) {
        this.managerId = managerId;
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
}
