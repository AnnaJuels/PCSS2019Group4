package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400); // HEej maja!!!!
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show(); // badabingbadudadmamdam
		} catch(Exception e) {
			e.printStackTrace(); // HELLO MR VANGEDE AND SARAH
		}
	}
	
	public static void main(String[] args) { // hello anna!
		launch(args);
		System.out.println("HelloMaja"); // added
	}
}
