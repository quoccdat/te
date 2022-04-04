package utils;

public class ValidateUtils {
	public static boolean isValid(String dbType) {
		if (dbType != "" && dbType!=null) {
			return false;
		}
		return true;
	}
}
