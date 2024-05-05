package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import database.Database;
import entities.Bien;
import entities.Client;
import entities.Garage;
import entities.Maison;
import entities.Appartement;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BienPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Bien bien;
	
	public BienPanel(JPanel mainPanel,Bien bienParam,Database db,HomePage allBien) {
		
		bien=bienParam;
	    Border whiteBorder = BorderFactory.createLineBorder(Color.white, 4);
	    setBorder(whiteBorder);
		setLayout(new BorderLayout());
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 450));
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("gap 5px 30px", "[][][][][][200.00][]", "[][][][][][][][][][]"));
		
		JLabel lblType = new JLabel("Type: "+bien.getType()+" ("+bien.getId()+")" );
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblType, "cell 0 1");
		

		
		JLabel lblAdresse = new JLabel("Adresse: "+ bien.getAdresse());
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblAdresse, "cell 0 3,alignx left");
		

		
		JLabel lblTarifMensuel = new JLabel("Tarif Mensuel: " + bien.getTarifMensuel()+" "+ "$" );
		lblTarifMensuel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblTarifMensuel, "cell 0 5");
		

		
		JLabel lblSurfaceTotale = new JLabel("Surface Totale: "+ bien.getSurfaceTotale()+ " "+ "mètres carrés");
		lblSurfaceTotale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblSurfaceTotale, "cell 0 7");
		
		
	
		
		
		JButton btnSupp = new JButton("Supprimer");
		panel_1.add(btnSupp, "cell 10 7, width 30px,alignx left,aligny top");
		btnSupp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		btnSupp.addActionListener(e -> {
	        int dialogResult = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ??", "Confirmation", JOptionPane.YES_NO_OPTION);
	        
	        if (dialogResult == JOptionPane.YES_OPTION) {
				db.deleteBien(bien);
				db.deleteLocationByBien(bien);
	            mainPanel.remove(this);
	            mainPanel.revalidate();
	            mainPanel.repaint();
	        } else {
	            System.out.println("Cancelled");
	        }

        });
		
	
		JButton btnEdit = new JButton("Modifier");
		panel_1.add(btnEdit, "cell 10 5, width 30px, alignx center,aligny top");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.addActionListener(e->{
			EditBienInfo editPage= new EditBienInfo(bien,mainPanel,this,allBien);
			editPage.setVisible(true);
		}
		);
		

		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblBienImg = new JLabel("");
		panel.add(lblBienImg);
		
		JLabel lblStatusImg = new JLabel("");
		panel.add(lblStatusImg);
		
		try {
			
			URL bienImgg = getClass().getResource(bien.getImgUrl());
			BufferedImage originalImage = ImageIO.read(bienImgg);
			// Resize the image
			int width = 300; // Desired width of the image in the JLabel
			int height = 300; // Set to -1 to keep aspect ratio
			Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaledImage);
			
			URL LOrNL;
			if (bien.isEnLocation()) {
				
				LOrNL= getClass().getResource("/LOUER.png");
				
			} else {
				
				LOrNL= getClass().getResource("/ALOUER.png");

			}
			
		
			BufferedImage originalImage2 = ImageIO.read(LOrNL);
			// Resize the image
			int width1 = 300; // Desired width of the image in the JLabel
			int height1 = 100; // Set to -1 to keep aspect ratio
			Image scaledImage1 = originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
			ImageIcon icon1 = new ImageIcon(scaledImage1);

			lblBienImg.setIcon(icon);
			lblStatusImg.setIcon(icon1);

		} catch (IOException e) {
			e.printStackTrace(); // Handle image loading exception
		}
		
		
		String type = bien.getType(); // Your expression

		switch (type) {
		    case "Appartement":
		    	
		    	String meuble= (((Appartement) bien).isMeuble())? "Meublé": "Non meublé" ;
				JLabel lblmeuble = new JLabel(meuble);
				lblmeuble.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblmeuble, "cell 2 1");
		        
				JLabel lblNChambres = new JLabel("Nombre de chambres: " + ((Appartement) bien).getNombreChambres() );
				lblNChambres.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblNChambres, "cell 2 3,,alignx left");
				
				String balcon= (((Appartement) bien).isBalcon())? "Avec balcon": "Sans balcon" ;
				JLabel lblBalcon = new JLabel(balcon);
				lblBalcon.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblBalcon, "cell 3 1");
				
				
				
				
				JLabel lblNumEtage = new JLabel("Numéro d'étage: "+((Appartement) bien).getNumeroEtage());
				lblNumEtage.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblNumEtage, "cell 2 5");
		    	
		    	
		        break; // Optional: exits the switch statement

		    case "Maison":
		    	
		    	String jardin= (((Maison) bien).isAvecJardin())? "Avec jardin": "Sans jardin" ;
				JLabel lbljardin = new JLabel(jardin);
				lbljardin.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lbljardin, "cell 2 1");
		        
				JLabel lblNEtages = new JLabel("Nombre d'etages: " + ((Maison) bien).getNombreEtages() );
				lblNEtages.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblNEtages, "cell 2 3,,alignx left");
			
				
				JLabel lblSurEtage = new JLabel("Surface par étage: "+((Maison) bien).getSurfaceParEtage()+ " "+ "mètres carrés");
				lblSurEtage.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblSurEtage, "cell 2 5");
		    	
		        break;

		    case "Garage":
		    	
				JLabel lblNEmpl = new JLabel("Nombre d'emplacements: " + ((Garage) bien).getNumeroEmplacement() );
				lblNEmpl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_1.add(lblNEmpl, "cell 2 1,,alignx left");
		        
		        break;

		    // Add more cases as needed

		    default:
		        // Code to be executed if variable doesn't match any case
		        break;
		}
		
		if (bien.getDateDebutLocation()!=null) {
			JLabel lblDateLocation = new JLabel("Date début: "+ new SimpleDateFormat("yyyy-MM-dd").format(bien.getDateDebutLocation()));
			lblDateLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panel_1.add(lblDateLocation, "cell 10 1");
			
		}
		
	}

}
