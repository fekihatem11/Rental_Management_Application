package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Appartement;
import entities.Bien;
import entities.Client;
import entities.Garage;
import entities.Maison;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BienInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImg;



	/**
	 * Launch the application.
	 */
      
	/**
	 * Create the frame.
	 */
	public BienInfo(Bien bien) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 50, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("gapx 10px, gapy 20px", "[][150.00,grow,fill][][38.00][63.00][][63.00][][][][]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblType = new JLabel(bien.getType()+" ("+bien.getId()+")");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblType, "cell 0 1,alignx left");
		

		
		JLabel lblAdresse = new JLabel("Adresse: "+ bien.getAdresse());
		lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblAdresse, "cell 0 3,alignx left");
		
		JLabel lblTarifMensuel = new JLabel("Tarif Mensuel: "+bien.getTarifMensuel());
		lblTarifMensuel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTarifMensuel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblTarifMensuel, "cell 0 5,alignx left");
		
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, "cell 4 2 3 6,alignx center,aligny center");
		
		JLabel lblSurfaceTotale = new JLabel("Surface Totale: "+bien.getSurfaceTotale());
		lblSurfaceTotale.setHorizontalAlignment(SwingConstants.LEFT);
		lblSurfaceTotale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblSurfaceTotale, "cell 0 7,alignx left");
		
		
		String type = bien.getType(); // Your expression

		switch (type) {
		    case "Appartement":
		    	String meuble= (((Appartement) bien).isMeuble())? "Meublé": "Non meublé" ;
				JLabel lblmeuble = new JLabel( meuble );
				lblmeuble.setHorizontalAlignment(SwingConstants.LEFT);
				lblmeuble.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblmeuble, "cell 0 9,alignx left");
		   
				
		        
				JLabel lblNChambres = new JLabel("Nombre de chambres: "+ ((Appartement) bien).getNombreChambres() );
				lblNChambres.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblNChambres, "cell 0 11,,alignx left");

				String balcon= (((Appartement) bien).isBalcon())? "Avec balcon": "Sans balcon" ;
				JLabel lblbalcon = new JLabel(balcon);
				lblbalcon.setHorizontalAlignment(SwingConstants.LEFT);
				lblbalcon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblbalcon, "cell 0 13,alignx left");

			
				
				JLabel lblNumEtage = new JLabel("Numéro d'étage: "+((Appartement) bien).getNumeroEtage());
				lblNumEtage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblNumEtage, "cell 0 15");

		    	
		    	
		        break; // Optional: exits the switch statement

		    case "Maison":
		    	
		    	
		    	String jardin= (((Maison) bien).isAvecJardin())? "Avec jardin": "Sans jardin" ;
		    
				JLabel lbljardin = new JLabel(jardin);
				lbljardin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lbljardin, "cell 0 9");

		  
				JLabel lblNEtages = new JLabel("Nombre d'etages: "+ ((Maison) bien).getNombreEtages());
				lblNEtages.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblNEtages, "cell 0 11,,alignx left");
	
				JLabel lblSurEtage = new JLabel("Surface par étage: "+ ((Maison) bien).getSurfaceParEtage()+" "+"mètres carrés" );
				lblSurEtage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblSurEtage, "cell 0 13");

		    	
		        break;

		    case "Garage":
		    	
		    	
				JLabel lblNEmpl = new JLabel("Nombre d'emplacements: "+ ((Garage) bien).getNumeroEmplacement());
				lblNEmpl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				contentPane.add(lblNEmpl, "cell 0 9,,alignx left");
		        
		        break;

		    // Add more cases as needed

		    default:
		        // Code to be executed if variable doesn't match any case
		        break;
		}
		
		
	    
	    try {
	    	URL imageUrl = getClass().getResource(bien.getImgUrl());
	        BufferedImage originalImage = ImageIO.read(imageUrl);
	        // Resize the image
	        int width = 200; // Desired width of the image in the JLabel
	        int height = 200; // Set to -1 to keep aspect ratio
	        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        ImageIcon icon = new ImageIcon(scaledImage);  
	        lblImg.setIcon(icon);   

	    } catch (IOException e) {
	        e.printStackTrace(); // Handle image loading exception
	    }

		
	}


}
