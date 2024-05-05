package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.Database;
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

public class AjouterBien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAdr;
	private JTextField textFieldTarif;
	private JTextField textFieldSurTot;
	private JComboBox typeBox;
	
	
	//Appartement
	
	private JComboBox meubleBox ;
	private JTextField textField_nChambres;
	private JTextField textField_numeroEtage;
	private JComboBox balconBox;

	// Maison 

	private JTextField textField_nombreEtages;
	private JComboBox jardinBox;
	private JTextField textField_surfaceParEtage;
	


	// Garage
	private JTextField textField_numeroEmplacement;
	
	
	private JButton btnImg;
	private JLabel lblImg;
	private JButton btnEnregistrer;
	
	private String typee;
	
	 

	public AjouterBien(JPanel mainPanel,Database data,HomePage allBien,String type,AjouterLocation ajouterLocation ) {
		this.typee=type;
		initialize(type,data,mainPanel,allBien,ajouterLocation);		
	}
	
	public String getTypee() {
		return this.typee;
	}
	


	private void initialize(String type ,Database db, JPanel mainPanel,HomePage allBien,AjouterLocation ajouterLocation   ) {
		   
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(500, 50, 700, 700);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new MigLayout("gapx 10px, gapy 20px", "[][150.00,grow,fill][][38.00][63.00][][63.00][][][][]", "[][][][][][][][][][][][][][][][][]"));
			
			JLabel lblType = new JLabel(type);
			lblType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			contentPane.add(lblType, "cell 0 1,alignx left");
			
			JLabel lblAdresse = new JLabel("Adresse:");
			lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			contentPane.add(lblAdresse, "cell 0 3,alignx left");
			
			textFieldAdr = new JTextField();
			contentPane.add(textFieldAdr, "cell 1 3,alignx left");
			textFieldAdr.setColumns(10);
			
			JLabel lblTarifMensuel = new JLabel("Tarif Mensuel :");
			lblTarifMensuel.setHorizontalAlignment(SwingConstants.LEFT);
			lblTarifMensuel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			contentPane.add(lblTarifMensuel, "cell 0 5,alignx left");
			
			textFieldTarif = new JTextField();
			contentPane.add(textFieldTarif, "cell 1 5,alignx left");
			textFieldTarif.setColumns(10);
			
			lblImg = new JLabel("");
			contentPane.add(lblImg, "cell 4 2 3 6,alignx center,aligny center");
			
			JLabel lblSurfaceTotale = new JLabel("Surface Totale:");
			lblSurfaceTotale.setHorizontalAlignment(SwingConstants.LEFT);
			lblSurfaceTotale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			contentPane.add(lblSurfaceTotale, "cell 0 7,alignx left");
			
			textFieldSurTot = new JTextField();
			contentPane.add(textFieldSurTot, "cell 1 7,alignx left");
			textFieldSurTot.setColumns(10);
			
			

         		switch (type) {
     		    case "Appartement":
     				JLabel lblmeuble = new JLabel("Meublé:");
     				lblmeuble.setHorizontalAlignment(SwingConstants.LEFT);
     				lblmeuble.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblmeuble, "cell 0 9,alignx left");
     		    	meubleBox = new JComboBox();
     		    	meubleBox.setModel(new DefaultComboBoxModel(new String[] {"Oui", "Non"}));
     		    	meubleBox.setSelectedItem("Oui");
     				contentPane.add(meubleBox, "cell 1 9,alignx left");
     			
     				JLabel lblNChambres = new JLabel("Nombre de chambres:" );
     				lblNChambres.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblNChambres, "cell 0 11,,alignx left");
     				textField_nChambres = new JTextField();
     				contentPane.add(textField_nChambres, "cell 1 11,alignx left");
     				textField_nChambres.setColumns(10);
     				
     				JLabel lblbalcon = new JLabel("Balcon:");
     				lblbalcon.setHorizontalAlignment(SwingConstants.LEFT);
     				lblbalcon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblbalcon, "cell 0 13,alignx left");
     				balconBox = new JComboBox();
     				balconBox.setModel(new DefaultComboBoxModel(new String[] {"Oui", "Non"}));
     				balconBox.setSelectedItem("Oui");
     				contentPane.add(balconBox, "cell 1 13,alignx left");
     			
     				
     				JLabel lblNumEtage = new JLabel("Numéro d'étage:");
     				lblNumEtage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblNumEtage, "cell 0 15");
     				textField_numeroEtage = new JTextField();
     				contentPane.add(textField_numeroEtage, "cell 1 15,alignx left");
     				textField_numeroEtage.setColumns(10);
    
     		        break; // Optional: exits the switch statement

     		    case "Maison":
     		    	
     		    	
     				JLabel lbljardin = new JLabel("Jardin");
     				lbljardin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lbljardin, "cell 0 9");
     				jardinBox = new JComboBox();
     				jardinBox.setModel(new DefaultComboBoxModel(new String[] {"Avec", "Sans"}));
     				jardinBox.setSelectedItem("Avec");
     				contentPane.add(jardinBox, "cell 1 9,alignx left");
     		        
     				
     				JLabel lblNEtages = new JLabel("Nombre d'etages:");
     				lblNEtages.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblNEtages, "cell 0 11,,alignx left");
     				textField_nombreEtages = new JTextField();
     				contentPane.add(textField_nombreEtages, "cell 1 11,alignx left");
     				textField_nombreEtages.setColumns(10);
     			
     				
     				JLabel lblSurEtage = new JLabel("Surface par étage:");
     				lblSurEtage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblSurEtage, "cell 0 13");
     				textField_surfaceParEtage = new JTextField();
     				contentPane.add(textField_surfaceParEtage, "cell 1 13,alignx left");
     				textField_surfaceParEtage.setColumns(10);
     				
     			
     				
     		        break;

     		    case "Garage":
     		    	
     				JLabel lblNEmpl = new JLabel("Nombre d'emplacements:");
     				lblNEmpl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
     				contentPane.add(lblNEmpl, "cell 0 9,,alignx left");
     				textField_numeroEmplacement = new JTextField();
     				contentPane.add(textField_numeroEmplacement, "cell 1 9,alignx left");
     				textField_numeroEmplacement.setColumns(10);
     	   
     		        break;

     		    // Add more cases as needed

     		    default:
     		        // Code to be executed if variable doesn't match any case
     		        break;
     		        
     		};
				
			final String[] fileImgUrl = {null};
			btnImg = new JButton("Choisir Image");
			btnImg.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JFileChooser fileChooser = new JFileChooser();
	                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "jpeg");
	                fileChooser.setFileFilter(filter);
	                int returnValue = fileChooser.showOpenDialog(null);
	                if (returnValue == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();
	                    String imagePath = selectedFile.getAbsolutePath();
	                    try {
	                        saveImageToProject(selectedFile);
	                        fileImgUrl[0] = "/"+selectedFile.getName();
	                        ImageIcon imageIcon = new ImageIcon(imagePath);
	                        ImageIcon scaledIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	                        lblImg.setIcon(scaledIcon);
	                        JOptionPane.showMessageDialog(null, "Image saved to project assets folder!");
	                    } catch (IOException ex) {
	                        ex.printStackTrace();
	                        JOptionPane.showMessageDialog(null, "Error saving image!");

	                    }
	                }
	            }
	        });
			btnImg.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(btnImg, "cell 5 8,alignx center");
			btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			btnEnregistrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e ) {
					System.out.println(getTypee());
					String adresse= textFieldAdr.getText();
					double tarifMensuel=Double.parseDouble( textFieldTarif.getText());
					double surfaceTotale= Double.parseDouble(textFieldSurTot.getText()) ;
					String imgUrl=(fileImgUrl[0]!=null) ? fileImgUrl[0]: "/NoImg.jpg";
					
				    switch (getTypee()) {
	            case "Appartement":
	            	System.out.println(getTypee());
	            	boolean  meuble= (meubleBox.getSelectedItem()=="Oui")? true:false ;
					int nChambres= Integer.parseInt( textField_nChambres.getText());
					int numeroEtage = Integer.parseInt( textField_numeroEtage.getText());
					boolean balcon=  (balconBox.getSelectedItem()=="Oui")? true:false ;
						
					Appartement appart = new Appartement("Appartement",adresse,tarifMensuel,surfaceTotale,false,meuble,nChambres,numeroEtage,balcon) ;
					appart.setImgUrl(imgUrl);
					db.getBiens().add(0,appart);
					System.out.println("added");
					
					if(allBien!=null && ajouterLocation==null) {
						mainPanel.removeAll();
						allBien.loadData();
		                mainPanel.revalidate();
		                mainPanel.repaint();
					} 
					
					else if  (ajouterLocation!=null) {
						ajouterLocation.updateBienList(appart);
						 
					}
					
	                JOptionPane.showMessageDialog(null, "Client a été créé avec succès!");	
					
					
	                break;

	            case "Maison":
	            	
	            	System.out.println(getTypee());
					int nombreEtages= Integer.parseInt( textField_nombreEtages.getText()); ;
					boolean avecJardi=(jardinBox.getSelectedItem()=="Oui")? true:false ;
					double surfaceParEtage= Double.parseDouble(textField_surfaceParEtage.getText());
	         
					Maison maison = new Maison("Maison",adresse,tarifMensuel,false,nombreEtages,avecJardi,surfaceParEtage) ;
					maison.setImgUrl(imgUrl);
					db.getBiens().add(0,maison);
					System.out.println("added");
					
					if(allBien!=null && ajouterLocation==null) {
						mainPanel.removeAll();
						allBien.loadData();
		                mainPanel.revalidate();
		                mainPanel.repaint();
					} 
					
					else if  (ajouterLocation!=null) {
						ajouterLocation.updateBienList(maison);
						 
					}
					
	                JOptionPane.showMessageDialog(null, "Client a été créé avec succès!");
	            	
	                break;

	            case "Garage":
	            	
	            	int numeroEmplacement= Integer.parseInt( textField_numeroEmplacement.getText()); ;
	            	
					Garage garage = new Garage("Garage",adresse,tarifMensuel,surfaceTotale,false,numeroEmplacement) ;
					garage.setImgUrl(imgUrl);
					db.getBiens().add(0,garage);
					System.out.println("added");
					
					if(allBien!=null && ajouterLocation==null) {
						mainPanel.removeAll();
						allBien.loadData();
		                mainPanel.revalidate();
		                mainPanel.repaint();
					} 
					
					else if  (ajouterLocation!=null) {
						ajouterLocation.updateBienList(garage);
						 
					}
					
	                JOptionPane.showMessageDialog(null, "Client a été créé avec succès!");
					
					
	                break;

	            default:
	                break;
	        }
					
		
					
				}
			});
			contentPane.add(btnEnregistrer, "cell 1 16 5 1,alignx center,aligny center");
			
			
			// TODO Auto-generated method stub
			
		}
	
	

 
	public static void saveImageToProject(File file) throws IOException {
        Path destination = Paths.get("assets/" + file.getName()); // Change the folder path accordingly
        Files.copy(file.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
    }

}
