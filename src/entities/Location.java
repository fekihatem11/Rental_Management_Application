package entities;

import java.util.Date;

public class Location {
	private static int idCounter = 0;
	private int id;
	private Client locataire;
	private Bien bien;
	private Date dateDebutLocation;
	
	public Location(Client locataire, Bien bien, Date dateDebutLocation) {
		this.id = idCounter++;
		this.locataire = locataire;
		this.bien = bien;
		this.dateDebutLocation = dateDebutLocation;
		this.bien.setDateDebutLocation(dateDebutLocation);
	}
	
	public int getId() {
		return id;
	}

	public Client getLocataire() {
		return locataire;
	}

	public void setLocataire(Client locataire) {
		this.locataire = locataire;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Date getDateDebutLocation() {
		return dateDebutLocation;
	}

	public void setDateDebutLocation(Date dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}
	
	
	
	
	
	
	

}
