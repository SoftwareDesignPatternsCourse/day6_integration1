package com.weather.forecaster;

public class ApiWeatherResponse implements ApiResponse {

	private int statusCode;
	private String responseBody;

	public ApiWeatherResponse(int statusCode, String responseBody)
	{
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}
	
	public int statusCode() 
	{
		return this.statusCode;
	}

	public String responseBody()
	{ 
		return this.responseBody; 
	}

}
