package org.application.controller;

import org.application.model.VehicleModel;
import org.application.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/vehicle-models")
    public String readAllCar(Model model) {
        List<VehicleModel> vehicleModels = carService.getAllCars();
        model.addAttribute("vehicleModels", vehicleModels);
        return "car";
    }
}




