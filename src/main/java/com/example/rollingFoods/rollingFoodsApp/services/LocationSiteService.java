package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.LocationSiteDTO;
import io.jsonwebtoken.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface LocationSiteService {
    public LocationSiteDTO createLocationSite(LocationSiteDTO locationSiteDTO, Long locationOwnerId, MultipartFile file);

    //Upload truck profile image
    String uploadProfileImage(MultipartFile file, Long locationSiteId) throws IOException, java.io.IOException;
}
