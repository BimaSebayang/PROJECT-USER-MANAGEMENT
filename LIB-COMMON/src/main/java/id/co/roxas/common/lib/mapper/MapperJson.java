package id.co.roxas.common.lib.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class MapperJson {
	
	public static Map<String, Object> mapperJsonToHashMap(String result) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, Object> finalMap = new HashMap<>();
		try {
			finalMap = mapper.readValue(result, new TypeReference<HashMap<String, Object>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
			finalMap.put("error_method", e.getMessage());
		}
		return finalMap;
	}
	
	public static <T> T mapperJsonToSingleDto(String json, Class<T> clazz) throws Exception {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		om.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		return om.readValue(json, clazz);
	}

	public static <T> T mapperHashmapToSingleDto(Map<String, Object> json, Class<T> clazz) throws Exception {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		om.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		return om.convertValue(json, clazz);
	}

	public static <T> List<T> mapperJsonToListDto(String json, Class<T> clazz) throws Exception {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		om.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		TypeFactory t = TypeFactory.defaultInstance();
		List<T> list = om.readValue(json, t.constructCollectionType(ArrayList.class, clazz));
		return list;
	}

	
}
