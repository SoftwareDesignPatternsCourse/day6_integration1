import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecaster.WeatherForecast;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherAppController {

	@FXML
	private void printHelloWorld(ActionEvent event) {
		event.consume();
		System.out.println("Hello, World!");
		yourLabel.setText("Facux");

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
			URIBuilder ub = new URIBuilder(
					"http://api.weatherapi.com/v1/forecast.json?key=06712f56f6e2431590b184348232905");
			ub.addParameter("q", location);
			ub.addParameter("days", "1");
			ub.addParameter("aqi", "no");
			ub.addParameter("alerts", "no");

			// Create URL object with the API endpoint
			URL url = new URL(ub.toString());

			// Open connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

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
			ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize the JSON into the ApiResponse class
			WeatherForecast forecast = objectMapper.readValue(response.toString(), WeatherForecast.class);
			
			System.out.println("forecast" + forecast.getCurrent().getTemp_c());
			// Close connection
			connection.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
