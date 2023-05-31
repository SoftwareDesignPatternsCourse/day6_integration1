package com.weather.forecast.api;

import java.io.IOException;

public interface ApiRequest {

	
	public ApiResponse get() throws IOException;
	
}
