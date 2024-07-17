package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface TruckService {

    public List<FoodTruckDTO> getTrucks();
    public FoodTruckDTO createTruck(FoodTruckDTO foodTruckDTO);
    //public FoodTruck getTruckById(int id);
   // public FoodTruck saveTruck(FoodTruck truck);
   // public void deleteTruck(int id);
   // public FoodTruck updateTruck(int id, FoodTruck truck);
   // public FoodTruck createTruck(FoodTruck truck);
}
