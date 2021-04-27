package com.rainbow.rainbow.ds.rest;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ray
 *
 *         Sep 17, 2015
 */
public class BaseService {

	protected String getJsonStr(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
	    mapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonStr = "";
		try {
			if (object != null) {
				jsonStr = mapper.writeValueAsString(object);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}
	
	protected String getJsonStrWithNull(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = "";
		try {
			if (object != null) {
				jsonStr = mapper.writeValueAsString(object);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}
}
