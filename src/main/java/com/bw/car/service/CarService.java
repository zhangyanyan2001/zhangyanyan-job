package com.bw.car.service;

import java.util.List;

import com.bw.car.domain.Car;

public interface CarService {

	int insert(Car record);

	List<Car> selects();

}
