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
		$this->dateArrivee =$this->params['dateArrivee']; 
		$this->dateDepart = $this->params['dateDepart'];
		$this->chambres = $chambreSrv->getByUserId($this->params['idUser']);
		$chambreSrv->enregistrerReservation($this->clients, $this->chambres, $this->dateArrivee, $this->dateDepart);
	
	include("vues/confirmation.html");
	}
}

?>