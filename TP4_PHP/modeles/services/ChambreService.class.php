<?php
/**
 * 	Classe qui assurent l'acc�s au mod�le de chambre.
 */
class Modeles_Services_ChambreService {
	private $webServices; // Modeles_Services_WebService
	private $adaptor; // Modeles_Services_EntityAdapter
	private $chambres = array ();
	private static $instance; // singleton
	
	private function __construct() {
		$this->adaptor = new Modeles_Services_EntityAdapter ();
		$this->webService = new Modeles_Services_WebService ();
	}
	// methode d'instanciation d'un singleton
	public static function getInstance() {
		if (is_null ( self::$instance )) {
			self::$instance = new Modeles_Services_ChambreService ();
		}
		return self::$instance;
	}
	
	// appel aux services pour une liste de chambres
	public function query() {
		// fait demande au webservice
		// emmagasine la liste de chambre.
		$listeChambres = $this->webService->getListeChambres ();
		
		foreach ( $listeChambres as $chambreServer ) {
			$chambre = $this->adaptor->convertChambreServer ( $chambreServer );
			$reservationsServer = $this->webService->getReservationByRoom ( $chambre->getId () );
			
			foreach ( $reservationsServer as $reservationServer ) {
				$chambre->addReservation ( $this->adaptor->convertReservationServer ( $reservationServer ) );
			}
			$chambres [$chambre->getId ()] = $chambre;
		}		
		// retourner une liste de chambres
		return $this->chambres;
	}
	
	// retourne la chambre correspondante � l'id
	public function get($id) {
		$this->query ();
		return $this->chambres [$id];
	}
	
	// retourne les r�servation de l'usager
	public function getByUserId($id) {
		$reservations = array ();
		$this->webServices = new Modeles_Services_WebService ();
		$reservationsServer = $webServices->getReservationParChambre ( $chambre->getId () );
		
		foreach ( $reservationsServer as $reservationServer ) {
			array_push ( $reservations, $this->adaptor->convertReservationServer ( $reservationServer ) );
		}
		return $reservations;
	}
	
	// retourne les chambres disponibles entre ces dates
	public function getByDates($dateArrivee, $dateDepart) {
		$this->query ();
		$chambresLibres = array ();
		$booEstLibre = true;
		$timeArriveeClient = strtotime ( $dateArrivee );
		$timeDepartClient = strtotime ( $dateDepart );
		
		// boucle dans chaque chambres
		for($i = 0; $i < count ( $this->chambres ) - 1; $i ++) {
			// boucle dans chaque r�servation
			foreach ( $this->chambres [$i]->getReservationsDTO () as $reservation ) {
				// Les temps de r�servation (time en sec depuis 1er janvier 1970)
				$timeArriveeReservation = strtotime ( $reservation->getArrivee () );
				$timeDepartReservation = strtotime ( $reservation->getDepart () );
				// avant la r�servation.
				$condition1 = $timeArriveeClient < $timeArriveeReservation && $timeDepartClient < $timeArriveeReservation;
				// apr�s la r�servation.
				$condition2 = $timeArriveeClient < $timeDepartReservation && $timeDepartClient < $timeDepartReservation;
				$booEstLibre &= ($condition1 && $condition2);
			}
			
			if ($booEstLibre) {
				array_push ( $chambresLibres, $this->chambres [$i] );
			}
		}
		// retourne la liste des chambres libres
		return $chambresLibres;
	}
	
	// retourne un formulaire au server contenant une r�servation
	public function soumettreFormulaire($formulaire) {
		return $this->webService->soumettreFormulaire ( $this->adaptor->convertFormulaire ( $formulaire ) );
	}
}
?>