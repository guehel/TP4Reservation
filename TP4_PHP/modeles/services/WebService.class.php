<?php

class Modeles_Services_WebService{

	private $client;

	public function __construct()
	{
		$this->client = new SoapClient("http://172.18.10.23:8080/TestDynamique/services/FacadeServiceWeb?wsdl");
	}

	public function getListeChambres(){
		return $this->client->obtenirListeChambre();
	}

	public function getReservationParChambre($chambreId) {
		$args = new stdClass();
		$args->obtenirReservationsRequest = $chambreId;
		return $this->client->obtenirListeChambre(900 + $chambreId);
	}

	public function soumettreFormulaire($formulaire) {
		$args = new stdClass();
		$args->updateRequest = $formulaire;
		return $this->client->update($args);
	}

	public function getListeClients() {
		return $this->client->obtenirListeClients();
	}

	public function getReservationByClient($clientId) {
		$args = new stdClass();
		$args->obtenirReservationsRequest = $clientId;
		return $this->client->obtenirListeChambre($args);
	}
}

?>
