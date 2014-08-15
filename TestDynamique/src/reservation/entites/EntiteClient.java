package reservation.entites;


import reservation.dto.ClientDTO;
import reservation.objects.Client;

public class EntiteClient extends Entite{
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EntiteClient(Client client) {
		super();
		this.client = client;
	}

	public EntiteClient() {
		super();

	}
	public void setClientFromDTO(ClientDTO clientDTO) throws Exception{
		client.setIdClient(clientDTO.getId());
		client.setNom(clientDTO.getNom());
		client.setPrenom(clientDTO.getPrenom());
	}
	public ClientDTO getClientDTO() {
		ClientDTO clientDTO =null;
		if (client!=null) {
			clientDTO = new ClientDTO();
			clientDTO.setId(client.getIdClient());
			clientDTO.setNom(client.getNom());
			clientDTO.setPrenom(client.getPrenom());
		}
		return clientDTO;
	}

}
