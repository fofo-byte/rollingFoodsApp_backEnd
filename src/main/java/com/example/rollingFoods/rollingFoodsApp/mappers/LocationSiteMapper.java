package com.example.rollingFoods.rollingFoodsApp.mappers;


import com.example.rollingFoods.rollingFoodsApp.dto.LocationSiteDTO;
import com.example.rollingFoods.rollingFoodsApp.models.LocationSite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationSiteMapper {

    LocationSite locationSiteDTOToLocationSite(LocationSiteDTO locationSiteDTO);
    LocationSiteDTO locationSiteToLocationSiteDTO(LocationSite locationSite);
}
