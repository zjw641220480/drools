package com.itcast.zjw.drools.jackson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class JackSon {
	private ObjectMapper objectMapper = new ObjectMapper();
	private String json = null;
	@Before
	public void testBefore(){
		json = "{\"success\": true,\"final_score\": 80,\"final_decision\": {\"user\":\"zhangsan\"},\"report_id\": \"ER2015070617512600000001\"}";
	}
	@Test
	public void testJsonToMap() throws JsonParseException, JsonMappingException, IOException{
		System.out.println(json);
		Map<String, Object> map = new HashMap<String,Object>();
		map = objectMapper.readValue(json, Map.class);
		//objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class,);
		json = objectMapper.writeValueAsString(map);
		System.out.println(json);
		JsonNode jsonNode = objectMapper.readTree(json);
		System.out.println(map.get("final_decision"));
		System.out.println(jsonNode);
		System.out.println("JackSon.testJsonToMap()");
	}
	
	
}
