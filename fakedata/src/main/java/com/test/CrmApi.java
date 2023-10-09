package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

public class CrmApi {
	public void leadApi() throws InterruptedException, IOException {

		String url = "http://localhost:8080/fakedata/lead";

		URL obj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("POST");

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);

	}

	public void contactApi() throws InterruptedException, IOException {

		String url = "http://localhost:8080/fakedata/contact";

		URL obj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("POST");

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);

	}

	public void accountApi() throws InterruptedException, IOException {
		String url = "http://localhost:8080/fakedata/account";

		URL obj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("POST");

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);
	}

	public void dealApi() throws InterruptedException, IOException {
		String url = "http://localhost:8080/fakedata/deal";

		URL obj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("POST");

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);
	}

	private TaskScheduler scheduler = new ConcurrentTaskScheduler();

	
	@PostConstruct
	public void executeJob() {
		int interval = 24 * 60 * 60 * 1000;
		System.out.println(interval);
		scheduler.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					System.out.println(dateFormat.format(cal.getTime()));
					leadApi();
					contactApi();
					accountApi();
					dealApi();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
			}
		}, interval);
	}

}
