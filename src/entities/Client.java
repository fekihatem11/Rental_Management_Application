package entities;

public class Client {
	private static int idCounter = 0;
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	private String numero;
	private String imgUrl;
	
	public Client(String nom, String prenom, int age, String adresse, String numero) {
		this.id = idCounter++;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
	    return " (ID:" + id + ") " + prenom +" "+ nom;
	}

	public static int getIdCounter() {
		return idCounter;
	}
	

	public int getId() {
		return id;
	}
	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
	

}
