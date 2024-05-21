package org.application.controller;

import org.application.model.Driver;
import org.application.model.VehicleModel;
import org.application.service.DriverService;
import org.application.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DriverController {
    private DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    @GetMapping("/driver")
    public String readAllDriver(Model model){
        List<Driver> drivers = driverService.getAllDriver();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

}




