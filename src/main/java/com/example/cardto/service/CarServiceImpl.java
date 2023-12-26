package com.example.cardto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardto.dto.ResponseDto;
import com.example.cardto.model.Car;
import com.example.cardto.repository.CarRepo;

@Service
public class CarServiceImpl implements CarService
{
	@Autowired
	CarRepo carrepo;
	
	ResponseDto response = new ResponseDto();
	
	private void setResponseData(int status, String message, Object data)
	{
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);
	}

	@Override
	public ResponseDto getAllCar() {
		// TODO Auto-generated method stub
		setResponseData(200,"All Cars",carrepo.findAll());
		return response;
	}

	@Override
	public ResponseDto addCar(Car car) {
		// TODO Auto-generated method stub
		setResponseData(200,"Data Added successfully",carrepo.save(car));
		return response;
	}

	@Override
	public ResponseDto deleteCar(int id) {
		// TODO Auto-generated method stub
		Car delcar = carrepo.findById(id).orElse(null);
		if(delcar != null)
		{
			setResponseData(200,"Car Deleted",carrepo.findById(id));
			carrepo.deleteById(id);
		}else {
			setResponseData(400,"Car Not Deleted","Error");
		}
		return response;
	}

	@Override
	public ResponseDto editCar(Car car) {
		// TODO Auto-generated method stub
		Car newcar = carrepo.findById(car.getId()).orElse(null);
		if(newcar != null)
		{
			newcar.setId(car.getId());
			newcar.setName(car.getName());
			newcar.setColor(car.getColor());
			newcar.setPrice(car.getPrice());
			carrepo.save(newcar);
			setResponseData(200,"Car Updated Successfully",newcar);
		}else {
			setResponseData(400,"Car not updated","car is not available for update");
		}
		return response;
	}
}
