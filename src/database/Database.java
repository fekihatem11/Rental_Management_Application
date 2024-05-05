package database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import entities.Appartement;
import entities.Bien;
import entities.Client;
import entities.Garage;
import entities.Location;
import entities.Maison;




public class Database {
	
	private ArrayList<Client> clients;
	private ArrayList<Bien> biens;
	private ArrayList<Location> locations;

	
	
	public Database() throws ParseException {
		
		//////////Clients
	    ArrayList<Client> clientData = new ArrayList<Client>();
	    Client client1=new Client("Baccouche","Sandra",24,"f,ekzlf,ekz","56456456");
	    client1.setImgUrl("/Client1.jpg");
	    Client client2=new Client("Feki","Hatem",25,"f,ekzlf,ekz","56456456");
	    client2.setImgUrl("/empty-profile.png");
	    Client client3=new Client("Feki","Aymen",25,"f,ekzlf,ekz","56456456");
	    client3.setImgUrl("/empty-profile.png");
	    Client client4=new Client("Almi","Malek",15,"f,ekzlf,ekz","56456456");
	    client4.setImgUrl("/empty-profile.png");
	    Client client5=new Client("Moula","Sarah",15,"f,ekzlf,ekz","56456456");
	    client5.setImgUrl("/empty-profile.png");
	    clientData.add(client1);
	    clientData.add(client2);
	    clientData.add(client3);
	    clientData.add(client4);
	    clientData.add(client5);
	    
	    ///////// Biens
	    ArrayList<Bien> bienData = new ArrayList<Bien>();
	    Bien bien1=new Appartement("Appartement", "15 rue Nasr 2", 850, 100 , false, true, 2, 2, true);
	    bien1.setImgUrl("/AppNL.jpg");
	  
	    Bien bien2=new Appartement("Appartement", "14 rue Marsa", 1000, 140 , true, false, 3, 2, true);
	    bien2.setImgUrl("/AppL.jpg");
	    
	    Bien bien3=new Maison("Maison", "15 rue Nasr 2", 2000, true, 2, false, 120);
	    bien3.setImgUrl("/MaiL.jpg");
	    
	    Bien bien4=new Maison("Maison", "15 rue Marsa", 2500, false, 2, false, 200);
	    bien4.setImgUrl("/MaiNL.jpg");
	    
	    Bien bien5=new Garage("Garage", "Bardo 2", 500, 60, true, 2);
	    bien5.setImgUrl("/GarL.jpg");
	    
	    Bien bien6=new Garage("Garage", "Bardo 3", 500, 60, false, 2);
	    bien6.setImgUrl("/GarNL.jpg");
	    
	    bienData.add(bien1);
	    bienData.add(bien2);
	    bienData.add(bien3);
	    bienData.add(bien4);
	    bienData.add(bien5);
	    bienData.add(bien6);
	    
	    ///////////////Locations
	    ArrayList<Location> locationData = new ArrayList<Location>();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    
	    Location location1=new Location(client1, bien2, dateFormat.parse("2023-12-27"));
	    Location location2=new Location(client3, bien3, dateFormat.parse("2022-12-01"));
	    Location location3=new Location(client5, bien5, dateFormat.parse("2020-12-15"));
	    locationData.add(location1);
	    locationData.add(location2);
	    locationData.add(location3);
	    
	    this.locations=locationData;
		this.clients = clientData;
		this.biens= bienData;
	}
	
    public void deleteClient(Client clientToDelete) {
        clients.remove(clientToDelete);
    }
    
    
	
    public void deleteBien(Bien bienToDelete) {
        biens.remove(bienToDelete);
    }
    
	
    public void deleteLocation(Location locationToDelete) {
    	locations.remove(locationToDelete);
    }
    
    
    public void deleteLocationByBien(Bien bienToDelete) {
        Iterator<Location> iterator = locations.iterator();
        while (iterator.hasNext()) {
            Location location = iterator.next();
            if (location.getBien().getId()==bienToDelete.getId()) {
                iterator.remove(); 
            }
        }
    }
	
	


	public ArrayList<Client> getClients() {
		return clients;
	}


	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}


	public ArrayList<Bien> getBiens() {
		return biens;
	}


	public void setBiens(ArrayList<Bien> biens) {
		this.biens = biens;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
	
	
	public void clientSortByNom() {
	    clients.sort(Comparator.comparing(Client::getNom));
	}
	
	public void clientSortByPrenom() {
	    clients.sort(Comparator.comparing(Client::getPrenom));
	}
	
	public void clientSortById() {
	    clients.sort(Comparator.comparingInt(Client::getId));
	}
	
	
	
	
		

}
