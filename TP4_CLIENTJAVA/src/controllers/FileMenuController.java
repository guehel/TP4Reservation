package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;

public class FileMenuController
{
	@FXML
	private void connect()
	{
		Stage stage = new Stage();

		String input = Dialogs.showInputDialog(stage,
				"Votre num�ro d'employ�:", "Identification", "Connection");

		if (input != null)
		{
				
		}
	}
}
