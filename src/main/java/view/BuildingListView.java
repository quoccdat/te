package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import controller.BuildingController;
import model.BuildingModel;
import service.impl.BuildingServiceImpl;
import utils.BuildingTypeUtils;

public class BuildingListView {
	public static void main(String[] args) {
//---------------INPUT------------------
		Scanner in = new Scanner(System.in);   
	    System.out.println("Nhập tên tòa nhà : ");  
	    String name = in.nextLine();	
	    
	    System.out.println("Nhập số tầng hầm : ");  
//	    String numberOfBasementStr = in.nextLine();
//	    Integer numberOfBasement = numberOfBasementStr != null ? Integer.parseInt(numberOfBasementStr):null;
//	    Integer numberOfBasement = in.nextInt(); có thể lấy input từ ng dùng vào = cách này dạng INT
	    Integer numberOfBasement = null;
	    
	    System.out.println("Nhập diện tích sàn : ");  
//	    String floorAreaStr = in.nextLine();
//	    Integer floorArea = floorAreaStr != null ? Integer.parseInt(floorAreaStr) : null ;  
	    Integer floorArea = null;
	    
	    System.out.println("Nhập số đường : ");  
//	    String street = in.nextLine();
	    String street = null;
	    
	    System.out.println("Nhập loại tòa nhà : ");
//	    String type = in.nextLine();
	    String type = in.nextLine();
	    
	    
	    // nhap = tang-tret, nguyen-can, noi-that
//---------------OUTPUT------------------
	  //----- NOTE: Chỉ cần nhập toa nha và loại tòa nhà. 
	    BuildingController buildingController = new BuildingController();
		List<BuildingModel> buildingModels = buildingController.findAll(name, street, numberOfBasement, floorArea, type); 
		int i = 1;
	    for (BuildingModel item : buildingModels) {
	    	System.out.println(" Name: "+ item.getName() +"\n" + " Diện tích sàn: " + item.getFloorArea() +"\n"
	    			+ " Số Tầng Hầm: " + item.getNumberOfBasement() +"\n" + " Số Đường: " + item.getStreet());
	    	System.out.print(" Loại nhà: " + item.getType());
	    	System.out.println("\n------Details Home Number "+i+"------");
	    	i++;
	    }
		in.close();
	}
}

//String[] chuoi = item.getType().split(","); // dùng split để tách dấu , 
//for(String str:chuoi) {
//	System.out.print(BuildingTypeUtils.getBuildingType(str)+" ");
//}

