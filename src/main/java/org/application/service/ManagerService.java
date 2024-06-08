package org.application.service;

import org.application.model.Enterprise;
import org.application.model.Manager;
import org.application.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    public List<Manager> getAllManager(){
        List<Manager>  managerList = managerRepository.findAll();
        return managerList;
    }

    public Optional<Manager> getManagerById(Long managerId){
        return managerRepository.findById(managerId);
    }
    public Set<Enterprise> getEnterpriseByManagerId(Long managerId){
        Optional<Manager> managerOptional = managerRepository.findById(managerId);
        return managerOptional.map(Manager::getEnterprises).orElse(null);
    }

}
