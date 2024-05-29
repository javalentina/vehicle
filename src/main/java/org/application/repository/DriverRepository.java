package org.application.repository;

import org.application.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query("SELECT d FROM Driver d " +
            "LEFT JOIN FETCH d.driverTasks dt " +
            "LEFT JOIN FETCH dt.vehicle v " +
            "LEFT JOIN FETCH v.vehicleModelId " +
            "LEFT JOIN FETCH d.enterprise")
    List<Driver> findAllDriversWithTask();



}
