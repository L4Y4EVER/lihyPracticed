package com.ucaitop.tb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static String getValue(String key,String proName){
		String value = null;
		//java 提供的专门访问配置文件的类
		Properties p = new Properties();
		String path = PropertiesUtil.class.getResource("/").getPath();
		try {
			p.load(new FileInputStream(new File(path,proName)));
			value = p.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
