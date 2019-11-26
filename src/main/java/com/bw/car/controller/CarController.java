package com.bw.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.car.domain.Car;
import com.bw.car.service.CarService;

@Controller
public class CarController {

	@Resource
	private CarService carservice;
	
	@GetMapping("add")
	public String add() {
		return "car_add";
	}
	
	@ResponseBody
	@PostMapping("add")
	public boolean add(HttpServletRequest request,Car car,MultipartFile file) {
		
		if(!file.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath("/resources/pic/");
			
			String oldFilename = file.getOriginalFilename();
			
			String newFilename = UUID.randomUUID()+oldFilename.substring(oldFilename.indexOf("."));
			
			File f = new File(path,newFilename);
			
			try {
				file.transferTo(f);
				
				car.setPicUrl(newFilename);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		car.setCreated(new Date());//发布时间
		return carservice.insert(car)>0;
	}
	
	@GetMapping(value = {"","/","index"})
	public String cars(Model m) {
		List<Car> cars = carservice.selects();
		
		m.addAttribute("cars", cars);
		return "index";
	}
}
