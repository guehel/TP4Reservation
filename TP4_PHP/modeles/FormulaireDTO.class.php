<?php
class FormulaireDTO {
	private $dateModification;
	private $idUser;
	private $reservation; // ReservationDTO
	private $type;
	public function __construct($idClient, $reservation, $type) {
		$this->idClient;
		$this->reservation; // ReservationDTO
		$this->type;
	}
}
?>