package org.application.service;

import org.application.model.VehicleModel;
import org.application.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleModelService {
    private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }
    public void saveVehicleModel(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }
    public VehicleModel getVehicleModel(Long id){
        return vehicleModelRepository.findById(id).get();
    }
    public void deleteVehicleModel(Long id){
        vehicleModelRepository.deleteById(id);
    }
}
