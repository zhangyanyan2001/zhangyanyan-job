package com.bw.car.dao;

import java.util.List;

import com.bw.car.domain.Car;

public interface CarMapper {

	int insert(Car record);

	List<Car> selects();

	

}
