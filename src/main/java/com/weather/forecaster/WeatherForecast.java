package com.weather.forecaster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {

	private WeatherCondition current;

	public WeatherCondition getCurrent() {
		return current;
	}

	public void setCurrent(WeatherCondition current) {
		this.current = current;
	}

}
