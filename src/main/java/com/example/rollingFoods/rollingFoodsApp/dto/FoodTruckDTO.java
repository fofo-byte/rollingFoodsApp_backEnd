package com.example.rollingFoods.rollingFoodsApp.dto;

import java.util.Set;

public class FoodTruckDTO {

    private Long id;
    private String name;
    private String description;
    private Set<MenuDTO> menus;
    private Set<PictureDTO> pictures;




    public FoodTruckDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuDTO> menus) {
        this.menus = menus;
    }

    public Set<PictureDTO> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureDTO> pictures) {
        this.pictures = pictures;
    }

}