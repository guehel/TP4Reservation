<?php
/**
 * 	Classe qui assurent l'accès au modèle de client.
 */
class Modeles_Services_ClientService{

	private $webService;
	private $adaptor;
	private $clients = array();
	private static $instance;	// singleton	
	
	private function __construct() {
		$this->adaptor = new Modeles_Services_EntityAdapter();
		$this->webService = new Modeles_Services_WebService();
	}
	// methode d'instanciation d'un singleton
	public static function getInstance(){
		if(is_null(self::$instance)){
			self::$instance = new Modeles_Services_ClientService();
		}
		return self::$instance;
	}

	public function query(){
 	// fait demande au webservice
	// emmagasine la liste de clients.
		$listeClientServer = $this->webService->getListeClients();

		foreach ($listeClientServer as $clientServer) {
			$client = $this->adaptor->convertClientServer($clientServer);
			$reservationsServer = $this->webService->getReservationByClient($client->getId());

			foreach ($reservationsServer as $reservationServer) {
				$client->addReservation($this->adaptor->convertReservationServer($reservationServer));
			}
			$this->clients[$client->getId()] = $client;
		}
		// retourner une liste de clients
		return $this->clients;
	
	}

	public function get($id){
		$this->query();
		return $this->clients[$id];
	}
}
?>