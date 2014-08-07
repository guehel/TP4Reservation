package controllers;

import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import services.entityService.EntityService;

public class GeneralVueController implements Observer
{
	private EntityService roomService;
	
	@FXML
	private ListView<String> roomList;
	
	@FXML
	private void initialize()
	{		
		
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		
	}
	
	public void setRoomService(EntityService roomService)
	{
		this.roomService = roomService;
	}
	
	@FXML
	public void submitForm()
	{
		System.out.println("Soumission formulaire");
	}
	
	@FXML
	public void ajoutReserve()
	{
		System.out.println("Ajout réservation");
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		System.out.println(arg1);
		
	}
	
}
