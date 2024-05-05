package entities;

public class Garage extends Bien {
	
   
    private int numeroEmplacement;
	public Garage(String type, String adresse, double tarifMensuel, double surfaceTotale, boolean enLocation,
			 int numeroEmplacement) {
		super(type, adresse, tarifMensuel, surfaceTotale, enLocation);
		
		this.numeroEmplacement = numeroEmplacement;
	}
	public int getNumeroEmplacement() {
		return numeroEmplacement;
	}
	public void setNumeroEmplacement(int numeroEmplacement) {
		this.numeroEmplacement = numeroEmplacement;
	}
	
	
	
    
    

}
