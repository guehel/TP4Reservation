<?php

//include_once("modeles\get_clients.php");
//include_once("modeles\get_chambres.php");
//include_once("libs\get_functions.php");
//include_once("controleurs\ctrl_acceuil.php");



class Router{

	private $requestedPath;
	private static $_instance = null;

	// Singleton
	private function __construct(){	
		
		$this->requestedPath = basename($_SERVER['REQUEST_URI'], ".php");
	}

	public static function getInstance(){
		if(is_null(self::$_instance))
			self::$_instance = new Router();
		return self::$_instance;
	}

	public function direction(){
		//test tempo
		//print "RequestPath: ".$this->requestedPath;
		//print "taille : ". strlen($this->requestedPath);
		//switch sur requested path;
		switch ($this->requestedPath){

			case 'index':
			$this->redirectAcceuil();
			break;
			case 'reservation':
			$this->redirectReservation();
			break;
			case 'consulter-chambres':
			$this->redirectListChambreDispo();
			break;
			// case 'validation':
			// $this->redirectListChambreDispo();
			// break;
			case 'annulation-client':
			$this->redirectAnnulation();
			break;
			case 'annulation':
			$this->redirectListChambreClient();
			break;
			default:
		}


	}

	public function redirectAcceuil(){
		//redirect
		new Controleurs_Acceuil();

	}


	public function redirectReservation(){
		//redirect
		new Controleurs_Reservation();
	}


	public function redirectListChambreDispo(){
		$params['dateArrivee'] = $_POST['consulterChambres']['dateArrivee'];
		$params['dateDepart'] = $_POST['consulterChambres']['dateDepart'];
		//redirect
		new Controleurs_ConsulterChambres($params);
	}

	public function redirectListChambreClient(){
		$params['idUser'] = $_POST['clientId'];
		//redirect
		new Controleurs_ConsulterChambres($params);
	}


	public function redirectConfirmation(){
		$params['dateArrivee'] = $_POST['consulterChambres']['dateArrivee'];
		$params['dateDepart'] = $_POST['consulterChambres']['dateDepart'];		
		$params['idUser'] = $_POST['clientId'];
		//redirect
		new Controleurs_Confirmation($params);
	}



	public function redirectAnnulation()
	{

		//redirect
		new Controleurs_Annulation();
	}


}

function __autoload($class_name)
{
	$nom_fichier = str_replace('_', DIRECTORY_SEPARATOR, strtolower($class_name)).'.class.php';
	include_once $nom_fichier;
}

$routeur = Router::getInstance();
//print_r($routeur);
$routeur->direction();
 ?>