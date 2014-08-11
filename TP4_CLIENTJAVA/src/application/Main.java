package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.ClientService;
import services.ConnectionService;
import services.RoomService;
import testStevie.SteveServicesWebProxy;
import controllers.GeneralVueController;
import controllers.RootController;

public class Main extends Application
{

	// Localisation des fichier fxml.
	private String rootFXML = "/vue/Root.fxml";
	private String generalViewFXML = "/vue/GeneralVue.fxml";
	
	private BorderPane root;
	private AnchorPane generalViewPane;

	@Override
	public void start(Stage primaryStage)
	{
		// Configuration de la fenêtre racine de l'application
		primaryStage.setTitle("Hotel Réservation");
		FXMLLoader loader = this.getLoader(this.rootFXML);
		root = null;

		try
		{
			root = (BorderPane) loader.load();

		} catch (IOException e)
		{
			System.out.println(e.getStackTrace());
			System.err
					.println("Le fichier " + rootFXML + " n'a pas été trouvé");
		}
		
		RootController rootController = loader.getController();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		// Configuration de la vue générale de l'application
		loader = getLoader(this.generalViewFXML);
		generalViewPane = null;

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
		generalVueController.setMain(this);

		
		
		// Injection des services
		generalVueController.setRoomService(RoomService
				.getInstance());
		generalVueController.setClientService(ClientService.getInstance());
		
		rootController.setConnectionService(ConnectionService.getInstance());

		SteveServicesWebProxy proxy = new SteveServicesWebProxy();
		RoomService.getInstance().setWebService( proxy.getSteveServicesWeb());
	
		
		// Enregistre observateurs au service de connection
		ConnectionService.getInstance().addObserver(generalVueController);
	}
	
	public void showGeneralVue()
	{
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

	public static void main(String[] args)
	{
		launch(args);
	}
}
