package com.deepak.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}

	public static String convertJavaToJson(Object object) {
		String jsonResponse = "";
		try {
			jsonResponse = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			System.out.println("Exception occur while converting java object to json object" + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception occur while converting java object to json object" + e.getMessage());

		} catch (IOException e) {
			System.out.println("Exception occur while converting java object to json object" + e.getMessage());

		}
		return jsonResponse;
	}

	public static <T> T convertJsonToJava(String jsonString, Class<T> clazz) {
		T result = null;
		try {
			result = mapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			System.out.println("Exception occur while converting JSON object to JAVA object" + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception occur while converting JSON object to JAVA object" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception occur while converting JSON object to JAVA object" + e.getMessage());
		}
		return result;
	}
}
