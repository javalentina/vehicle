package org.application.controller;

import org.application.dto.EnterpriseDTO;
import org.application.dto.UsersDTO;
import org.application.model.Enterprise;
import org.application.model.Users;
import org.application.service.EnterpriseService;
import org.application.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UsersService usersService;
    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public String readUsers(Model model){
        List<Users> users = usersService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/api")
    public ResponseEntity<List<UsersDTO>> getAllUsersJson() {
        List<Users> users = usersService.getAllUsers();
        List<UsersDTO> usersDTOS = users.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(usersDTOS,HttpStatus.OK);
    }



    private UsersDTO convertToDTO(Users users) {
        return new UsersDTO(users.getId(), users.getName(), users.getRole());
    }


}
