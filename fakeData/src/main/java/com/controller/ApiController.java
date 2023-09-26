package com.controller;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.CRMAPI.ModulesApi;
import com.fakerData.FakeGenerator;

/**
 * This class work as second controller
 */
@Component
public class ApiController {
	Logger logger = Logger.getLogger(ApiController.class.getName());

	/**
	 * This method make calls to generate lead data and CRM api
	 * 
	 * @return returns the response object
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public JSONObject lead() throws ClientProtocolException, IOException {
		logger.info("lead method called");
		FakeGenerator faker = new FakeGenerator();
		JSONObject leadsData = faker.leadGenerator();

		ModulesApi lead = new ModulesApi();
		JSONObject responseObject = lead.apiToModules(leadsData, "Leads");

		JSONArray dataDetails = (JSONArray) responseObject.get("data");
		JSONObject obj = (JSONObject) dataDetails.get(0);
		String data = obj.getString("code");
		System.out.println(data);

		return responseObject;

	}

	/**
	 * This method make calls to generate account data and CRM api
	 * 
	 * @return returns the response object
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public JSONObject contact() throws ClientProtocolException, IOException {
		logger.info("lead method called");
		FakeGenerator faker = new FakeGenerator();
		JSONObject leadsData = faker.contactGenerator();

		ModulesApi lead = new ModulesApi();
		JSONObject responseObject = lead.apiToModules(leadsData, "Contacts");

		JSONArray dataDetails = (JSONArray) responseObject.get("data");
		JSONObject obj = (JSONObject) dataDetails.get(0);
		String data = obj.getString("code");
		System.out.println(data);

		return responseObject;

	}

	/**
	 * This method make calls to generate account data and CRM api
	 * 
	 * @return returns the response object
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public JSONObject account() throws ClientProtocolException, IOException {
		logger.info("lead method called");
		FakeGenerator faker = new FakeGenerator();
		JSONObject leadsData = faker.accountGenerator();

		ModulesApi lead = new ModulesApi();
		JSONObject responseObject = lead.apiToModules(leadsData, "Accounts");

		JSONArray dataDetails = (JSONArray) responseObject.get("data");
		JSONObject obj = (JSONObject) dataDetails.get(0);
		String data = obj.getString("code");
		System.out.println(data);

		return responseObject;

	}

	/**
	 * This method make calls to generate deal data and CRM api
	 * 
	 * @return returns the response object
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public JSONObject deal() throws ClientProtocolException, IOException {
		logger.info("lead method called");
		FakeGenerator faker = new FakeGenerator();
		JSONObject leadsData = faker.dealGenerator();

		ModulesApi lead = new ModulesApi();
		JSONObject responseObject = lead.apiToModules(leadsData, "Deals");

		JSONArray dataDetails = (JSONArray) responseObject.get("data");
		JSONObject obj = (JSONObject) dataDetails.get(0);
		String data = obj.getString("code");
		System.out.println(data);

		return responseObject;

	}

}
