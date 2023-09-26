package com.CRMAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/**
 * This class generates access token for ARM apis
 */
public class Tokens {
	String REFRESH_TOKEN = "1000.a641dd48c8d88fdc70c589c4262794d1.ac653fc70c1fb43b0d336e366e516599";
	static String accessToken;

	String CLIENT_ID = "1000.YG5HRD7K5ECRZZHQDTROSTH3IKKODA";
	String CLIENT_SECRET = "24f3e17e1d5bcac0a3db94c801f6ff7e30cf6e5167";
	String TOKEN_URL = "https://accounts.zoho.com/oauth/v2/token";
	public String API_URL = "https://www.zohoapis.com/crm/v5/";

	Logger logger = Logger.getLogger(Tokens.class.getName());

	/**
	 * This method generates access token with use of refresh token
	 * 
	 * @return returns the access token
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String getAccessToken() throws ClientProtocolException, IOException {
		try {
			logger.info("Acess token generation started");
			HttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(TOKEN_URL);

			List<NameValuePair> params = new ArrayList<NameValuePair>(4);
			params.add(new BasicNameValuePair("grant_type", "refresh_token"));
			params.add(new BasicNameValuePair("refresh_token", REFRESH_TOKEN));
			params.add(new BasicNameValuePair("client_id", CLIENT_ID));
			params.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));

			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			System.out.println(entity);

			if (entity != null) {
				try (InputStream instream = entity.getContent()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
					String line;
					while ((line = reader.readLine()) != null) {
						JSONObject responsesJson = new JSONObject(line);
						String code = responsesJson.getString("access_token");
						System.out.println(code);
						logger.info("Access Token generated successfully");
						return code;

					}
				}

			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception while generting access token");
			return null;
		}

	}
}
