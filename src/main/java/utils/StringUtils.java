package utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
	// định nghĩa static để sử dụng ở mọi nơi k cần khởi tạo lại
	public static boolean isNullOrEmpty(String value) {
		if (value != "" && value!=null) {
			return false;
		}
		return true;
	}
}
