<?php

class Modeles_Services_ClientService{

	private $webService;
	private $adaptor;
	private $clients = array();
	private static $instance;

	// singleton	
	private function __construct() {
		// $this->adaptor = new Modeles_Services_EntityAdapter();
		// $this->webService = new Modeles_Services_WebService();
	}

	public static function getInstance(){
		if(is_null(self::$instance)){
			self::$instance = new Modeles_Services_ClientService();
		}
		return self::$instance;
	}

	public function query(){
	// fait demande au webservice
	// emmagasine la liste de clients.
	// retourner une liste de clients

		$client1 = new Modeles_ClientDTO(1,"Antonio","Jackson");
		$client2 = new Modeles_ClientDTO(2,"Bouanga","Guehel");
		$client3 = new Modeles_ClientDTO(3,"Elkassir","Nawar");
		$client4 = new Modeles_ClientDTO(4,"Escobar","Pablo");

		array_push($this->clients,$client1);
		array_push($this->clients,$client2);
		array_push($this->clients,$client3);
		array_push($this->clients,$client4);

		return $this->clients;
	}

/*	public function query(){
		$listeClientServer = $this->webService->getListeClients();

		foreach ($listeClientServer as $clientServer) {
			$client = $this->adaptor->convertClientServer($clientServer);
			$reservationsServer = $this->webService->getReservationByClient($client->getId());

			foreach ($reservationsServer as $reservationServer) {
				$client->addReservation($this->adaptor->convertReservationServer($reservationServer));
			}
			$clients[$client->getId()] = $client;
		}

		return $this->clients;
	
	}*/



	public function get($id){
		$this->query();
		return $this->clients[$id];
	}
}
?>