package org.service;

import org.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class VehicleServiceImpl implements VehicleService{

    private static final Map<Integer, Vehicle> VEHICLE_MAP = new HashMap<>();


    private static final AtomicInteger VEHICLE_ID_HOLDER = new AtomicInteger();

   @Override
   public void create(Vehicle vehicle){

   }

    @Override
    public List<Vehicle> readAll() {
        return new ArrayList<>(VEHICLE_MAP.values());
    }

    @Override
    public Vehicle read(int id) {
        return VEHICLE_MAP.get(id);
    }

    @Override
    public boolean update(Vehicle client, int id) {
        if (VEHICLE_MAP.containsKey(id)) {
            VEHICLE_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return VEHICLE_MAP.remove(id) != null;
    }
}
