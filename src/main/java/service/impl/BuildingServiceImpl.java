package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.jdbc.constant.SystemConstant;

import dao.BuildingDao;
import dao.emyeuanh.BuildingEmyeuanh;
import dao.impl.BuildingDaoImpl;
import model.BuildingModel;
import service.BuildingService;
import utils.BuildingTypeUtils;
import utils.ValidateUtils;

public class BuildingServiceImpl implements BuildingService {
	// ddinh nghia interface trc,xong den impl
//	private BuildingDao buildingDao;
//	
//	public public BuildingServiceImpl() {
//		buildingDao = new BuildingDaoImpl();
//	}
//

	private BuildingDao buildingDao = new BuildingDaoImpl(); // gọi lại từ tầng dta access đặt tên biến buildingDao,để lấy dữ liệu từ buildingDao

	@Override
	public List<BuildingModel> findAll(String name, String street, Integer numberOfBasement, Integer floorArea,
			String type) {
		List<BuildingEmyeuanh> buildingEmyeuanhs = buildingDao.findAll(name, street, numberOfBasement, floorArea, type);
		// gọi lại list và biến của tầng data, lấy dữ liệu từ data access(dao) từ Db lên
		// để tạo thành bdmodel đưa lên controller
		List<BuildingModel> buildingModels = new ArrayList<>(); // tạo ra list và biến muốn trả về của tầng logic này
		for (BuildingEmyeuanh item : buildingEmyeuanhs) { // bắt đầu duyệt qua dữ liệu trong db lấy lên đc từ tầng 3
			BuildingModel buildingModel = new BuildingModel(); // gọi lại xong khởi tạo đối tượng bModel để chứa ttin
			buildingModel.setName(item.getName());
			buildingModel.setStreet(item.getStreet());
			buildingModel.setNumberOfBasement(item.getNumberOfBasement());
			buildingModel.setFloorArea(item.getFloorArea());
			buildingModel.setType(item.getType());
			buildingModels.add(buildingModel); // gán tất cả ttin dtuong. lấy đc vào bModels
		}
		return buildingModels; // biến trả về tầng logic
	}
	
	private String convertBuildingTypes(String dbType) {
		Map<String, String> typeMap = BuildingTypeUtils.getBuildingType();// tạo biến typeMap để get dữ liệu key value từ map bên utils
		StringBuilder convertedType = new StringBuilder(); // tạo ra cái chuỗi convertedType
		
		if (ValidateUtils.isValid(dbType)) {
			String[] typeArray = dbType.split(","); // tách dấu , = split
			for (String item : typeArray) { 
				if(typeMap.containsKey(item)) {
					convertedType.append("\n-" + typeMap.get(item));
				}else {
					return null;
				}
			}
		}
		return convertedType.toString();
	}
}