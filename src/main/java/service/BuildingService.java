package service;

import java.util.List;

import model.BuildingModel;

public interface BuildingService {
	List<BuildingModel> findAll(String name, String street, Integer numberOfBasement, Integer floorArea, String type);
}
