package com.example.cardto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cardto.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer>{

}
