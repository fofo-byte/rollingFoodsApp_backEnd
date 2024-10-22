package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract, Long> {
}
