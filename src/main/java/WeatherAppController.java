import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecaster.ApiForecastBuilder;
import com.weather.forecaster.ApiResponse;
import com.weather.forecaster.WeatherForecast;
import com.weather.state.WeatherState;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class WeatherAppController {

	@FXML
	private StackPane alarmPanelHot;

	@FXML
	private StackPane alarmPanelCold;

	@FXML
	private void showAlarm(ActionEvent event) {
		event.consume();
		alarmPanelHot.setVisible(!alarmPanelHot.isVisible());
		alarmPanelCold.setVisible(!alarmPanelCold.isVisible());
	}

	@FXML
	private void findCityWeather(ActionEvent event) {
		event.consume();
		String location = cityField.getText();
		
		this.getForecast(location);
	}

	@FXML
	private TextField cityField;

	@FXML
	private Label yourLabel;

	private void getForecast(String location) {
		try {
			ApiForecastBuilder apiForecastBuilder = new ApiForecastBuilder();
			apiForecastBuilder.setKey("http://api.weatherapi.com/v1/forecast.json?key=06712f56f6e2431590b184348232905");
			apiForecastBuilder.setLocation(location);
			apiForecastBuilder.setDays(1);
			apiForecastBuilder.setAlerts(true);
			apiForecastBuilder.setAqi(false);
					
			ApiResponse response = apiForecastBuilder.build().get();
			
			ObjectMapper objectMapper = new ObjectMapper();

			WeatherForecast forecast = objectMapper.readValue(response.responseBody(), WeatherForecast.class);

			if (forecast.getCurrent().getTemp_c() > 10) {
				alarmPanelHot.setVisible(!alarmPanelHot.isVisible());
				
			} else {
				alarmPanelCold.setVisible(!alarmPanelCold.isVisible());
			}
			
			
			
			WeatherState.getInstance().setWeather(forecast);
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
