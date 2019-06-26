package com.gxy.util;

import java.util.UUID;

public class GeneralUtil {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-","");  
		return uuid;
	}
}
