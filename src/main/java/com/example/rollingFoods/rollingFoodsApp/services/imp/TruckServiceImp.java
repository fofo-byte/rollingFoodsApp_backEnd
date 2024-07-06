package com.example.rollingFoods.rollingFoodsApp.services.imp;


import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckRepo;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckServiceImp implements TruckService {

    @Autowired
    private FoodTruckRepo foodTruckRepo;

    public static List<FoodTruck> trucks = new ArrayList<>();

    public List<FoodTruck> getTrucks() {
        return foodTruckRepo.findAll();
    }

    public FoodTruck getTruckById(int id) {
        for (FoodTruck truck : trucks) {
            if (truck.getId() == id) {
                return truck;
            }else{
                return null;
            }
        }
        return null;
    }

    public FoodTruck saveTruck(FoodTruck truck) {
        return truck;
    }

    public void deleteTruck(int id) {
        trucks.removeIf(truck -> truck.getId() == id);
    }

    public FoodTruck updateTruck(int id, FoodTruck truck) {
        for (FoodTruck truck1 : trucks) {
            if (truck1.getId() == id) {
                truck1.setName(truck.getName());
                truck1.setDescription(truck.getDescription());
                truck1.setLocation(truck.getLocation());
                truck1.setFoodType(truck.getFoodType());
                return truck1;
            }
        }
        return null;
    }

    public FoodTruck createTruck(FoodTruck truck) {
        return foodTruckRepo.save(truck);
    }

}
