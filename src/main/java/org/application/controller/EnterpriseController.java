package org.application.controller;

import org.application.model.Enterprise;
import org.application.model.VehicleModel;
import org.application.service.EnterpriseService;
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
public class EnterpriseController {


    private final EnterpriseService enterpriseService;
    public EnterpriseService getEnterpriseService() {
        return enterpriseService;
    }
    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }
    @GetMapping("/enterprise")
    public String readAllEnterprise(Model model) {
        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "enterprise";
    }
}




