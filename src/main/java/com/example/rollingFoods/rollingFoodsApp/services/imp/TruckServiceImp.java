package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckMapper;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.UserCredentialRepo;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckServiceImp implements TruckService {

    @Value("D://Projet rollingFoodsApp//pictures")
    private String picturesLocation;

    @Value("http://10.0.2.2:8686/api")
    private String staticResourcesUrl;

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private FoodTruckOwnerRepo foodTruckOwnerRepo;

    @Autowired
    private FoodTruckRepo foodTruckRepo;

    @Autowired
    private FoodTruckMapper mapper;

    public static List<FoodTruck> trucks = new ArrayList<>();


    // Get all food trucks
    @Override
    public List<FoodTruckDTO> getTrucks() {
        final List<FoodTruck> trucks = foodTruckRepo.findAll();
        return trucks.stream().map(mapper::foodTruckToDto).collect(Collectors.toList());
    }
    // Create food truck
    @Override
    public FoodTruckDTO createTruck(final FoodTruckDTO foodTruckDTO,final Long foodTruckOwnerId) {
        final FoodTruckOwner foodTruckOwner = foodTruckOwnerRepo.findById(foodTruckOwnerId).orElseThrow(() -> new EntityNotFoundException("Food truck owner not found with id: " + foodTruckOwnerId));
        FoodTruck foodTruck = new FoodTruck();
        foodTruck.setName(foodTruckDTO.getName());
        foodTruck.setDescription(foodTruckDTO.getDescription());
        foodTruck.setSpeciality(foodTruckDTO.getSpeciality());
        foodTruck.setFoodType(foodTruckDTO.getFoodType());
        foodTruck.setCoordinates(foodTruckDTO.getCoordinates());
        foodTruck.setProfileImage(foodTruckDTO.getProfileImage());
        foodTruck.setFoodTruckOwner(foodTruckOwner);

        final FoodTruck savedFoodTruck = foodTruckRepo.save(foodTruck);

        return mapper.foodTruckToDto(savedFoodTruck);
    }


    //Find truck by id
    @Override
    public FoodTruckDTO findTruckById(Long id) {
        final FoodTruck truck = getTruckById((long) id);
        final FoodTruckDTO truckDTO = mapper.foodTruckToDto(truck);
        return truckDTO;
    }

    // Get food truck by id

    private FoodTruck getTruckById(Long id) {
        return foodTruckRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Truck not found with id: " + id));
    }



    //update truck
    @Override
    public FoodTruckDTO updateTruck(Long id, FoodTruckDTO foodTruckDTO) {
        final FoodTruck truck = getTruckById(id);

        if (foodTruckDTO.getName() != null) {
            truck.setName(foodTruckDTO.getName());
        }
        if (foodTruckDTO.getDescription() != null) {
            truck.setDescription(foodTruckDTO.getDescription());
        }
        if (foodTruckDTO.getSpeciality() != null) {
            truck.setSpeciality(foodTruckDTO.getSpeciality());
        }
        if (foodTruckDTO.getFoodType() != null) {
            truck.setFoodType(foodTruckDTO.getFoodType());
        }
        if (foodTruckDTO.getProfileImage() != null) {
            truck.setProfileImage(foodTruckDTO.getProfileImage());
        }

        final FoodTruck updatedTruck = foodTruckRepo.save(truck);
        return mapper.foodTruckToDto(updatedTruck);
    }

    @Override
    public Page<FoodTruckDTO> getTrucksPageable(Pageable pageable) {
        final Page<FoodTruck> trucks = foodTruckRepo.findAll(pageable);
        return trucks.map(mapper::foodTruckToDto);
    }

    //delete truck
   @Override
    public void deleteTruck(int id) {
        foodTruckRepo.deleteById((long) id);
    }

    //get truck by owner id
    @Override
    public Long getTruckByOwnerId(Long ownerId) {
        return foodTruckRepo.findByFoodTruckOwnerId(ownerId);
    }

    //rate truck
    @Override
    public FoodTruckDTO rateTruck(Long truckId, int rating) {
        final FoodTruck truck = getTruckById(truckId);

        // get the current rating and rating count
        final int currentRating = truck.getRating();
        final int currentRatingCount = truck.getRatingCount();

        // calculate the new rating and rating count
        final int newRatingCount = currentRatingCount + 1;
        // calculate the new rating
        final double newRating = (currentRating * currentRatingCount + rating) / (double) newRatingCount;
        truck.setRatingCount(newRatingCount);
        truck.setRating((int)Math.round(newRating));
        final FoodTruck updatedTruck = foodTruckRepo.save(truck);
        return mapper.foodTruckToDto(updatedTruck);
    }

    //Open truck
    @Override
    public FoodTruckDTO openTruck(Long truckId, FoodTruckDTO foodTruckDTO) {
        final FoodTruck truck = getTruckById(truckId);

        if (foodTruckDTO.getCoordinates() != null) {
            truck.setCoordinates(foodTruckDTO.getCoordinates());
            truck.setOpen(true);
        }
        final FoodTruck updatedTruck = foodTruckRepo.save(truck);
        return mapper.foodTruckToDto(updatedTruck);

    }

    //Close truck
    @Override
    public FoodTruckDTO closeTruck(Long truckId) {
        final FoodTruck truck = getTruckById(truckId);
        truck.setOpen(false);
        final FoodTruck updatedTruck = foodTruckRepo.save(truck);
        return mapper.foodTruckToDto(updatedTruck);
    }

    //find truck is open or not
    @Override
    public boolean findStatusById(Long id) {
        boolean status = foodTruckRepo.findStatusById(id);
        return status;

    }




}


