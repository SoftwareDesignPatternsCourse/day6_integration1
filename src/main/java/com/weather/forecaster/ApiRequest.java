package com.weather.forecaster;

import java.io.IOException;

public interface ApiRequest {

	public ApiResponse get() throws IOException;
}
