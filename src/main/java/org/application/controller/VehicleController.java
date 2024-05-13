package org.application.controller;

import org.application.model.Vehicle;
import org.application.model.VehicleModel;
import org.application.service.VehicleModelService;
import org.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VehicleController {
    public VehicleService getVehicleService() {
        return vehicleService;
    }

    private final VehicleService vehicleService;
    private final VehicleModelService vehicleModelService; // Inject VehicleModelService



    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleModelService vehicleModelService) {
        this.vehicleService = vehicleService;
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping("/vehicles")
    public String readAllVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicle";
    }

    @GetMapping("/vehicle/new")
    public String newVehicle(Model model) {
        Vehicle vehicle = new Vehicle();
        List<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels(); // Assuming you have a method to get all vehicle models
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicleModels", vehicleModels);
        return "vehicle-new";

    }

    @PostMapping("/vehicle/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicle/edit")
    public ModelAndView editVehicle(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("vehicle-edit");
        Vehicle vehicle = vehicleService.getVehicle(id);
        VehicleModel vehicleModelId = vehicle.getVehicleModelId();
        List<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels(); // Assuming you have a method to get all vehicle models
        mav.addObject("vehicle", vehicle);
        mav.addObject("vehicleModelId",vehicleModelId);
        mav.addObject("vehicleModels",vehicleModels);
        return mav;
    }

    @GetMapping("/vehicle/delete")
    public String deleteVehicle(@RequestParam Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }

}




