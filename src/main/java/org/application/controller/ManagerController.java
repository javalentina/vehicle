package org.application.controller;

import org.application.dto.ManagerDTO;
import org.application.model.Manager;
import org.application.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    @GetMapping("/api")
    public ResponseEntity<List<ManagerDTO>>  getAllManager(){
        List<Manager> managerList = managerService.getAllManager();
        List<ManagerDTO> managerDTOList = managerList.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(managerDTOList, HttpStatus.OK);
    }


    private ManagerDTO convertToDTO(Manager manager) {

        return new ManagerDTO(manager.getId(), manager.getEnterprises());

    }
}
