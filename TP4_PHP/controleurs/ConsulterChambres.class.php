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

		print "IS SET?: ".isset($params['idUser']);
					print "<pre> LISTE PARAMS ";
			print_r($params);
			print "</pre>";

		// si il y à eu de saise de client, donc mode annulation
		if(isset($params['idUser'])){
			// print "<pre> PARAMS IDUSER ";
			// print_r($params);
			// print "</pre>";
			$this->clientId = $params['idUser'];
			$this->texteButton = 'Annuler';
			$this->scriptValidation ='/tp4_php/modeles/scriptFormulaire/scriptAnnulation.php';
			$this->chambres = $chambreSrv->getByUserId($params['idUser']);
		}
		// sinon s'il n'y pas eu de saisie de client, donc pas mode annulation mais réservation
		// et que les champs de date ont été rempli.
		else if(!is_null($params['dateArrivee']) || !is_null($params['dateDepart'])){
			// print "<pre> PARAMS DATES ";
			// print_r($params);
			// print "</pre>";
			print "UserID is not set";

			$this->clients = Modeles_Services_ClientService::getInstance()->query();
			$this->dateArrivee =$params['dateArrivee']; 
			$this->dateDepart = $params['dateDepart'];
			$this->texteButton = 'Réserver';
			$this->scriptValidation = '/tp4_php/modeles/scriptFormulaire/scriptReservation.php';
			$this->chambres = $chambreSrv->getByDates($this->dateArrivee, $this->dateDepart);
			print "<pre> LISTE CHAMBRES ";
			print_r($this->chambres);
			print "</pre>";
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

	// 
	public function getDateArrivee(){
		return $this->dateArrivee;
	}

	// 
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