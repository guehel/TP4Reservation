package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.RoomService;
import application.Main;

public class RootController
{
	// Localisation des fichier fxml.
	private String rootFXML = "/vue/Root.fxml";
	private String generalViewFXML = "/vue/GeneralVue.fxml";

	public RootController(Stage primaryStage)
	{
		
		// Configuration de la fenêtre racine de l'application
		primaryStage.setTitle("Hotel Réservation");
		FXMLLoader loader = this.getLoader(this.rootFXML);
		BorderPane root = null;

		try
		{
			root = (BorderPane) loader.load();

		} catch (IOException e)
		{
			System.out.println(e.getStackTrace());
			System.err
					.println("Le fichier " + rootFXML + " n'a pas été trouvé");
		}

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		// Configuration de la vue générale de l'application
		loader = getLoader(this.generalViewFXML);
		AnchorPane generalViewPane = null;

		try
		{
			generalViewPane = (AnchorPane) loader.load();

		} catch (IOException e)
		{
			System.err.println("Le fichier " + generalViewFXML
					+ " n'a pas été trouvé");
		}
		GeneralVueController generalVueController = loader.getController();
		generalVueController.setPrimaryStage(primaryStage);
		
		
		// Injection des services
		generalVueController.setRoomService(new RoomService());

		root.setCenter(generalViewPane);
	}
	
	/**
	 * Méthode retournant le loader d'un fichier FXML envoyé en paramêtre.
	 * 
	 * @param FXMLFile
	 *            String, le fichier FXML.
	 * @return FXMLLoader, le loader du fichier FXML.
	 */
	private FXMLLoader getLoader(String FXMLFile)
	{
		return new FXMLLoader(Main.class.getResource(FXMLFile));
	}
}
