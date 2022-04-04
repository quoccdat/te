package controller;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.jdbc.constant.SystemConstant;

import model.BuildingModel;
import service.BuildingService;
import service.impl.BuildingServiceImpl;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingModel> findAll(String name, String street, Integer numberOfBasement, Integer floorArea, String type) {
		//filter --> model
		List<BuildingModel> buildingModels = buildingService.findAll(name, street, numberOfBasement, floorArea, type);
		return buildingModels;
	}
}
