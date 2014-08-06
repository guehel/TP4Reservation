package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import controllers.RootController;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage)
	{
		RootController rootController = new RootController(primaryStage);		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
