package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.Database;
import entities.Bien;
import entities.Client;
import entities.Location;

import java.awt.FlowLayout;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class AjouterLocation extends JFrame {
	
	private DefaultListModel<Client> clientListModel;
    private DefaultListModel<Bien> bienListModel;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	
	public AjouterLocation(JPanel mainPanel,Database db,LocationPage allLocation) {

		setBounds(150, 10, 1000, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		// Creating client list and model
        clientListModel = new DefaultListModel<Client>();
        for (Client client : db.getClients()) {
            clientListModel.addElement(client); // Assuming getName() returns client names
        }
        

        // Creating bien list and model
        bienListModel = new DefaultListModel<Bien>();
        List<Bien> bienNotInLocation = db.getBiens().stream()
                .filter(bien -> !bien.isEnLocation())
                .collect(Collectors.toList());
        for (Bien bien : bienNotInLocation) {
        	bienListModel.addElement(bien);
	}
        
        
        
        JList<Client> clientList = new JList<>(clientListModel);
        JList<Bien> bienList = new JList<>(bienListModel);
	
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1,2));
		
		JButton createLocationButton = new JButton("Créer Location");
        createLocationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client selectedClient = clientList.getSelectedValue();
                Bien selectedBien = bienList.getSelectedValue();
              
                if (selectedClient != null && selectedBien != null) {
                	  String dateString = JOptionPane.showInputDialog(null, "Enter Starting Date (yyyy-MM-dd):");
                	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                      java.util.Date startingDate = null;
                      try {
                          startingDate = dateFormat.parse(dateString);
                      } catch (Exception ex) {
                          // Handle parsing exception
                          ex.printStackTrace();
                      }

                      if (startingDate != null) {
                          Location newLocation= new Location(selectedClient,selectedBien,startingDate);
                          selectedBien.setEnLocation(true);
                          selectedBien.setDateDebutLocation(startingDate);
                          db.getLocations().add(0, newLocation);
                          mainPanel.removeAll();
                          allLocation.loadData();
                          mainPanel.revalidate();
                          mainPanel.repaint();
                          JOptionPane.showMessageDialog(null, "Location a été créé avec succès!");
                          
                      } else {
                          JOptionPane.showMessageDialog(null, "Invalid Date Format!");
                      }
                	
                	
                	
                    //Location location = new Location(selectedClient, selectedBien);
                    System.out.println(selectedClient +" "+ selectedBien );
                    // Perform actions with created Location object
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner à la fois un client et un bien.");
                }
            }
        });
        
		getContentPane().add(createLocationButton, BorderLayout.SOUTH);


		
        
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new MigLayout("", "[][]", "[][][][][][][]"));
        
        JLabel lblNewLabel = new JLabel("Sélectionner un client");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_3.add(lblNewLabel, "cell 0 1");
        
        JScrollPane scrollPaneClient = new JScrollPane(clientList);
        scrollPaneClient.setPreferredSize(new Dimension(400, 300));
        panel_3.add(scrollPaneClient, "cell 1 1,grow");
        
        JButton btnNewButton_3 = new JButton("Détails Client");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Client selectedClient = clientList.getSelectedValue();
        	      if (selectedClient != null) {
        	    	  ClientInfo infoPage= new ClientInfo(selectedClient);
        				infoPage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client.");
                }
        		
        	}
        });
        
        panel_3.add(btnNewButton_3, "cell 1 4,growx");
        
        JButton btnNewButton_4 = new JButton("Ajouter un nouveau client");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openClientEntryFrame(db);
        	}
        });
        panel_3.add(btnNewButton_4, "cell 1 6,growx");
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new MigLayout("", "[][]", "[][][][][][][]"));
        
        JLabel lblNewLabel_1 = new JLabel("Sélectionner un bien");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_4.add(lblNewLabel_1, "cell 0 1");
        JScrollPane scrollPaneBien = new JScrollPane(bienList);
        scrollPaneBien.setPreferredSize(new Dimension(400, 300));
        panel_4.add(scrollPaneBien, "cell 1 1,grow");
        
        JButton btnNewButton_5 = new JButton("Détails bien");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Bien selectedbien = bienList.getSelectedValue();
        	      if (selectedbien != null) {
        	    	  BienInfo infoPage= new BienInfo(selectedbien);
        				infoPage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un bien.");
                }
        		
        	}
        });
        panel_4.add(btnNewButton_5, "cell 1 4,growx");
        
        JButton btnNewButton_6 = new JButton("Ajouter un nouveau bien");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openBienEntryFrame(db);
        	}

			
        });
        panel_4.add(btnNewButton_6, "cell 1 6,growx");
        
      
       

}
	
    public void updateClientList(Client client) {
    	clientListModel.addElement(client);
    }
    
    public void updateBienList(Bien bien) {
    	bienListModel.addElement(bien);
    }
    
    private void openBienEntryFrame(Database db) {
		// TODO Auto-generated method stub
    	
        String[] bienTypes = { "Appartement", "Maison", "Garage" };
        String selectedType = (String) JOptionPane.showInputDialog(
        		null,
                "Sélectionnez le type de bien:",
                "Choisir le type de Bien",
                JOptionPane.QUESTION_MESSAGE,
                null,
                bienTypes,
                bienTypes[0]);

        if (selectedType != null) {
        	ajouterBien(selectedType,db);
        }
		
	}
    
	  private void ajouterBien(String selectedType,Database db) {
		   

	        // Customize the new frame based on the selected type
	        switch (selectedType) {
	            case "Appartement":
	                
	            	AjouterBien ajouterApp = new AjouterBien(null,db,null,"Appartement",this);
	            	ajouterApp.setVisible(true);
	            	
	                break;

	            case "Maison":
	                AjouterBien ajouterMai = new AjouterBien(null,db,null,"Maison",this);
	                ajouterMai.setVisible(true);
	                break;

	            case "Garage":
	            	AjouterBien ajouterGar = new AjouterBien(null,db,null,"Garage",this);
	            	ajouterGar.setVisible(true);
	                break;

	            default:
	                break;
	        }
	    }
    
    private void openClientEntryFrame(Database db) {
        // Create and display Client Entry Frame
    	AjouterClient ajouterClient = new AjouterClient(null,db,null,this);
    	ajouterClient.setVisible(true);
    }
	
}
