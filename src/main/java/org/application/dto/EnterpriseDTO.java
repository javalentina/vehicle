package org.application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class EnterpriseDTO {


    private Long id;
    private String name;
    private String city;

    public EnterpriseDTO(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public EnterpriseDTO() {

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
