package util;

import java.io.IOException;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtils {
	
	public static Properties loadFileAsProperty(String filePath) {
		Properties prop = new Properties();
		try {

			BufferedReader brProp = new BufferedReader(new FileReader(filePath));
			prop.load(brProp);
			brProp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getConfigValue(String filepath, String key) throws IOException {
		String result = "";
		try {
			result = FileUtils.loadFileAsProperty(filepath).getProperty(key);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}