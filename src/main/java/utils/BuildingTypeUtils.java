package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.laptrinhjavaweb.jdbc.constant.SystemConstant;

public class BuildingTypeUtils {
	public static Map<String, String> getBuildingType() {
		Map<String, String> hashMap1 = new HashMap<String, String>();
		hashMap1.put(SystemConstant.TANG_TRET_CODE,SystemConstant.TANG_TRET);
		hashMap1.put(SystemConstant.NGUYEN_CAN_CODE,SystemConstant.NGUYEN_CAN);
		hashMap1.put(SystemConstant.NOI_THAT_CODE,SystemConstant.NOI_THAT);
		return hashMap1;
	}
}

//
//Set<String> setHashMap = hashMap1.keySet();
//for (String key : setHashMap) {
//	if(value.equals(key)) {
//		value = key.replace(key,hashMap1.get(key)); // set value của buildingtype = value của map
//	} 
//}
