package org.application.service;

import org.application.model.Driver;
import org.application.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDriver(){
        return driverRepository.findAll();
    }
    public List<Driver> getAllDriversWithTask(){
        return driverRepository.findAllDriversWithTask();
    }

}
