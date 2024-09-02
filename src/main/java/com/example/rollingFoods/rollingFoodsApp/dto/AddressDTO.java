package com.example.rollingFoods.rollingFoodsApp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String province;
    private String country;
}
