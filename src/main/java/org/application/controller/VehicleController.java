package org.application.controller;

import org.application.dto.VehicleDTO;
import org.application.dto.VehicleModelDTO;
import org.application.model.Vehicle;
import org.application.model.VehicleModel;
import org.application.service.VehicleModelService;
import org.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    public VehicleService getVehicleService() {
        return vehicleService;
    }

    private final VehicleService vehicleService;
    private final VehicleModelService vehicleModelService;



    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleModelService vehicleModelService) {
        this.vehicleService = vehicleService;
        this.vehicleModelService = vehicleModelService;
    }
    @GetMapping("")
    public String readAllVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    @GetMapping("/add")
    public String newVehicle(Model model) {
        Vehicle vehicle = new Vehicle();
        List<VehicleModel> vehicleModels = vehicleModelService.getAllVehicleModels(); // Assuming you have a method to get all vehicle models
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicleModels", vehicleModels);
        return "vehicle-add";

    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit")
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

    @GetMapping("/delete")
    public String deleteVehicle(@RequestParam Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
    @GetMapping("/api")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesJson(){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOs = vehicles.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(vehicleDTOs,HttpStatus.OK);
    }
    public VehicleDTO convertToDTO(Vehicle vehicle){

            return new VehicleDTO(vehicle.getId(), vehicle.getCost(), vehicle.getYear(), vehicle.getMileage(), vehicle.getVehicleModelId().getId());

    }


}




