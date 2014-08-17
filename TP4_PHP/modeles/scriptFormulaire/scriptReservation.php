<?php

if(!is_null($_POST['chambreId'])){	
	$chambreId = $_POST['chambreId'];
}
if(!is_null($_POST['chambreId'])){	
	$dateArrive = $_POST['dateArrive'];
}
if(!is_null($_POST['chambreId'])){	
	$dateDepart = $_POST['dateArrive'];
}
if(!is_null($_POST['chambreId'])){	
	$clientId = $_POST['clientId'];
}

// appel d'un service pour modele de chambre
$chambreSrv = Modeles_Services_ChambreService::getInstance();
$chambre = $chambreSrv->get($chambreId);

// obtenir un formulaire de r�servation pour la chambre
$formulaire = $chambre->getFormulaire();
$formulaire->setType(1);
$chambre->setFormulaire($formulaire);

// ajouter une r�servation
$reservation = new Modeles_ReservationDTO();
$reservation->setArrivee($dateArrive);
$reservation->setDepart($dateDepart);

//ajouter clientDTo
$formulaire->setReservation($reservation);
// d�finir la r�servation

$reservation->setNumeroChambre($chambreId);
$reservation->setChambreDTO($chambre);
	
// soumettre le nouveau formulaire
$chambreSrv->submitForm($chambre)




?>