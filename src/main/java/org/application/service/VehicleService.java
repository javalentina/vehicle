package org.application.service;

import org.application.model.Vehicle;
import org.application.model.VehicleModel;
import org.application.repository.VehicleModelRepository;
import org.application.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    //private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {

        this.vehicleRepository = vehicleRepository;
       // this.vehicleModelRepository = vehicleModelRepository;
    }
    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }


    public Vehicle getVehicle(Long id){
        return vehicleRepository.findById(id).get();
    }
    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

}
