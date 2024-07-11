package org.application.controller;

import org.application.dto.EnterpriseDTO;
import org.application.dto.UsersDTO;
import org.application.model.Enterprise;
import org.application.model.Manager;
import org.application.model.Role;
import org.application.model.Users;
import org.application.service.EnterpriseService;
import org.application.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public String readUsers(Model model) {
        List<Users> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/api")
    public ResponseEntity<List<UsersDTO>> getAllUsersJson() {
        List<Users> users = usersService.getAllUsers();
        List<UsersDTO> usersDTOS = users.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(usersDTOS, HttpStatus.OK);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new Users());
        return "user-register";

    }

    @PostMapping("/register")
    public String userRegister(@RequestParam String name, @RequestParam String password, Model model) {
        usersService.registerUser(name, password);
        model.addAttribute("message", "User successfully registered!");
        return "register-success";

    }

    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UsersDTO userDTO) {
        try {
            usersService.registerUser(userDTO.getName(), userDTO.getPassword());
            return new ResponseEntity<>("User successfully registered!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLogin", new Users());
        return "users-login";

    }

    @PostMapping("/login")
    public String userLogin(@RequestParam String name, @RequestParam String password, Model model) {
        if (usersService.loginUser(name, password)) {
            model.addAttribute("message", "Login Success");

            return "redirect:/users/dashboard/?name=" + name;
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "users-login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam String name, Model model) {
        Users user = usersService.findByName(name);
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("role", user.getRole());
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                Set<Enterprise> enterprises = usersService.getEnterpriseByManager(manager);
                model.addAttribute("enterprises", enterprises);
            }
        }
        return "users-dashboard"; // Шаблон для страницы с данными
    }


    private UsersDTO convertToDTO(Users users) {
        return new UsersDTO(users.getId(), users.getName(), users.getRole());
    }


}
