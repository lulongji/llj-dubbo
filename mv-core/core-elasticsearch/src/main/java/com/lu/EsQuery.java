package com.lu;

import lombok.Data;

@Data
public class EsQuery {
	private String[] fields;
	private String queryWord;
	private int from = 0;
	private int size = 20;
	// private Map<String,Boolean> sort;
	private String preTag = "<span class='ce27'>";
	private String endTag = "</span>";
	StringBuilder json;

	public EsQuery() {
		json = new StringBuilder();
	}

	public String getQueryString() {
		String field = "";
		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				if (i > 0) {
					field += ",";
				}
				field += "\"" + fields[i] + "\"";
			}
		}
		json.append("{\"query\":{\"query_string\":{\"fields\":[");
		json.append(field);
		json.append("],\"query\":\"").append(queryWord).append("\",\"analyzer\":\"ik_max_word\"}} , \"from\":").append(from).append(",\"size\":").append(size).append(",");
		json.append("\"sort\":{\"_score\": {\"order\" : \"desc\"}} ,");
		json.append("\"highlight\" : { \"pre_tags\" : [\"").append(preTag).append("\"], \"post_tags\" : [\"").append(endTag).append("\"], \"fields\" : {");
		int i = 0;
		for (String f : fields) {
			if (i > 0) {
				json.append(",");
			}
			json.append("\"").append(f).append("\":{}");
			++i;
		}
		json.append("}}}");

		// json.append("\"sort\":{\"_score\": {\"order\" : \"desc\"}} }");
		return json.toString();
	}

	public static void main(String[] args) {
		EsQuery query = new EsQuery();
		query.setFields(new String[] { "nickname" });
		query.setQueryWord("中国人民共和国鲁龙基");
		System.out.println(query.getQueryString());
	}
}
