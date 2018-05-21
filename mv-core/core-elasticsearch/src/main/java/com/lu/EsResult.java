package com.lu;

import com.google.gson.JsonArray;

import lombok.Data;
@Data
public class EsResult {
	private int total;
	private JsonArray result;
}
