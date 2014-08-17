<?php

class Controleurs_ConsulterChambres{

	private $texteButton;
	private $scriptValidation;
	private $chambres;
	private $dateArrivee;
	private $dateDepart;
	private $clients;
	private $clientId;

	public function __construct($params){
		$chambreSrv = Modeles_Services_ChambreService::getInstance();

		// si il y à eu de saise de client, donc mode annulation
		if(isset($params['idUser'])){
			$this->clientId = $params['idUser'];
			$this->texteButton = 'Annuler';
			$this->scriptValidation ='/tp4_php/modeles/scriptFormulaire/scriptAnnulation.php';
			$this->chambres = $chambreSrv->getByUserId($params['idUser']);
		}
		// sinon s'il n'y pas eu de saisie de client, donc pas mode annulation mais réservation
		// et que les champs de date ont été rempli.
		else if(!is_null($params['dateArrivee']) || !is_null($params['dateDepart'])){

			$this->clients = Modeles_Services_ClientService::getInstance()->query();
			$this->dateArrivee =$params['dateArrivee']; 
			$this->dateDepart = $params['dateDepart'];
			$this->texteButton = 'Reserver';
			$this->scriptValidation = '/tp4_php/modeles/scriptFormulaire/scriptReservation.php';
			$this->chambres = $chambreSrv->getByDates($this->dateArrivee, $this->dateDepart);
		}
		include("vues/chambres.html");
	}

	public function getTexteButton(){
		return $this->texteButton;
	}

	public function getScriptValidation(){
		return $this->scriptValidation;
	}

	public function getListeChambres(){
		return $this->chambres;
	}

	public function getDateArrivee(){
		return $this->dateArrivee;
	}

	public function getDateDepart(){
		return $this->dateDepart;
	}

	public function getListeClients(){
		return $this->clients;
	}

	public function getClientId(){
		return $this->clientId;
	}
}

?>