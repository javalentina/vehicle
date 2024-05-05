package org.controller;

import org.model.Vehicle;
import org.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;


    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/vehicles")
    public ResponseEntity<?> create(@RequestBody Vehicle vehicle) {
        vehicleService.create(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/vehicles/{id}")
    public ResponseEntity<Vehicle> read(@PathVariable(name = "id") int id) {
        final Vehicle vehicle = vehicleService.read(id);

        return vehicle != null
                ? new ResponseEntity<>(vehicle, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> readAll(){
        List<Vehicle> vehicleList = vehicleService.readAll();
        return vehicleList != null &&  !vehicleList.isEmpty()
                ? new ResponseEntity<>(vehicleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/vehicles/{id}")
    public ResponseEntity<Void> update(@PathVariable(name = "id") int id, @RequestBody Vehicle vehicle) {
        final boolean updated = vehicleService.update(vehicle, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/vehicles/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = vehicleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
