package org.application.controller;

import org.application.dto.EnterpriseDTO;
import org.application.dto.VehicleDTO;
import org.application.dto.VehicleModelDTO;
import org.application.model.Enterprise;
import org.application.model.Vehicle;
import org.application.model.VehicleModel;
import org.application.service.EnterpriseService;
import org.application.service.VehicleModelService;
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
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;
    public EnterpriseService getEnterpriseService() {
        return enterpriseService;
    }
    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }
    @GetMapping("")
    public String readAllEnterprise(Model model) {
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "enterprise";
    }
    @GetMapping("/api")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterpriseJson(){
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        List<EnterpriseDTO> enterpriseDTOS = enterprises.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(enterpriseDTOS, HttpStatus.OK);
    }
    public EnterpriseDTO convertToDTO(Enterprise enterprise){
         return new EnterpriseDTO(enterprise.getId(), enterprise.getName(), enterprise.getCity());

    }
}




