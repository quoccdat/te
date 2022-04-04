package dao;

import java.util.List;

import dao.emyeuanh.BuildingEmyeuanh;

public interface BuildingDao {
	List<BuildingEmyeuanh>findAll(String name, String street, Integer numberOfBasement, Integer floorArea, String type);
}

