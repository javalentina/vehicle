package org.application.service;

import org.apache.catalina.User;
import org.application.model.Enterprise;
import org.application.model.Manager;
import org.application.model.Role;
import org.application.model.Users;
import org.application.repository.UsersRepository;
import org.application.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void registerUser(String name,String password){
        String hashPassword = PasswordUtil.hashPassword(password);
        Users user = new Users(name,hashPassword);
        usersRepository.save(user);
    }

    public Users findByName(String name){
        return usersRepository.findByName(name);
    }
    public boolean loginUser(String name,String password){
        Users user = usersRepository.findByName(name);
        if(user != null && PasswordUtil.checkPassword(password, user.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }


    public Set<Enterprise> getEnterpriseByManager(Manager manager){
        if(manager.getRole() == Role.MANAGER){
            return manager.getEnterprises();
        }
        return Collections.emptySet();
    }
}
