<?php

class Modeles_ChambreDTO {
  private $id;
  private $formulaire;
  private $reservationsDTO;


  public function getId(){
    return $this->id;
  }

  public function setId($id)
  {
    $this->id=$id;
  }

public function getFormulaire(){
    return $this->formulaire;
  }

  public function setFormulaire($formulaire)
  {
    $this->formulaire=$formulaire;
  }

  public function getReservationsDTO(){
    return $this->reservationsDTO;
  }

  public function setReservationsDTO($reservationsDTO)
  {
    $this->reservationsDTO=$reservationsDTO;
  }



}
  ?>