
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeatherApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("toolbar-demo.fxml"));
		primaryStage.setTitle("Toolbar Demo App");
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("Inside stop() method! Destroy resources. Perform Cleanup.");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
