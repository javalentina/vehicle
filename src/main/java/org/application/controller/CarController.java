package org.application.controller;

import org.application.model.Vehicle;
import org.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public String readAllVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicle";
    }
    @GetMapping("/vehicles/cars")
    public String readAllCar(Model model) {
        List<Cars> cars = vehicleService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }
}




