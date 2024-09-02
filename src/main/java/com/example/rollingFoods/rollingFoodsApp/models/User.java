package com.example.rollingFoods.rollingFoodsApp.models;


import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(name="phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;
    @Column(name = "create_at")
    private String createdDate;
}
