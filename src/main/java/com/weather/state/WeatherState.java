package com.weather.state;

import com.weather.forecaster.WeatherForecast;

public class WeatherState {

	private static WeatherState instance;
	private WeatherForecast forecast;

	private WeatherState() {}
	
	public static synchronized WeatherState getInstance() {
		if (WeatherState.instance == null) {
			WeatherState.instance = new WeatherState();
		}
		return WeatherState.instance;
	}
	
	public void setWeather(WeatherForecast forecast) {
		this.forecast = forecast;
	}
}
