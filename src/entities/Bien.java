package entities;

import java.util.Date;

public class Bien {
	private static int idCounter = 0;
	private int id;
    private String reference;
    private String type;
    private String adresse;
    private String imgUrl;
    private double tarifMensuel;
    private double surfaceTotale;
    private boolean enLocation; 
    private Date dateDebutLocation;
    
	public Bien(String type, String adresse, double tarifMensuel, double surfaceTotale, boolean enLocation) {
		
	
		this.id = idCounter++;
		
		this.type=type;
		this.adresse = adresse;
		this.tarifMensuel = tarifMensuel;
		this.surfaceTotale = surfaceTotale;
		this.enLocation = enLocation;
		//this.dateDebutLocation = dateDebutLocation;
	}
	
	
	
	
	
	
	public Date getDateDebutLocation() {
		return dateDebutLocation;
	}






	public void setDateDebutLocation(Date dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}






	@Override
	public String toString() {
	    return " ("+ type+ " "+ id+ ") Adresse: " + adresse ;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Bien.idCounter = idCounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getTarifMensuel() {
		return tarifMensuel;
	}

	public void setTarifMensuel(double tarifMensuel) {
		this.tarifMensuel = tarifMensuel;
	}

	public double getSurfaceTotale() {
		return surfaceTotale;
	}

	public void setSurfaceTotale(double surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public boolean isEnLocation() {
		return enLocation;
	}

	public void setEnLocation(boolean enLocation) {
		this.enLocation = enLocation;
	}



	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
    
    
    

}
