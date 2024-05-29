package org.application.controller;

import org.application.dto.EnterpriseDTO;
import org.application.dto.VehicleDTO;
import org.application.dto.VehicleModelDTO;
import org.application.dto.*;
import org.application.dto.DriverDTO;
import org.application.model.Driver;
import org.application.model.DriverTask;
import org.application.service.DriverService;
import org.application.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/driver")
public class DriverController {
    private DriverService driverService;
    
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    @GetMapping("")
    public String readAllDriver(Model model){
        List<Driver> drivers = driverService.getAllDriversWithTask();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }
    @GetMapping("/api")
    public ResponseEntity<List<DriverDTO>> getAllDriverJson() {
            List<Driver> drivers = driverService.getAllDriversWithTask();
            List<DriverDTO> driverDTOs = drivers.stream().map(this::convertToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(driverDTOs, HttpStatus.OK);

    }


    private DriverDTO convertToDTO(Driver driver) {
        List<DriverTask> driverTasks = driver.getDriverTasks();
        EnterpriseDTO enterpriseDTO = new EnterpriseDTO(
                driver.getEnterprise().getId(),
                driver.getEnterprise().getName(),
                driver.getEnterprise().getCity()
        );

        return new DriverDTO(
                driver.getId(),
                driver.getName(),
                driver.getSalary(),
                enterpriseDTO
        );
    }

}




