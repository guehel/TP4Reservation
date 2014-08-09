package controllers;

import services.ConnectionService;
import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;

public class RootController
{
	private ConnectionService connectionService;
	@FXML
	private void connect()
	{
		Stage stage = new Stage();

		String input = Dialogs.showInputDialog(stage,
				"Votre num�ro d'employ�:", "Identification", "Connection");

		if (input != null)
		{
			connectionService.connect(Long.parseLong(input));
		}
	}

	public void setConnectionService(ConnectionService connectionService)
	{
		this.connectionService = connectionService;
	}
}