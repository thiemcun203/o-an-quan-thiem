import controller.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
	public void start(Stage primaryStage) throws Exception {

		// Name for the application
		final String appName = "O An Quan App";
		primaryStage.setTitle(appName);

		// Set icon for the application


		// Set minimum windows size to avoid unusual look
		primaryStage.setMinHeight(768);
		primaryStage.setMinWidth(1024);

		// Load view for the stage
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("MAIN/src/view/Home.fxml"));
		Parent rootLayout = loader.load();
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);

		// Load model for view through its controller
		HomeController homeController = loader.getController();
		loader.setController(homeController);


		// Display the stage
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
