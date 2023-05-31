import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecaster.ApiForecastBuilder;
import com.weather.forecaster.ApiResponse;
import com.weather.forecaster.WeatherForecast;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class WeatherAppController {

	@FXML
	private void printHelloWorld(ActionEvent event) {
		event.consume();
		System.out.println("Hello, World!");
		yourLabel.setText("Facux");

	}

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
	private void updateLabel(ActionEvent event) {
		event.consume();
		System.out.println("Hello, World!");
		String location = inputTextField.getText();
		yourLabel.setText(location);
		this.getForecast(location);
	}

	@FXML
	private TextField inputTextField;

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
					
			
			// apiForecastBuilder.addDays(5);
			
			ApiResponse response = apiForecastBuilder.build().get();
			

			ObjectMapper objectMapper = new ObjectMapper();

			// Deserialize the JSON into the ApiResponse class
			WeatherForecast forecast = objectMapper.readValue(response.responseBody(), WeatherForecast.class);

			System.out.println("forecast" + forecast.getCurrent().getTemp_c());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
