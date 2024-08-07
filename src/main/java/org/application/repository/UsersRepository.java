package org.application.repository;


import org.apache.catalina.User;
import org.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users,Long>{
    Users findByName(String name);
}
