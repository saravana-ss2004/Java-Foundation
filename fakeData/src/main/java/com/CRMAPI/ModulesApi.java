package com.CRMAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/**
 * This class make calls with CRM api
 */
public class ModulesApi {
	Tokens token = new Tokens();
	HttpClient httpclient = HttpClients.createDefault();
	Logger logger = Logger.getLogger(ModulesApi.class.getName());

	/**
	 * This method make calls to CRM api
	 * 
	 * @param requestObject JSON object that contains fake data for respective
	 *                      modules
	 * @param module        contains module name
	 * @return returns the response
	 */
	public JSONObject apiToModules(JSONObject requestObject, String module) {
		System.out.println("Module Name :::" + module);
		try {
			if (Tokens.accessToken != null) {

				HttpPost httppost = new HttpPost(token.API_URL + module);

				httppost.setHeader("Authorization", "Zoho-oauthtoken " + Tokens.accessToken);
				httppost.setHeader("Content-Type", "application/json");

				HttpEntity requestBodyEntity = new StringEntity(requestObject.toString(), "UTF-8");

				httppost.setEntity(requestBodyEntity);

				HttpResponse response = httpclient.execute(httppost);
				logger.info("Api for CRM is called");
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					try (InputStream instream = entity.getContent()) {
						BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
						String line;
						while ((line = reader.readLine()) != null) {
							int statusCode = response.getStatusLine().getStatusCode();

							if (statusCode == 401) {
								System.out.println("Token expired");
								Tokens.accessToken = token.getAccessToken();
								return apiToModules(requestObject, module);
							} else if (statusCode == 201) {
								JSONObject responseObject = new JSONObject(line);
								return responseObject;
							} else if (statusCode == 400) {
								JSONObject responseObject = new JSONObject(line);
								return responseObject;
							}

						}
					}

				}
				return null;
			} else {
				logger.info("Acess Token is null and being genenrated");
				System.out.println("Token not available");
				Tokens.accessToken = token.getAccessToken();
				return apiToModules(requestObject, module);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception when calling CRM lead api");
			return null;
		}

	}

}
