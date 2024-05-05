package org.service;

import org.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    void create(Vehicle vehicle);
    List<Vehicle> readAll();
    Vehicle read(int id);
    boolean update(Vehicle vehicle, int id);
    boolean delete(int id);
}
