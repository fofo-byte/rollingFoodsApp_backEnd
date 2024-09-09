package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface TruckService {

    //Get all trucks
    public List<FoodTruckDTO> getTrucks();
    //Create truck
    public FoodTruckDTO createTruck(FoodTruckDTO foodTruckDTO,Long id);
    //Delete truck
    public void deleteTruck(int id);

    //Find truck by id
    FoodTruckDTO findTruckById(Long id);
    //Update truck
    public FoodTruckDTO updateTruck(Long id, FoodTruckDTO foodTruckDTO);
    //Get all trucks with pagination
    public Page<FoodTruckDTO> getTrucksPageable(Pageable pageable);
    //Get truck by owner id
    public FoodTruckDTO getTruckByOwnerId(Long ownerId);



}
