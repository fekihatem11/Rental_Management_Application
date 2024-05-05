package entities;

public class Maison extends Bien {
	
    private int nombreEtages;
    private boolean avecJardin;
    private double surfaceParEtage;
    
    public Maison(String type, String adresse, double tarifMensuel,boolean enLocation, int nombreEtages, boolean avecJardin, double surfaceParEtage) {
  super(type, adresse, tarifMensuel, nombreEtages*surfaceParEtage , enLocation);
  this.nombreEtages = nombreEtages;
  this.avecJardin = avecJardin;
  this.surfaceParEtage = surfaceParEtage;
    }

	public int getNombreEtages() {
		return nombreEtages;
	}

	public void setNombreEtages(int nombreEtages) {
		this.nombreEtages = nombreEtages;
	}

	public boolean isAvecJardin() {
		return avecJardin;
	}

	public void setAvecJardin(boolean avecJardin) {
		this.avecJardin = avecJardin;
	}

	public double getSurfaceParEtage() {
		return surfaceParEtage;
	}

	public void setSurfaceParEtage(double surfaceParEtage) {
		this.surfaceParEtage = surfaceParEtage;
	}
    
    
    
    
    

}
