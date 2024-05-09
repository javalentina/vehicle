package org.application.service;

import org.application.model.VehicleModel;
import org.application.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<VehicleModel> getAllCars() {
        return (List<VehicleModel>) carRepository.findAll();
    }
}
