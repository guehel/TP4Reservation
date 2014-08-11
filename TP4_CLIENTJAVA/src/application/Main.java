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

/**
 * Classe de lancement de l'application.
 * 
 * @author Steve Boisvert
 * 
 */
public class Main extends Application
{
	// Param�tres de base de l'application.
	private final String	ROOT_FXML			= "/vue/Root.fxml";
	private final String	GENERAL_VIEW_FXML	= "/vue/GeneralVue.fxml";
	private final String	APP_TITLE			= "H�tel R�servation";

	private BorderPane		root;
	private AnchorPane		generalViewPane;

	@Override
	public void start(Stage primaryStage)
	{
		// Configuration de la fen�tre racine de l'application
		primaryStage.setTitle(APP_TITLE);
		FXMLLoader loader = this.getLoader(this.ROOT_FXML);
		root = null;

		try
		{
			root = (BorderPane) loader.load();

		} catch (IOException e)
		{
			System.out.println(e.getStackTrace());
			System.err.println("Le fichier " + ROOT_FXML
					+ " n'a pas �t� trouv�");
		}

		RootController rootController = loader.getController();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		// Configuration de la vue g�n�rale de l'application
		loader = getLoader(this.GENERAL_VIEW_FXML);
		generalViewPane = null;

		try
		{
			generalViewPane = (AnchorPane) loader.load();

		} catch (IOException e)
		{
			System.err.println("Le fichier " + GENERAL_VIEW_FXML
					+ " n'a pas �t� trouv�");
		}
		GeneralVueController generalVueController = loader.getController();
		generalVueController.setPrimaryStage(primaryStage);
		generalVueController.setMain(this);

		// Injection des services
		generalVueController.setRoomService(RoomService.getInstance());
		generalVueController.setClientService(ClientService.getInstance());

		rootController.setConnectionService(ConnectionService.getInstance());

		SteveServicesWebProxy webServiceProxy = new SteveServicesWebProxy();
		RoomService.getInstance().setWebService(webServiceProxy);
		ClientService.getInstance().setWebService(webServiceProxy);

		// Enregistre observateurs au service de connection
		ConnectionService.getInstance().addObserver(generalVueController);
	}

	/**
	 * Permet d'afficher la vue g�n�rale
	 */
	public void showGeneralVue()
	{
		root.setCenter(generalViewPane);
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

	/**
	 * M�thode de lancement de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
}