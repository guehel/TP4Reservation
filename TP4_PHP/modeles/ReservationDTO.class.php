<?php

class Modeles_ReservationDTO {
  // private $idReservation;
  private $idChambre;
  private $idClient;
  private $arrivee;
  private $depart;
  private $creation;

  public function __construct($idChambre, $idClient, $arrivee, $depart){
  // $this->idReservation = $idReservation;
  $this->idChambre = $idChambre;
  $this->idClient = $idClient;
  $this->arrivee = $arrivee;
  $this->depart = $depart;
  $this->creation = true;
}

public function setIdReservation($id)
{
  $this->idReservation = $id;
}

public function getIdReservation()
{
  return $this->idReservation;
}

public function setIdChambre($id)
{
  $this->idChambre = $id;
}

public function getIdChambre()
{
  return $this->idChambre;
}

public function setArrivee($date)
{
  $this->arrivee = $date;
}

public function getArrivee()
{
  return $this->arrivee;
}

public function setDepart($date)
{
  $this->depart = $date;
}

public function getDepart()
{
  return $this->depart;
}
}

?>