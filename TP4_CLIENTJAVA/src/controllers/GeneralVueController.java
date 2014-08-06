package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import services.QuerableEntity;
import services.ServiceInterface;
import Entities.Room;

public class GeneralVueController
{
	private ServiceInterface roomService;
	
	@FXML
	private ListView<String> roomList;
	
	@FXML
	private void initialize()
	{		
		ObservableList<String> items = FXCollections.observableArrayList();
		
		List<QuerableEntity> list = roomService.query();
		for(QuerableEntity entity : list)
		{
			Room room = (Room) entity;
			items.add(String.valueOf(room.getId()));
		}

		roomList.setItems(items);
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		
	}
	
	public void setRoomService(ServiceInterface roomService)
	{
		this.roomService = roomService;
	}
	
}
