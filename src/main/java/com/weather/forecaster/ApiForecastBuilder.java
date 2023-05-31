package com.weather.forecaster;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import java.net.URL;

public class ApiForecastBuilder {

	private String location;
	private String key;
	private int days;
	private boolean aqi;
	private boolean alerts;
	
	public ApiForecastBuilder()
	{
		
	}
	
	public ApiForecastBuilder setKey(String key) {
		this.key = key;
		return this;
	}
	
	public ApiForecastBuilder setLocation(String location) {
		this.location = location;
		return this;
	}
	
	public ApiForecastBuilder addDays(int days) {
		this.days += days;
		return this;
	}
	
	public ApiForecastBuilder setDays(int days) {
		this.days = days;
		return this;
	}
	
	public ApiForecastBuilder setAqi(boolean value) {
		this.aqi = value;
		return this;
	}
	
	public ApiForecastBuilder setAlerts(boolean value) {
		this.alerts = value;
		return this;
	}
	
	private String getAqu()
	{
		if(this.aqi)
			return "1";
		
		return "0";
	}
	
	private String getAlert()
	{
		if(this.alerts)
			return "yes";
		
		return "no";
	}
	
	public ApiRequest build() throws URISyntaxException, MalformedURLException
	{
		URIBuilder ub = new URIBuilder(this.key);	
		ub.addParameter("q", this.location);
		ub.addParameter("days", String.valueOf(this.days));
		ub.addParameter("aqi", getAqu());
		ub.addParameter("alerts", getAlert());
		
		URL url = new URL(ub.toString());
		
		ApiWeatherRequest result = new ApiWeatherRequest(url);
		
		return result;
	}
}
