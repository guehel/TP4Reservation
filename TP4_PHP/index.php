<?php

/**
 * Classe qui s'occupe des redirections vers les controleurs
 */
class Router {
	private $requestedPath;
	private static $_instance = null;
	
	// singleton
	private function __construct() {
		$this->requestedPath = basename ( $_SERVER ['REQUEST_URI'], ".php" );
	}
	// methode qui instancie un singleton
	public static function getInstance() {
		if (is_null ( self::$_instance ))
			self::$_instance = new Router ();
		return self::$_instance;
	}
	public function direction() {
		
		// switch sur requested path;
		switch ($this->requestedPath) {
			
			case 'index' :
				$this->redirectAcceuil ();
				break;
			case 'reservation' :
				$this->redirectReservation ();
				break;
			case 'consulter-chambres' :
				$this->redirectListChambreDispo ();
				break;
			case 'annulation-client' :
				$this->redirectAnnulation ();
				break;
			case 'annulation' :
				$this->redirectListChambreClient ();
				break;
			default :
		}
	}
	public function redirectAcceuil() {
		// redirect
		new Controleurs_Acceuil ();
	}
	public function redirectReservation() {
		// redirect
		new Controleurs_Reservation ();
	}
	public function redirectListChambreDispo() {
		$params = array();
		$params ['dateArrivee'] = $_POST ['consulterChambres'] ['dateArrivee'];
		$params ['dateDepart'] = $_POST ['consulterChambres'] ['dateDepart'];
		// redirect
		new Controleurs_ConsulterChambres ( $params );
	}
	public function redirectListChambreClient() {
		$params = array();
		$params ['idUser'] = $_POST ['clientId'];
		// redirect
		new Controleurs_ConsulterChambres ( $params );
	}
	public function redirectConfirmation() {
		$params = array();
		$params ['dateArrivee'] = $_POST ['consulterChambres'] ['dateArrivee'];
		$params ['dateDepart'] = $_POST ['consulterChambres'] ['dateDepart'];
		$params ['idUser'] = $_POST ['clientId'];
		// redirect
		new Controleurs_Confirmation ( $params );
	}
	public function redirectAnnulation() {
		
		// redirect
		new Controleurs_Annulation ();
	}
}
function __autoload($class_name) {
	$nom_fichier = str_replace ( '_', DIRECTORY_SEPARATOR, strtolower ( $class_name ) ) . '.class.php';
	include_once $nom_fichier;
}

// Appel le singleton
$routeur = Router::getInstance ();
//  redirection
$routeur->direction ();
?>