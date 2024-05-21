package org.application.repository;

import org.application.model.Driver;
import org.application.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
