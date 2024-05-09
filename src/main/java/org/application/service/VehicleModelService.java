package org.application.service;

import org.application.model.VehicleModel;
import org.application.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelService {
    private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }
}
