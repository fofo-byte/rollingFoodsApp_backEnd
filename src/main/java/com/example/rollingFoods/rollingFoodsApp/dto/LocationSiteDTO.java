package com.example.rollingFoods.rollingFoodsApp.dto;

public class LocationSiteDTO {

    private Long id;
    private String name;
    private String description;
    private Float length;
    private Float width;
    private AddressDTO address;
    private String profileImage;


    public LocationSiteDTO() {
    }

    public LocationSiteDTO(Long id, String name, String description, Float length, Float width, AddressDTO address, String profileImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.width = width;
        this.address = address;
        this.profileImage = profileImage;
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

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
