package com.bw.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.car.dao.CarMapper;
import com.bw.car.domain.Car;
import com.bw.car.service.CarService;
@Service
public class CarServiceImpl implements CarService{

	@Resource
	private CarMapper mapper;

	@Override
	public int insert(Car record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public List<Car> selects() {
		// TODO Auto-generated method stub
		return mapper.selects();
	}
}
