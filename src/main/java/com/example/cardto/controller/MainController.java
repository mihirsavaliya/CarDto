package com.example.cardto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cardto.dto.ResponseDto;
import com.example.cardto.model.Car;
import com.example.cardto.service.CarService;

@Controller
public class MainController 
{
	@Autowired
	CarService carservice;
	
	@GetMapping("/allCar")
	@ResponseBody
	public ResponseDto allcar()
	{
		return carservice.getAllCar();
	}
	
	@PostMapping("/addCar")
	@ResponseBody
	public ResponseDto addcar(@RequestBody Car car)
	{
		return carservice.addCar(car);
	}
	
	@DeleteMapping("/deleteCar")
	@ResponseBody
	public ResponseDto deletecar(@RequestParam("id") int id)
	{
		return carservice.deleteCar(id);
	}
	
	@PutMapping("/editCar")
	@ResponseBody
	public ResponseDto editcar(@RequestBody Car car)
	{
		return carservice.editCar(car);
	}
}
