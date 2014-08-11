package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;
import services.ConnectionService;

/**
 * Controleur de la racine de l'interface graphique.
 * 
 * @author Steve Boisvert.
 * 
 */
public class RootController
{
	private ConnectionService	connectionService;

	/**
	 * Affichage du dialog de connection d'un utilisateur.
	 */
	@FXML
	private void connect()
	{
		Stage stage = new Stage();

		String input = Dialogs.showInputDialog(stage,
				"Votre numéro d'employé:", "Identification", "Connection");

		if (input != null)
		{
			// TODO : Validation de l'id entré par l'utilisateur.
			connectionService.connect(Long.parseLong(input));
		}
	}

	/**
	 * Mutateur du service de connection.
	 * 
	 * @param connectionService
	 *            , le service de connection.
	 */
	public void setConnectionService(ConnectionService connectionService)
	{
		this.connectionService = connectionService;
	}
}