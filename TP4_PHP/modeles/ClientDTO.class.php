<?php

class Modeles_ClientDTO  {
  private $id =0;
  private $nom= "";
  private $prenom = "";
  //private ReservationDTO $reservation;

  public function __construct($id, $nom, $prenom){
  $this->id = $id;
  $this->nom = $nom;
  $this->prenom = $prenom;
  //$this->reservation = $reservation;
}

public function getId(){
  return $this->id;
}

public function setId($id)
{
  $this->id=$id;
}

public function getNom(){
  return $this->nom;
}

public function setNom($nom)
{
  $this->nom=$nom;
}

public function getPrenom(){
  return $this->prenom;
}

public function setPrenom($prenom)
{
  $this->prenom=$prenom;
}

public function getReservationDTO(){
  return $this->reservation;
}

public function setReservationDTO($reservation)
{
  $this->reservation=$reservation;
}

 public function __toString()
    {
        return $this->prenom . " " . $this->nom;
    }
  }

?>