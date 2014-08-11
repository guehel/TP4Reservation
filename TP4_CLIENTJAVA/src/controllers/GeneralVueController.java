package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import services.ClientService;
import services.RoomService;
import application.Main;
import entities.Client;
import entities.Reservation;
import entities.Room;
import entities.RoomForm;
import eu.schudt.javafx.controls.calendar.DatePicker;

/**
 * Controlleur de la vue principale de l'application
 * 
 * @author Steve Boisvert
 * 
 */
public class GeneralVueController implements Observer
{
	private RoomService				roomService;
	private ClientService			clientService;

	private Main					main;
	private Stage					primaryStage;

	private long					userId;
	private List<Room>				roomIndex;
	private Room					selectedRoom;
	private Reservation				selectedReservation;

	@FXML
	private ListView<String>		roomList;
	@FXML
	private Label					roomNumberLabel, roomNumberField;
	@FXML
	private TableView<Reservation>	reservationTable;
	@FXML
	private TableColumn<Reservation, String>	dateColumn, clientNameColumn;
	@FXML
	private Button								deleteReservationBtn,
			addReservationBtn;

	/**
	 * Mutateur de la scène principale.
	 * 
	 * @param primaryStage
	 *            , la scène principale.
	 */
	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	/**
	 * Mutateur de la classe principale de l'application.
	 * 
	 * @param main
	 *            , la classe principal de l'application.
	 */
	public void setMain(Main main)
	{
		this.main = main;
	}

	/**
	 * Mutateur du service de chambres.
	 * 
	 * @param roomService
	 *            , le service de chambres.
	 */
	public void setRoomService(RoomService roomService)
	{
		this.roomService = roomService;
	}

	/**
	 * Mutateur du service de clients.
	 * 
	 * @param clientService
	 *            , le service de clients.
	 */
	public void setClientService(ClientService clientService)
	{
		this.clientService = clientService;
	}

	/**
	 * Initialisation de la vue principale.
	 */
	private void initGeneralVue()
	{
		roomIndex = roomService.query();
		List<String> listStringified = new ArrayList<String>();

		for (Room room : roomIndex)
		{
			listStringified.add(String.valueOf(room.getId()));
		}

		ObservableList<String> items = FXCollections
				.observableList(listStringified);

		roomList.setItems(items);
		showRoomDetail(null);
		setReservationTable();
		this.deleteReservationBtn.setDisable(true);
		this.addReservationBtn.setDisable(true);
		main.showGeneralVue();
	}

	/**
	 * Initialisation de la table des réservations.
	 */
	private void setReservationTable()
	{
		dateColumn
				.setCellValueFactory(new Callback<CellDataFeatures<Reservation, String>, ObservableValue<String>>()
				{
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Reservation, String> data)
					{
						return data.getValue().getReservationTimeProperty();
					}
				});

		// S'assure que la colomne des dates prend la moitié de la largeur de la
		// table.
		dateColumn.prefWidthProperty().bind(
				reservationTable.widthProperty().divide(2));

		clientNameColumn
				.setCellValueFactory(new Callback<CellDataFeatures<Reservation, String>, ObservableValue<String>>()
				{
					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Reservation, String> data)
					{
						return data.getValue().getClient().getNomProperty();
					}
				});
	}

	/**
	 * Gère la sélection d'une chambre dans la liste
	 */
	@FXML
	private void handleRoomSelection()
	{

		if (roomList.getSelectionModel().getSelectedIndex() != -1)
		{
			this.deleteReservationBtn.setDisable(true);
			this.addReservationBtn.setDisable(false);
			this.roomNumberLabel.setVisible(true);
			this.selectedReservation = null;

			Room selectedRoom = roomIndex.get(roomList.getSelectionModel()
					.getSelectedIndex());

			if (this.selectedRoom != selectedRoom)
			{
				this.selectedRoom = selectedRoom;
				showRoomDetail(selectedRoom);
			}
		}

	}

	/**
	 * Gère la sélection d'une réservation.
	 */
	@FXML
	private void handleReservationSelection()
	{

		Reservation selectedReservation = reservationTable.getSelectionModel()
				.getSelectedItem();

		if (this.selectedReservation != selectedReservation
				&& selectedReservation != null)
		{
			this.deleteReservationBtn.setDisable(false);
			this.selectedReservation = selectedReservation;
		}

	}

	/**
	 * Gère la supression d'une réservation.
	 */
	@FXML
	private void handleDeleteReservation()
	{
		RoomForm form = getRoomFrom(selectedRoom);
		form.setType(0);
		updateRoom(selectedRoom);
	}

	/**
	 * Gère l'ajout d'une réservation.
	 */
	@FXML
	public void handleAddReservation()
	{
		// Nouveau formulaire de réservation
		final Reservation newReservation = new Reservation();
		newReservation.setRoom(selectedRoom);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		ObservableList<Client> options = FXCollections
				.observableArrayList(clientService.query());

		final ComboBox<Client> clientList = new ComboBox<Client>(options);
		final DatePicker startDatePicker = new DatePicker(Locale.CANADA_FRENCH);
		final DatePicker endDatePicker = new DatePicker(Locale.CANADA_FRENCH);
		startDatePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		startDatePicker.getCalendarView().todayButtonTextProperty()
				.set("Today");
		startDatePicker.getCalendarView().setShowWeeks(false);
		endDatePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		endDatePicker.getCalendarView().todayButtonTextProperty().set("Today");
		endDatePicker.getCalendarView().setShowWeeks(false);

		grid.add(new Label("Client:"), 0, 0);
		grid.add(clientList, 1, 0);
		grid.add(new Label("Date d'arrivé:"), 0, 1);
		grid.add(startDatePicker, 1, 1);
		grid.add(new Label("Date d'arrivé:"), 0, 2);
		grid.add(endDatePicker, 2, 2);

		Callback myCallback = new Callback()
		{
			@Override
			public Object call(Object param)
			{
				newReservation.setClient(clientList.getValue());
				DateTime arrivalDate = new DateTime(
						startDatePicker.getSelectedDate());
				DateTime departureDate = new DateTime(
						endDatePicker.getSelectedDate());
				Interval stay = new Interval(arrivalDate, departureDate);
				newReservation.setReservationTime(stay);
				newReservation.setClient(clientList.getValue());
				return null;
			}

		};

		DialogResponse resp = Dialogs.showCustomDialog(primaryStage, grid,
				"Please log in", "Login", DialogOptions.OK_CANCEL, myCallback);

		// TODO: Besoin de valider si resp est bien rempli voir
		// http://code.makery.ch/blog/javafx-2-dialogs/

		RoomForm form = getRoomFrom(selectedRoom);
		selectedRoom.setFormulaire(form);
		form.setType(1);
		form.setReservation(newReservation);

		// TODO: gestion si la réservation n'est pas validée par le serveur.
		if (updateRoom(selectedRoom))
		{
			selectedRoom.addReservations(newReservation);
		}
	}

	/**
	 * Retourne le formulaire de la chambre envoyé en paramètre.
	 * 
	 * @param room
	 *            , la chambre.
	 * @return RoomForm, le formulaire de la chambre.
	 */
	private RoomForm getRoomFrom(Room room)
	{
		RoomForm form = room.getFormulaire();
		form.setIdUser((int) userId);
		return form;
	}

	/**
	 * Envois la chambre au service de chambre pour la mise-à-jour.
	 * 
	 * @param room
	 *            , la chambre à mettre-à-jour.
	 */
	private boolean updateRoom(Room room)
	{
		return roomService.submitForm(selectedRoom);
	}

	/**
	 * Montre les détails de la chambre.
	 * 
	 * @param room
	 *            , la chambre à afficher.
	 */
	private void showRoomDetail(Room room)
	{
		if (room != null)
		{
			roomNumberField.setText(String.valueOf(room.getId()));
			reservationTable.setItems(FXCollections.observableList(selectedRoom
					.getReservations()));

		} else
		{
			this.roomNumberLabel.setVisible(false);
			roomNumberField.setText("");
		}
	}

	/**
	 * Méthode appellé lors de la connection d'un utilisateur.
	 * 
	 * @param arg0
	 *            , le service d'authentification du client.
	 * @param arg1
	 *            , le id de l'utilisateur.
	 */
	@Override
	public void update(Observable arg0, Object arg1)
	{
		this.userId = (long) arg1;
		initGeneralVue();
	}
}