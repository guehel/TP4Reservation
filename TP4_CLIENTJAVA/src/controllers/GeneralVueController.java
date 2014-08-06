package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GeneralVueController
{
	@FXML
	private ListView<String> roomList;
	
	@FXML
	private void initialize()
	{
		ObservableList<String> items =FXCollections.observableArrayList (
			    "Single", "Double", "Suite", "Family App");
		roomList.setItems(items);
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		
	}
	
}
