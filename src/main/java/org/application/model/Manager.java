package org.application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Users {

    @ManyToMany
    @JoinTable(
            name = "manager_enterprise",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "enterprise_id")
    )
    private Set<Enterprise> enterprises;

    public Manager(String name, String password, Role role) {
        super();
    }

    public Manager() {
    }

    public Set<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(Set<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }
}
