package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckMapper;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.models.Picture;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.UserCredentialRepo;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
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
    public List<FoodTruckDTO> getTrucks() {
        final List<FoodTruck> trucks = foodTruckRepo.findAll();
        return trucks.stream().map(mapper::foodTruckToDto).collect(Collectors.toList());
    }
    // Create food truck
    public FoodTruckDTO createTruck(final FoodTruckDTO foodTruckDTO, final List<MultipartFile> files, final Long foodTruckOwnerId) {
        final FoodTruckOwner foodTruckOwner = foodTruckOwnerRepo.findById(foodTruckOwnerId).orElseThrow(() -> new EntityNotFoundException("Food truck owner not found with id: " + foodTruckOwnerId));
        FoodTruck foodTruck = new FoodTruck();
        foodTruck.setName(foodTruckDTO.getName());
        foodTruck.setDescription(foodTruckDTO.getDescription());
        foodTruck.setSpeciality(foodTruckDTO.getSpeciality());
        foodTruck.setFoodType(foodTruckDTO.getFoodType());
        foodTruck.setCoordinates(foodTruckDTO.getCoordinates());
        foodTruck.setFoodTruckOwner(foodTruckOwner);

        final FoodTruck savedFoodTruck = foodTruckRepo.save(foodTruck);

        final Path locationPath = Paths.get(picturesLocation + "/pictures/" + savedFoodTruck.getId());
        try {

            Logger.getGlobal().info("Saving pictures to: " + locationPath);
            // Create directory if not exists
            Files.createDirectories(locationPath);

            for (MultipartFile file : files) {
                if (file.isEmpty() || file.getOriginalFilename() == null) {
                    throw new RuntimeException("Invalid file detected.");
                }
                Path imagePath = locationPath.resolve(Objects.requireNonNull(file.getOriginalFilename()));
                file.transferTo(imagePath.toFile());

                Picture picture = new Picture();
                picture.setLocation("/pictures/" + savedFoodTruck.getId() + "/" + imagePath.getFileName());
                picture.setName(imagePath.getFileName().toString());
                picture.setFoodTruck(savedFoodTruck);

                savedFoodTruck.getPictures().add(picture);
            }


            foodTruckRepo.save(savedFoodTruck);

        } catch (Exception e) {
            Logger.getGlobal().severe("Error while saving pictures: " + e.getMessage());
            throw new RuntimeException("Error while saving pictures");
        }

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



}


