/**
 * ReservationDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package reservation.dto;

public class ReservationDTO {
	private String arrivee;

	private ClientDTO ClientDTO;

	private String creation = "";

	private String depart = "";

	private ChambreDTO chambreDTODB = new ChambreDTODB();

	// Evite que ca passe a 0
	private int idReservation = 0;

	public ReservationDTO() {
	}

	public ReservationDTO(String arrivee, ClientDTO clientDTO, String creation,
			String depart, ChambreDTODB idChambre, int idReservation) {
		this.arrivee = arrivee;
		this.ClientDTO = clientDTO;
		this.creation = creation;
		this.depart = depart;
		this.chambreDTODB = idChambre;
		this.idReservation = idReservation;
	}

	/**
	 * Gets the arrivee value for this ReservationDTO.
	 * 
	 * @return arrivee
	 */
	public String getArrivee() {
		return arrivee;
	}

	/**
	 * Sets the arrivee value for this ReservationDTO.
	 * 
	 * @param arrivee
	 */
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	/**
	 * Gets the clientDTO value for this ReservationDTO.
	 * 
	 * @return clientDTO
	 */
	public ClientDTO getClientDTO() {
		return ClientDTO;
	}

	/**
	 * Sets the clientDTO value for this ReservationDTO.
	 * 
	 * @param clientDTO
	 */
	public void setClientDTO(ClientDTO clientDTO) {
		this.ClientDTO = clientDTO;
	}

	/**
	 * Gets the creation value for this ReservationDTO.
	 * 
	 * @return creation
	 */
	public String getCreation() {
		return creation;
	}

	/**
	 * Sets the creation value for this ReservationDTO.
	 * 
	 * @param creation
	 */
	public void setCreation(String creation) {
		this.creation = creation;
	}

	/**
	 * Gets the depart value for this ReservationDTO.
	 * 
	 * @return depart
	 */
	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public ChambreDTO getChambreDTO() {
		return chambreDTODB;
	}

	public void setChambreDTO(ChambreDTO idChambre) {
		this.chambreDTODB = idChambre;
	}

	/**
	 * Gets the idReservation value for this ReservationDTO.
	 * 
	 * @return idReservation
	 */
	public int getIdReservation() {
		return idReservation;
	}

	/**
	 * Sets the idReservation value for this ReservationDTO.
	 * 
	 * @param idReservation
	 */
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

}
