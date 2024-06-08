package org.application.dto;

import org.application.model.Enterprise;
import org.application.model.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDTO {
    private Long id;
    private String name;
    private Role role;
    private Set<Long> enterpriseListId;

    public ManagerDTO(Long id, Set<Enterprise> enterpriseListId) {
        this.id = id;

        this.enterpriseListId = enterpriseListId.stream().map(Enterprise::getId).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getEnterpriseList() {
        return enterpriseListId;
    }

    public Set<Long> getEnterpriseListId() {
        return enterpriseListId;
    }

    public void setEnterpriseListId(Set<Long> enterpriseListId) {
        this.enterpriseListId = enterpriseListId;
    }

    public void setEnterpriseList(Set<Long> enterpriseListId) {
        this.enterpriseListId = enterpriseListId;
    }
}
