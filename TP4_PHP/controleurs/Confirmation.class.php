<?php

 class Controleurs_Confirmation{
	
	private $chambres;
	private $dateArrivee;
	private $dateDepart;
	private $clientId;
	private $params = array();

	public function __construct(){
		$chambreSrv = Modeles_Services_ChambreService::getInstance();
		$clientSrv = Modeles_Services_ClientService::getInstance();
		$this->clients = $clientSrv->query();
		$this->dateArrivee =$params['dateArrivee']; 
		$this->dateDepart = $params['dateDepart'];
		$this->chambres = $chambreSrv->getByUserId($params['idUser']);
		$chambreSrv->enregistrerReservation($idClient, $idChambre, $dateArrivee, $dateDepart);
	
	include("vues/confirmation.html");
	}
}

?>