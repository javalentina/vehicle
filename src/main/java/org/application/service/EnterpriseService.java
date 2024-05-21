package org.application.service;


import org.application.model.Enterprise;
import org.application.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseService(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<Enterprise> getAllEnterprise() {
        return enterpriseRepository.findAll();
    }

}
