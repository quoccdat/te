package dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.jdbc.constant.SystemConstant;

import dao.BuildingDao;
import dao.emyeuanh.BuildingEmyeuanh;
import model.BuildingModel;
import utils.StringUtils;

public class BuildingDaoImpl implements BuildingDao{
	   private String DB_URL = "jdbc:mysql://localhost:3306/javasql22022";
	   private String USER = "root";
	   private String PASS = "12345678";
	@Override
	public List<BuildingEmyeuanh> findAll(String name, String street, Integer numberOfBasement, Integer floorArea, String type) {
		Connection conn = null;
		Statement stmt = null ; 
//		PreparedStatement stmt = null;
		ResultSet rs = null;  
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);	
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("SELECT * FROM building " + SystemConstant.ONE_TO_ONE);
			if (!StringUtils.isNullOrEmpty(name)) {
				sql.append(" and name like '%"+name+"%' ") ; //truyền trực tiếp tham số
//				sql.append(" and name like ?") ;
			}
			
			if (!StringUtils.isNullOrEmpty(street)) {
				sql.append(" and street like '%"+street+"%' ") ;
//				sql.append(" and street like ?") ;
			}
			if (numberOfBasement != null) {
				sql.append(" and numberOfbasement = "+numberOfBasement+" ") ;
//				sql.append(" and numberOfbasement = ?") ;
			}
			if (floorArea != null) {
				sql.append(" and floorarea = "+floorArea+" ") ;
//				sql.append(" and floorarea = ?") ;
			}
			if (type != null) {
				sql.append(" and type like '%"+type+"%' ") ;
//				sql.append(" and type like ?") ;
			}
			// sau khi build xong sql nó sẽ chuyển qua chuỗi
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery(sql.toString());
//			stmt.setString(1, "'%"+name+"%'");
//			stmt.setString(2, "'%"+street+"%'");
//			stmt.setInt(3, numberOfBasement);
//			stmt.setInt(4, floorArea);
//			stmt.setString(5, "'%"+type+"%'");
//			rs = stmt.executeQuery();
			List<BuildingEmyeuanh> buildingEmyeuanhs = new ArrayList<>();	
			while (rs.next()) {
				BuildingEmyeuanh buildingEmyeuanh = new BuildingEmyeuanh(); //gọi đối tượng dao khởi tạo biến buildingEmyeua để add vào emyeuanhS
				buildingEmyeuanh.setName(rs.getString("name"));
				buildingEmyeuanh.setStreet(rs.getString("street"));
				buildingEmyeuanh.setNumberOfBasement(rs.getInt("numberOfBasement"));
				buildingEmyeuanh.setFloorArea(rs.getInt("floorArea"));
				buildingEmyeuanh.setType(rs.getString("type"));
				buildingEmyeuanhs.add(buildingEmyeuanh);
			}
			return buildingEmyeuanhs; // tầng data access trả về
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
