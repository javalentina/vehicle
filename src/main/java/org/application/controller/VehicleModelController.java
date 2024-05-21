package org.application.controller;

import org.application.model.VehicleModel;
import org.application.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VehicleModelController {
    public VehicleModelService getVehicleModelService() {
        return vehicleModelService;
    }

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
    @GetMapping("/vehicle-models/new")
    public String newVehicleModel(Model model) {
        VehicleModel vehicleModel = new VehicleModel();
        model.addAttribute("vehicleModel", vehicleModel);
        return "vehicle-model-new";
    }

    @PostMapping("/vehicle-models/save")
    public String saveVehicleModel(@ModelAttribute VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehicle-models";
    }
    @GetMapping("/vehicle-models/edit")
    public ModelAndView editVehicleModel(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("vehicle-model-edit");
        VehicleModel vehicleModel = vehicleModelService.getVehicleModel(id);
        mav.addObject("vehicleModel", vehicleModel);
        return mav;
    }
    @GetMapping("/vehicle-models/delete")
    public String deleteVehicle(@RequestParam Long id) {
        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/vehicle-models";
    }

}




