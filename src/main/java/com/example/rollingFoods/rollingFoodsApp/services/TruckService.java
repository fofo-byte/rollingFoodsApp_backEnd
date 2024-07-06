package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;

import java.util.List;

public interface TruckService {

    public List<FoodTruck> getTrucks();
    public FoodTruck getTruckById(int id);
    public FoodTruck saveTruck(FoodTruck truck);
    public void deleteTruck(int id);
    public FoodTruck updateTruck(int id, FoodTruck truck);
    public FoodTruck createTruck(FoodTruck truck);
}
