<?php
class Controleurs_Annulation{

	private $clientList;
	private $router;


	public function __construct(){

		$this->clientList = Modeles_Services_ClientService::getInstance()->query();
		$this->router = "/tp4_php/index.php/annulation";
		include("/vues/annulation.html");
	}

	public function getRouter() {
		return $this->router;
	}

	public function getListClient() {
		return $this->clientList;
	}
}
?>