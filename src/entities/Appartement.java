package entities;

import java.util.Date;
 
public class Appartement extends Bien {
	
    private boolean meuble;
    private int nombreChambres;
    private int numeroEtage;
    private boolean balcon;
    
    
	public Appartement(String type, String adresse, double tarifMensuel, double surfaceTotale, boolean enLocation, boolean meuble, int nombreChambres,
			int numeroEtage,boolean balcon) {
		super(type, adresse, tarifMensuel, surfaceTotale, enLocation);
		this.meuble = meuble;
        this.nombreChambres = nombreChambres;
        this.numeroEtage = numeroEtage;
        this.balcon = balcon;
		
	}


	public boolean isMeuble() {
		return meuble;
	}


	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}


	public int getNombreChambres() {
		return nombreChambres;
	}


	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}


	public int getNumeroEtage() {
		return numeroEtage;
	}


	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}


	public boolean isBalcon() {
		return balcon;
	}


	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	
	
    
    
    
    
    

}
