package reservation;

import java.util.Scanner;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

public class ApplicationLineDeCommande {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServicesWeb serviceWeb;
		serviceWeb = new ServicesWeb();
		System.out.println("Systeme de test du service web");
		int type= 0;
		char continuer = 'O';
		char reserver = 'N';

		do{
			do{
				System.out.println("Votre operation:\n \t Reserver : 1 \n \t Modification: 0\n \tquitter: 9");
				type = sc.nextInt();

				if(type!=9){
					ChambreDTO[] lChambreDTO;
					if(type==1){
						lChambreDTO = serviceWeb.obtenirListeChambre();
						for(ChambreDTO chambreDTO : lChambreDTO){
							affichicherChambre(chambreDTO);
						}
						do{
							System.out.println("Voulez vous reserver: O / N :");
							reserver  = sc.next().toUpperCase().charAt(0);
						}while(reserver!='O' && reserver!='N'  );
						if(reserver=='O'){
							Formulaire formulaire = null;
							ChambreDTO chambreSelectionne = null;
							char confirmerChoix = 'N';
							do {
								int numero = 0;
								do {
									System.out
											.println("Selectionner le numero de chambre:");
									numero = sc.nextInt();
								} while (numero <= 0
										|| numero > ServicesWeb.NOMBRE_DE_CHAMBRES);
								chambreSelectionne = lChambreDTO[numero - 1];
								formulaire = chambreSelectionne.getFormulaire();
								afficherChambre(chambreSelectionne);
								System.out.println("confirmer : O/N");
								confirmerChoix = sc.next().toUpperCase().charAt(0);
							} while(confirmerChoix!='O' && confirmerChoix!='N'  );
							if(confirmerChoix=='O'){
								do {
									formulaire.setType(type);
								
									String date =choisirMots("Saisir la date de depart sous la forme 2017-01-02", sc);
									formulaire.getReservation()
											.setArrivee(date);
								
									date =choisirMots("Saisir la date de depart sous la forme 2017-01-02", sc);
									formulaire.getReservation().setDepart(date);
									ClientDTO clientDTO = new ClientDTO();
									int id = choisirEntier("Saisir le num de client ", sc);
									clientDTO.setId(id);
									String nom = choisirMots("saisir le nom", sc);
									clientDTO.setNom(nom);
									String prenom = choisirMots("saisir le prenom", sc);
									clientDTO.setPrenom(prenom);
									formulaire.getReservation().setClientDTO(
											clientDTO);
									afficherFormulaire(formulaire);
									System.out.println("confirmer : O/N");
									confirmerChoix = sc.next().toUpperCase().charAt(0);
								} while (confirmerChoix!='O' && confirmerChoix!='N' );
								if(confirmerChoix=='O'){
									System.out.println(serviceWeb.update(chambreSelectionne)?
											"la sauvegarde a reussi":"echec");}
							}
							
						}
					}
					//cas de suppression
					else{
						ClientDTO[] lClients = serviceWeb.obtenirListeClients();
						afficherListeClients(lClients);
						String message="Choisisser le numero de client";
						int idClient = choisirEntier(message, sc);
						ClientDTO clientDTO = obtenirClient(idClient, lClients);
						ReservationDTO[] lreservationDTO = serviceWeb.obtenirReservations(idClient);
						for(ReservationDTO reseDTO: lreservationDTO){
							afficherReservation(reseDTO);
							
						}	
						message="Choisisser le numero de reservation";
						int numeroReservation = choisirEntier( message, sc);
						ReservationDTO reservationChosi = obtenirReservation(numeroReservation, lreservationDTO);
						reservationChosi.setClientDTO(clientDTO);
					
						Formulaire formulaire = new Formulaire();
						formulaire.setReservation(reservationChosi);
						formulaire.setType(type);
						ChambreDTO chambreSelectionne = new ChambreDTO();
						chambreSelectionne.setFormulaire(formulaire);
						System.out.println(serviceWeb.update(chambreSelectionne)?
								"la sauvegarde a reussi":"echec");
				
						
					}
				}
			}while(type!=9 && type!=0 && type!=1 );
			System.out.println("Voulez vous continuer: O / N :");
			continuer = sc.next().toUpperCase().charAt(0);
		}while(continuer!='N');
		System.out.println("Merci a Bientot");
		sc.close();
	}

	private static ReservationDTO obtenirReservation(int numeroReservation, ReservationDTO[] lreservationDTO) {
		
				ReservationDTO reservationDtO = null;
				for (ReservationDTO reserVT :lreservationDTO) {
					if (reservationDtO == reserVT) {
						reservationDtO = reserVT;break;
					}
				}
		return reservationDtO;
	}

	private static ClientDTO obtenirClient(int idClient, ClientDTO[] lClients) {
		
		ClientDTO ClientDTO = null;
		for(ClientDTO clt: lClients){
			if (clt.getId()==idClient) {
				ClientDTO = clt;
				break;
			}
		}
		return ClientDTO;
	}

	private static int choisirEntier(String message, Scanner sc) {
		System.out.println(message);
		int retour = -1;
		try{
			retour = sc.nextInt();
		}catch(NumberFormatException e){}
		return retour;
	}
	
	private static char choisirLettre(String message, Scanner sc) {
		System.out.println(message);
		char retour = 'Z';
	
			retour = sc.next().charAt(0);
			System.out.println(retour);
		return retour;
	}
	
	private static String choisirMots(String message, Scanner sc) {
		System.out.println(message);
		String retour = "";
	
			retour = sc.next();
			System.out.println(retour);
		return retour;
	}

	private static void afficherListeClients(ClientDTO[] lClients) {
		for(ClientDTO client: lClients){
			System.out.println("Client:");
			System.out.println("\tid: "+client.getId());
			System.out.println("\tNom: "+client.getNom());
			System.out.println("\tPrenom: "+client.getPrenom());
			
		}
		
	}

	public static void afficherFormulaire(Formulaire formulaire) {
		System.out.println("FORMULAIRE");
		System.out.println("\t"+formulaire.getDateModification());
		System.out.println("\t"+formulaire.getType());
		ReservationDTO resDTO= formulaire.getReservation();
		afficherReservation(resDTO);
		
	}

	public static void affichicherChambre(ChambreDTO chambreDTO) {
		System.out.println("chambre numero: "+ chambreDTO.getNumeroChambre());
		ReservationDTO[] reservations  = chambreDTO.getReservations();
		System.out.println("nombre de reservations: "+chambreDTO.getReservations().length);
		System.out.println("Date de modification formulaire"+chambreDTO.getFormulaire().getDateModification());
		for(ReservationDTO resDTO : reservations){
			afficherReservation(resDTO);
		}



	}

	public static void afficherReservation(ReservationDTO resDTO) {
		System.out.println("Reservation n : "+resDTO.getIdReservation());
		System.out.println("DATES : ");
		System.out.println("\tDebut : "+resDTO.getArrivee());
		System.out.println("\tDepart : "+resDTO.getDepart());
		System.out.println("\tDebut : "+resDTO.getArrivee());

		afficherClient(resDTO.getClientDTO());
		afficherChambre(resDTO.getChambreDTO());

	}

	public static void afficherChambre(ChambreDTO chambreDTO) {
		System.out.println("CHAMBRE : ");
		System.out.println("\tid Chambre : "+chambreDTO.getNumeroChambre());

	}

	public static void afficherClient(ClientDTO clientDTO) {
		System.out.println("CLIENT : ");
		System.out.println("\tid Client : "+clientDTO.getId());
		System.out.println("\tNom Client : "+clientDTO.getNom());
		System.out.println("\tPrenom Client : "+clientDTO.getPrenom());

	}

}
