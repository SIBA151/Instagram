package com.instagram.qa.Utility;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

public static Properties prop;
	
	public static Properties getProValue(String fileName) {
		String filePath=System.getProperty("user.dir")+"/src/main/resources/properties/"+fileName+".properties";
		try {
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
//	private static final String defaultPropertiesPath = System.getProperty("user.dir")
//			+ "/src/main/resources/properties";
//	private static final HashMap<String, String> propertiesMap = getAllPropertiesFiles(defaultPropertiesPath);
//
//	private static HashMap<String, String> getAllPropertiesFiles(String directoryPath) {
//		File directory = new File(directoryPath);
//		File[] fileList = directory.listFiles();
//		HashMap<String, String> propertiesFilePathMap = new HashMap<>();
//		if (fileList != null && fileList.length > 0) {
//			for (File file : fileList) {
//				if (file.isDirectory()) {
//					propertiesFilePathMap.putAll(getAllPropertiesFiles(file.getAbsolutePath()));
//				} else {
//					propertiesFilePathMap.put(file.getName(), file.getAbsolutePath());
//				}
//			}
//		}
//		return propertiesFilePathMap;
//	}
//
//	private static String getFilePath(String fileName) {
//		return propertiesMap.get(fileName + ".properties");
//	}
//
//	public static Properties getProperties(String fileName) {
//		Properties propertiesFileObject = new Properties();
//		try {
//			FileInputStream inputStream = new FileInputStream(getFilePath(fileName));
//			propertiesFileObject.load(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
//			/*
//			 * BufferedReader fileReader = new BufferedReader(new
//			 * FileReader(getFilePath(fileName))); propertiesFileObject.load(fileReader);
//			 */
//		} catch (IOException ioException) {
//			//logError("Error occurred while fetching properties from " + fileName + " for execution data");
//		}
//		return propertiesFileObject;
//	}

}
