package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckMapper;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.models.Picture;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckRepo;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TruckServiceImp implements TruckService {

    @Value("D://Projet rollingFoodsApp//pictures")
    private String picturesLocation;

    @Value("http://localhost/images")
    private String staticResourcesUrl;

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
    public FoodTruckDTO createTruck(final FoodTruckDTO foodTruckDTO, final List<MultipartFile> files) {
        final FoodTruck truck = mapper.dtoToFoodTruck(foodTruckDTO);
        final FoodTruck saved = foodTruckRepo.save(truck);
        saved.setPictures(new ArrayList<Picture>());
        final Path locationPath = Paths.get(picturesLocation, String.valueOf(saved.getId()));

        try {
            final Path createDirectories = Files.createDirectory(locationPath);

            files.forEach(file -> {
                try {
                    final Path imagePath = createDirectories.resolve(Optional.ofNullable(file.getOriginalFilename()).orElseThrow());

                    file.transferTo(imagePath.toFile());
                    final Picture picture = new Picture();
                    picture.setLocation(staticResourcesUrl + "/pictures/" + saved.getId() + "/" + imagePath.getFileName().toString());
                    picture.setName(imagePath.getFileName().toString());
                    picture.setFoodTruck(saved);
                    saved.getPictures().add(picture);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            final FoodTruck savedWithPictures = foodTruckRepo.save(saved);
            return mapper.foodTruckToDto(savedWithPictures);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving pictures");
        }
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


