<?php

class Modeles_Services_ChambreService{

	private $webServices;	// Modeles_Services_WebService
	private $adaptor;	// Modeles_Services_EntityAdapter
	private $chambres = array();
	private static $instance;	// Singleton

	private function __construct() {
		// $this->adaptor = new Modeles_Services_EntityAdapter();
		// $this->webService = new Modeles_Services_WebService();
	}


	public static function getInstance() {
		if(is_null(self::$instance)){
			self::$instance = new Modeles_Services_ChambreService();
		}
		return self::$instance;
	}


	public function query(){

		// return $this->webService->getListeChambres();


	// fait demande au webservice
	// emmagasine la liste de chambre.
	// retourner une liste de chambres

		$chambre1 = new Modeles_ChambreDTO();
		$chambre1->setId(1);
		$chambre2 = new Modeles_ChambreDTO();
		$chambre2->setId(2);
		$chambre3 = new Modeles_ChambreDTO();
		$chambre3->setId(3);




			// création de valeurs dummy en attendant que services soient opérationnels
			//($idReservation, $idChambre, $idClient, $arrivee, $depart)
		$reservation1 = new Modeles_ReservationDTO(1, 1, 1, '2014-10-02', '2014-10-08');
		$reservation2 = new Modeles_ReservationDTO(2, 2, 2, '2014-10-10', '2014-10-18');
		$reservation3 = new Modeles_ReservationDTO(3, 2, 3, '2014-10-22', '2014-10-28');
		$reservation4 = new Modeles_ReservationDTO(4, 3, 1, '2014-10-02', '2014-10-08');
		$reservation5 = new Modeles_ReservationDTO(5, 3, 2, '2014-10-10', '2014-10-18');
		$reservation6 = new Modeles_ReservationDTO(6, 2, 3, '2014-10-22', '2014-10-28');
		$reservation7 = new Modeles_ReservationDTO(7, 1, 1, '2014-10-02', '2014-10-08');
		$reservation8 = new Modeles_ReservationDTO(8, 1, 2, '2014-10-10', '2014-10-18');
		$reservation9 = new Modeles_ReservationDTO(9, 4, 3, '2014-10-22', '2014-10-28');

			// reservationsDTO dummy
		$chambre1->setReservationsDTO(array($reservation1, $reservation2, $reservation3));
		$chambre2->setReservationsDTO(array($reservation4, $reservation5, $reservation6));
		$chambre3->setReservationsDTO(array($reservation7, $reservation8, $reservation9));

		array_push($this->chambres, $chambre1);
		array_push($this->chambres, $chambre2);
		array_push($this->chambres, $chambre3);

		return $this->chambres;
	}

/*	public function query() {
		$listeChambres = $this->webService->getListeChambres();

		foreach ($listeChambres as $chambreServer) {
			$chambre = $this->adaptor->convertChambreServer($chambreServer);
			$reservationsServer = $this->webService->getReservationByRoom($chambre->getId());

			foreach ($reservationsServer as $reservationServer) {
				$chambre->addReservation($this->adaptor->convertReservationServer($reservationServer));
			}
			$chambres[$chambre->getId()] = $chambre;
		}

		return $this->chambres;
	}
*/
	public function get($id) {
		$this->query();
		return $this->chambres[$id];
	}

	
	public function getById($id) {
		$reservations = array();

		$reservationsServer = $this->webServices->getReservationByChambre($chambre->getId());

		foreach ($reservationsServer as $reservationServer) {
			array_push($reservations, $this->adaptor->convertReservationServer($reservationServer));
		}
		return $reservations;
	}	
	

	public function getByDates($dateArrivee, $dateDepart) {
		$this->query();
		$chambresLibres = array();
		$timeArriveeClient = strtotime($dateArrivee);
		$timeDepartClient = strtotime($dateDepart);


			print "<pre> LISTE CHAMBRES ds ChambreService.class.php ";
			print_r($this->chambres);
			print "</pre>";

		// boucle dans chaque chambres
		for ($i = 0, $booEstLibre = true; $i < count($this->chambres)-1 || $booEstLibre; $i++) {
			// boucle dans chaque réservation
			foreach ($this->chambres[$i]->getReservationsDTO() as $reservation) {
				$timeArriveeReservation = strtotime($reservation->getArrivee());
				$timeDepartReservation = strtotime($reservation->getDepart());
				print "timeArriveeReservation:".$timeArriveeReservation;
				print "timeDepartReservation:".$timeDepartReservation;
				// avant la réservation.
				$condition1 = $timeArriveeClient < $timeArriveeReservation && $timeDepartClient < $timeArriveeReservation;
				// après la réservation.
				$condition2 = $timeArriveeClient < $timeDepartReservation && $timeDepartClient < $timeDepartReservation;
				$booEstLibre &= ($condition1 && $condition2);

			print "condition1: ".$condition1;
			print "condition2: ".$condition2;
			print "<br/>  i=". $i."/".(count($this->chambres)-1)."When ".!$booEstLibre."<br/>";
			}
			
			if($booEstLibre){
				array_push($chambresLibres, $this->chambres[$i]); 
			}
		}
			print "<pre> LISTE CHAMBRES LIBRES";
			print_r($chambresLibres);
			print "</pre>";
		return $chambresLibres;
	}

	public function soumettreFormulaire($formulaire) {
		return $this->webService->soumettreFormulaire($this->adaptor->convertFormulaire($formulaire));
	}
}
?>