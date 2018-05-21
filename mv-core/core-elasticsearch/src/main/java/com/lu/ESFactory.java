package com.lu;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;

public class ESFactory {
	private static JestHttpClient client;
	private static JestClientFactory factory;
	private String host;

	public void setHost(String host) {
		this.host = host;
	}

	public void init() {
		factory = new JestClientFactory();
		factory.setHttpClientConfig(
				new HttpClientConfig.Builder(host).multiThreaded(true).build());
		client = (JestHttpClient) factory.getObject();
	}

	public synchronized static JestHttpClient getClient() {
		return client;
	}

}
