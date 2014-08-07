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
				"Votre numéro d'employé:", "Identification", "Connection");

		if (input != null)
		{
				
		}
	}
}
