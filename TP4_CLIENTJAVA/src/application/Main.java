package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.ConnectionService;
import services.entityService.EntityService;
import services.entityService.ServiceableEntityTypes;
import controllers.GeneralVueController;
import controllers.RootController;

public class Main extends Application
{

	// Localisation des fichier fxml.
	private String rootFXML = "/vue/Root.fxml";
	private String generalViewFXML = "/vue/GeneralVue.fxml";

	@Override
	public void start(Stage primaryStage)
	{
		// Configuration de la fen�tre racine de l'application
		primaryStage.setTitle("Hotel R�servation");
		FXMLLoader loader = this.getLoader(this.rootFXML);
		BorderPane root = null;

		try
		{
			root = (BorderPane) loader.load();

		} catch (IOException e)
		{
			System.out.println(e.getStackTrace());
			System.err
					.println("Le fichier " + rootFXML + " n'a pas �t� trouv�");
		}
		
		RootController rootController = loader.getController();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		// Configuration de la vue g�n�rale de l'application
		loader = getLoader(this.generalViewFXML);
		AnchorPane generalViewPane = null;

		try
		{
			generalViewPane = (AnchorPane) loader.load();

		} catch (IOException e)
		{
			System.err.println("Le fichier " + generalViewFXML
					+ " n'a pas �t� trouv�");
		}
		GeneralVueController generalVueController = loader.getController();
		generalVueController.setPrimaryStage(primaryStage);

		// Injection des services
		generalVueController.setRoomService(EntityService
				.getService(ServiceableEntityTypes.ROOM));
		
		rootController.setConnectionService(ConnectionService.getInstance());

		root.setCenter(generalViewPane);
		
		// Enregistre observateurs au service de connection
		ConnectionService.getInstance().addObserver(generalVueController);
	}

	/**
	 * M�thode retournant le loader d'un fichier FXML envoy� en param�tre.
	 * 
	 * @param FXMLFile
	 *            String, le fichier FXML.
	 * @return FXMLLoader, le loader du fichier FXML.
	 */
	private FXMLLoader getLoader(String FXMLFile)
	{
		return new FXMLLoader(Main.class.getResource(FXMLFile));
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
