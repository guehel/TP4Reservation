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

/*
$chambreSrv = Modeles_Services_ChambreService::getInstance();
$chambre = $chambreSrv->get($chambreId);

$formulaire = $chambre->getFormulaire();
$formulaire->setType(1);
$chambre->setFormulaire($formulaire);

$reservation = new Formulaire(); // ATTENTION CHANGER NOM !!!
$reservation->setArrivee($dateArrive);
$reservation->setDepart($dateDepart);

//ajout clientDTo
$formulaire->setReservation($reservation);

//$refChambreDTO = new ChambreDTO() /// CHANGER CICI!!!!
$refChambreDTO->setNumeroChambre($chambreId);
$reservation->setChambreDTO($refChambreDTO);

$chambreSrv->submitForm($chambre)
*/


// print'<pre> Script Reservation ';
// print_r($_POST);
// print'</pre>';


?>