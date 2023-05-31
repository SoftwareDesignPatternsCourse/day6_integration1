package com.weather.forecaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiWeatherRequest implements ApiRequest {

	private URL url;

	public ApiWeatherRequest(URL url)
	{
		this.url = url;
	}
	
	public ApiResponse get() throws IOException {
		//URL url = new URL(apiForecastBuilder.buildUrl());

		// Open connection
		HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();

		// Set request method
		connection.setRequestMethod("GET");

		// Get response code
		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		// Read response
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuilder response = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();

		// Print response
		System.out.println("Response Body: " + response.toString());
		
		connection.disconnect();
		
		return new ApiWeatherResponse(responseCode, response.toString());
	}

}
