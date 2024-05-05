package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Client;
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

public class ClientInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private JLabel lblImg;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ClientInfo(Client client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("gapx 10px, gapy 20px", "[][150.00,fill][][38.00][63.00][][63.00][][][][]", "[][][][][][][42.00][][][][][][][]"));
		
		JLabel nom = new JLabel("Nom: "+client.getNom());
		nom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(nom, "cell 0 1,alignx left");

		
		JLabel prenom = new JLabel("Prenom: "+client.getPrenom());
		prenom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(prenom, "cell 0 3,alignx left");
		

		JLabel age = new JLabel("Age: "+ String.valueOf(client.getAge()));
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(age, "cell 0 5,alignx left");
	
		lblImg = new JLabel("");
		contentPane.add(lblImg, "cell 4 2 3 6,alignx center,aligny center");
		
		JLabel adresse = new JLabel("Adresse: "+ client.getAdresse());
		adresse.setHorizontalAlignment(SwingConstants.LEFT);
		adresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(adresse, "cell 0 7,alignx trailing");

		
		JLabel numero = new JLabel("Numero: "+ client.getNumero());
		numero.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(numero, "cell 0 9,alignx trailing");

		
	    
	    try {
	    	URL imageUrl = getClass().getResource(client.getImgUrl());
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
