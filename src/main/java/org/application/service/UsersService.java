package org.application.service;

import org.application.model.Users;
import org.application.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
}
