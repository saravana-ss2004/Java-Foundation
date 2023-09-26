package com.fakerData;

/**
 * @author Saravanakumar S S (ZSTCH1200/22)
 * @Email  saravanakumar.ss@zohocorp.com
 */

import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

/**
 * This class generates fake data for CRM modules
 */

@Component
public class FakeGenerator {
	Logger logger = Logger.getLogger(FakeGenerator.class.getName());

	/**
	 * This method make api call to generates address with the help of ZipCode
	 * 
	 * @param postCode contains ZipCode
	 * @return returns the JSON object that contains Country, State, City, Street,
	 *         Zipcode
	 */
	public JSONObject addressGenerator(String postCode) {
		logger.info("Address generated method called");
		GetCityAndAddress addr = new GetCityAndAddress();
		JSONObject address = new JSONObject();

		JSONObject location = addr.getCityAndAddress(postCode);
		JSONArray dataDetails = (JSONArray) location.get("features");
		if (dataDetails.length() != 0) {
			JSONObject obj = (JSONObject) dataDetails.get(0);
			JSONObject data = (JSONObject) obj.get("properties");

			if ((data.has("country") && data.has("state") && data.has("city") && data.has("postcode"))
					&& (data.has("street") || data.has("county"))) {
				String country = data.getString("country");
				String state = data.getString("state");
				String city = data.getString("city");
				String zipCode = data.getString("postcode");
				String street;

				if (data.has("street")) {
					street = data.getString("street");
				} else {
					street = data.getString("county");
				}

				address.put("Country", country);
				address.put("State", state);
				address.put("City", city);
				address.put("Zip_Code", zipCode);
				address.put("Street", street);
				logger.info("address object returned");
				return address;
			} else {
				return addressGenerator(new Faker().address().zipCode());
			}
		} else {
			return addressGenerator(new Faker().address().zipCode());
		}

	}

	/**
	 * This method generates fake data for lead module
	 * 
	 * @return returns JSON object that containing fake data
	 */
	public JSONObject leadGenerator() {

		try {

			logger.info("Fake data generated started for LEAD");
			JSONObject requestObject = new JSONObject();
			JSONArray dataArray = new JSONArray();
			JSONObject dataObject = new JSONObject();
			JSONArray trigger = new JSONArray();
			Faker faker = new Faker();

			int minRevenue = 100000;
			int maxRevenue = 10000000;
			int annualRevenue = (int) (minRevenue + (Math.random() * (maxRevenue - minRevenue)));

			String firstName = faker.address().firstName();
			String lastName = faker.address().lastName();
			String email = faker.internet().emailAddress(firstName + lastName);
			String company = faker.company().name();
			String mobile = faker.phoneNumber().cellPhone();
			String website = faker.internet().url();
			String postCode = faker.address().zipCode();

			JSONObject address = addressGenerator(postCode);

			dataObject.put("First_Name", firstName);
			dataObject.put("Last_Name", lastName);
			dataObject.put("Email", email);
			dataObject.put("Phone", mobile);
			dataObject.put("Company", company);
			dataObject.put("Annual_Revenue", annualRevenue);
			dataObject.put("Website", website);

			dataObject.put("Country", address.get("Country"));
			dataObject.put("State", address.get("State"));
			dataObject.put("City", address.get("City"));
			dataObject.put("Zip_Code", address.get("Zip_Code"));
			dataObject.put("Street", address.get("Street"));

			logger.info("Fake data for LEAD is generated");

			dataArray.put(dataObject);

			trigger.put("approval");
			trigger.put("workflow");
			trigger.put("blueprint");

			requestObject.put("data", dataArray);
			requestObject.put("trigger", trigger);
			logger.info("Fake data (LEAD) request object generated ::" + requestObject.toString());

			return requestObject;

		} catch (Exception e) {
			logger.info("Exception occured when generating fake data(LEAD)");
			e.printStackTrace();

			return null;
		}

	}

	/**
	 * This method generates fake data for contact module
	 * 
	 * @return returns JSON object that containing fake data
	 */
	public JSONObject contactGenerator() {
		logger.info("Fake data generated started for CONTACT");
		try {
			JSONObject requestObject = new JSONObject();
			JSONArray dataArray = new JSONArray();
			JSONObject dataObject = new JSONObject();
			JSONArray trigger = new JSONArray();

			String[] arr = new String[] { "Quality Engineer", "Product Engineer", "Information System Manager",
					"Internal Auditor", "System Administrator", "Assistant Media Planner", "Cheif Design Engineer",
					"Computer System Analyst" };
			int randomNumber = (int) Math.round((Math.random() * 7));

			Faker faker = new Faker();

			String firstName = faker.address().firstName();
			String lastName = faker.address().lastName();
			String email = faker.internet().emailAddress(firstName + lastName);
			String mobile = faker.phoneNumber().cellPhone();
			String postCode = faker.address().zipCode();

			String title = arr[randomNumber];

			JSONObject address = addressGenerator(postCode);

			dataObject.put("First_Name", firstName);
			dataObject.put("Last_Name", lastName);
			dataObject.put("Email", email);
			dataObject.put("Phone", mobile);
			dataObject.put("Mailing_Street", address.get("Street"));
			dataObject.put("Mailing_City", address.get("City"));
			dataObject.put("Mailing_State", address.get("State"));
			dataObject.put("Mailing_Country", address.get("Country"));
			dataObject.put("Mailing_Zip", address.get("Zip_Code"));
			dataObject.put("Title", title);

			dataArray.put(dataObject);

			trigger.put("approval");
			trigger.put("workflow");
			trigger.put("blueprint");

			requestObject.put("data", dataArray);
			requestObject.put("trigger", trigger);
			logger.info("Fake data (CONTACT) request object generated ::" + requestObject.toString());

			return requestObject;
		} catch (Exception e) {
			logger.info("Exception occured when generating fake data(CONTACT)");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method generates fake data for account module
	 * 
	 * @return returns JSON object that containing fake data
	 */
	public JSONObject accountGenerator() {
		logger.info("Fake data generated started for Account");
		try {
			JSONObject requestObject = new JSONObject();
			JSONArray dataArray = new JSONArray();
			JSONObject dataObject = new JSONObject();
			JSONArray trigger = new JSONArray();

			int number = (int) Math.round(Math.random() * 2500);
			String employees = String.valueOf(number);

			int minRevenue = 100000;
			int maxRevenue = 10000000;
			int annualRevenue = (int) (minRevenue + (Math.random() * (maxRevenue - minRevenue)));

			Faker faker = new Faker();

			String accountName = faker.company().name();
			String website = faker.internet().url();
			String mobile = faker.phoneNumber().phoneNumber();
			String billingZipCode = faker.address().zipCode();

			JSONObject address = addressGenerator(billingZipCode);

			dataObject.put("Account_Name", accountName);
			dataObject.put("Website", website);
			dataObject.put("Phone", mobile);
			dataObject.put("Billing_Street", address.get("Street"));
			dataObject.put("Billing_City", address.get("City"));
			dataObject.put("Billing_State", address.get("State"));
			dataObject.put("Billing_Code", address.get("Zip_Code"));
			dataObject.put("Billing_Country", address.get("Country"));
			dataObject.put("Employees", employees);
			dataObject.put("Annual_Revenue", annualRevenue);

			dataArray.put(dataObject);

			trigger.put("approval");
			trigger.put("workflow");
			trigger.put("blueprint");

			requestObject.put("data", dataArray);
			requestObject.put("trigger", trigger);
			logger.info("Fake data (ACCOUNT) request object generated ::" + requestObject.toString());

			return requestObject;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This method generates fake data for deal module
	 * 
	 * @return returns JSON object that containing fake data
	 */
	public JSONObject dealGenerator() {
		logger.info("Fake data generated started for deal");
		try {
			JSONObject requestObject = new JSONObject();
			JSONArray dataArray = new JSONArray();
			JSONObject dataObject = new JSONObject();
			JSONArray trigger = new JSONArray();

			String[] stages = new String[] { "Qualification", "Needs Analysis", "Value Proposition",
					"Identify Decision Makers", "Proposal/Price Quote", "Negotiation/Review", "Closed Won",
					"Closed Lost", "Closed-Lost to Competition" };

			String[] pipelines = new String[] { "Standard (Standard)", "Sales Pipeline", "Deals Pipeline" };
			int pipeNumber = (int) Math.round(Math.random() * 2);

			String pipeline = pipelines[pipeNumber];
			String stage = null;

			if (pipeline == "Sales Pipeline") {
				int[] salesStages = new int[] { 0, 1, 5 };
				int number = (int) Math.round(Math.random() * 2);
				int salesNumber = salesStages[number];
				stage = stages[salesNumber];
			} else if (pipeline == "Deals Pipeline") {
				int[] salesStages = new int[] { 4, 5, 6, 7 };
				int number = (int) Math.round(Math.random() * 3);
				int dealsNumber = salesStages[number];
				stage = stages[dealsNumber];
			} else {
				int number = (int) Math.round(Math.random() * 8);
				stage = stages[number];

			}

			int discount = (int) Math.round(Math.random() * 50);

			int minRevenue = 100000;
			int maxRevenue = 10000000;
			int Amount = (int) (minRevenue + (Math.random() * (maxRevenue - minRevenue)));

			Faker faker = new Faker();

			String accountName = faker.company().name();
			String mobile = faker.phoneNumber().phoneNumber();
			String billingZipCode = faker.address().zipCode();
			String dealName = faker.address().firstName();

			int probability = discount + 50;

			JSONObject address = addressGenerator(billingZipCode);

			dataObject.put("Account_Name", accountName);
			dataObject.put("Phone_Number", mobile);
			dataObject.put("Address", address.get("Street") + "," + address.get("City") + "," + address.get("State")
					+ "," + address.get("Country"));
			dataObject.put("City", address.get("City"));
			dataObject.put("Amount", Amount);
			dataObject.put("Stage", stage);
			dataObject.put("Discount", discount);
			dataObject.put("Pipeline", pipeline);
			dataObject.accumulate("Deal_Name", dealName);

			dataObject.put("Probability", probability);

			dataArray.put(dataObject);

			trigger.put("approval");
			trigger.put("workflow");
			trigger.put("blueprint");

			requestObject.put("data", dataArray);
			requestObject.put("trigger", trigger);
			logger.info("Fake data (DEAL) request object generated ::" + requestObject.toString());

			return requestObject;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}
}
