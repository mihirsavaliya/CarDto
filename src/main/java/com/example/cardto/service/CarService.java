package com.example.cardto.service;

import com.example.cardto.dto.ResponseDto;
import com.example.cardto.model.Car;

public interface CarService 
{
	ResponseDto getAllCar();
	
	ResponseDto addCar(Car car);
	
	ResponseDto deleteCar(int id);
	
	ResponseDto editCar(Car car);
}
