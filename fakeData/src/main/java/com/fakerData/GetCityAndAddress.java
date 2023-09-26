package com.fakerData;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * This class is for generate address with zip code
 */
public class GetCityAndAddress {
	/**
	 * 
	 * @param zipCode
	 * @return
	 */
	public JSONObject getCityAndAddress(String zipCode) {
		String apiKey = "4ab47bc0fb544049bf9b64b99002dd0f";

		HttpClient httpClient = HttpClients.createDefault();
		String apiUrl = "https://api.geoapify.com/v1/geocode/search?text=" + zipCode + "&apiKey=" + apiKey;

		try {
			HttpGet httpGet = new HttpGet(apiUrl);
			String responseBody = EntityUtils.toString(httpClient.execute(httpGet).getEntity());

			JSONObject json = new JSONObject(responseBody);

			return json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
