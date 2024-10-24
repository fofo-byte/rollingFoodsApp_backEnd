package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.LocationSiteDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.AddressMapper;
import com.example.rollingFoods.rollingFoodsApp.mappers.LocationSiteMapper;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.models.LocationOwner;
import com.example.rollingFoods.rollingFoodsApp.models.LocationSite;
import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import com.example.rollingFoods.rollingFoodsApp.repositories.LocationOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.LocationSiteRepo;
import com.example.rollingFoods.rollingFoodsApp.services.LocationSiteService;
import io.jsonwebtoken.io.IOException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationSiteServiceImp implements LocationSiteService {

    @Value("D://Projet rollingFoodsApp/pictures/locationSite")
    private String locationSitePicturesLocation;

    @Value("http://10.0.2.2:8686/api/images/locationSite/")
    private String locationSiteStaticResourcesUrl;

    @Autowired
    private LocationSiteMapper locationSiteMapper;

    @Autowired
    private LocationSiteRepo locationSiteRepo;

    @Autowired
    private LocationOwnerRepo locationOwnerRepo;

    @Autowired
    private AddressMapper addressMapper;

    private final List<LocationSite> locationSites = new ArrayList<>();

    // Create a location site
    @Override
    public LocationSiteDTO createLocationSite(LocationSiteDTO locationSiteDTO, Long locationOwnerId, final MultipartFile file) {
        final LocationOwner locationOwner = locationOwnerRepo.findById(locationOwnerId).orElseThrow(() -> new EntityNotFoundException("Location owner not found with id: " + locationOwnerId));
        Address address = addressMapper.dtoToAddress(locationSiteDTO.getAddress());
        LocationSite locationSite = new LocationSite();
        locationSite.setName(locationSiteDTO.getName());
        locationSite.setAddress(address);
        locationSite.setProprio(locationOwner);

        final LocationSite newLocationSite = locationSiteRepo.save(locationSite);

        if(file != null) {
            try {
                String profileImage = uploadProfileImage(file, newLocationSite.getId());
                newLocationSite.setProfileImage(profileImage);
                locationSiteRepo.save(newLocationSite);
            } catch (IOException | java.io.IOException e) {
                e.printStackTrace();
            }
        }

        return locationSiteMapper.locationSiteToLocationSiteDTO(newLocationSite);

    }


    //Upload truck profile image
    @Override
    public String uploadProfileImage(MultipartFile file, Long locationSiteId) throws IOException, java.io.IOException {

        LocationSite locationSite = locationSiteRepo.findById(locationSiteId).orElseThrow(() -> new EntityNotFoundException("Location site not found with id: " + locationSiteId));

        final Path locationPath = Paths.get(locationSitePicturesLocation, String.valueOf(locationSite.getId()));

        if(!Files.exists(locationPath)) {
            Files.createDirectory(locationPath);
        }

        try {
            final Path location = locationPath.resolve(StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
            locationSite.setProfileImage(locationSiteStaticResourcesUrl + locationSite.getId() + "/" + StringUtils.cleanPath(file.getOriginalFilename()));
            locationSiteRepo.save(locationSite);
            return locationSite.getProfileImage();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Image upload failed");

        }

    }
}
