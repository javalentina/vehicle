package org.application.controller;

import org.application.model.VehicleModel;
import org.application.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VehicleModelController {
    private final VehicleModelService vehicleModelService;

    @Autowired
    public VehicleModelController(VehicleModelService vehicleModelService) {

        this.vehicleModelService = vehicleModelService;
    }


    @GetMapping("/vehicle-models")
    public String readAllCar(Model model) {
        List<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels();
        model.addAttribute("vehicleModels", vehicleModels);
        return "vehicle-models";
    }
}




