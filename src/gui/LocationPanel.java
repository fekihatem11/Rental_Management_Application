package gui;

import javax.swing.JPanel;
import javax.swing.border.Border;

import database.Database;
import entities.Bien;
import entities.Location;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;

public class LocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Location location;

	/**
	 * Create the panel.
	 */
	public LocationPanel(JPanel mainPanel,Location locationParam,Database db,LocationPage allLocation) {
		
		location=locationParam;
	    Border whiteBorder = BorderFactory.createLineBorder(Color.white, 4);
	    setBorder(whiteBorder);
		setLayout(new BorderLayout(0, 0));
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 450));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel bienImg = new JLabel("");
		bienImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		bienImg.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(bienImg);
		
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton btnLocationDetail = new JButton("Détails Bien");
		btnLocationDetail.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLocationDetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnLocationDetail);
		
		btnLocationDetail.addActionListener(e -> {
			BienInfo infoPage= new BienInfo(location.getBien());
			infoPage.setVisible(true);

        });
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel clientImg = new JLabel("");
		clientImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		clientImg.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(clientImg);
		
		panel_1.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton btnClientDetail = new JButton("Détails Client");
		btnClientDetail.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClientDetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnClientDetail);
		
		btnClientDetail.addActionListener(e -> {
			ClientInfo infoPage= new ClientInfo(location.getLocataire());
			infoPage.setVisible(true);

        });
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("gap 5px 30px", "[100.00px][450.00px][][][]", "[100.00px][][100.00px][][][][][][][][]"));
		
		JLabel lblType = new JLabel("Type: " +location.getBien().getType()+" ("+location.getBien().getId()+")");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblType, "cell 1 0");
		
		JLabel lblClient = new JLabel("Locataire: "+ location.getLocataire().getNom()+" "+ location.getLocataire().getPrenom() );
		lblClient.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblClient, "cell 1 2");
		
		JLabel lblDate = new JLabel("Date début: "+ new SimpleDateFormat("yyyy-MM-dd").format(location.getDateDebutLocation()));
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblDate, "cell 1 4");
		
		JLabel lblTarif = new JLabel("Tarif Mensuel: "+ String.valueOf(location.getBien().getTarifMensuel())+" "+ "$" );
		lblTarif.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblTarif, "cell 1 6");
		
		JLabel lblAdresse = new JLabel("Adresse location: "+ location.getBien().getAdresse());
		lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblAdresse, "cell 1 8");
		
		
		
		JButton btnSupp = new JButton("Supprimer ");
		btnSupp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnSupp, "cell 3 9 3 2,grow");
		
		btnSupp.addActionListener(e -> {
	        int dialogResult = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ??", "Confirmation", JOptionPane.YES_NO_OPTION);
	        
	        if (dialogResult == JOptionPane.YES_OPTION) {
	        	location.getBien().setDateDebutLocation(null);
	        	location.getBien().setEnLocation(false);
				db.deleteLocation(location);
	            mainPanel.remove(this);
	            mainPanel.revalidate();
	            mainPanel.repaint();
	        } else {
	            System.out.println("Cancelled");
	        }

        });
		
		try {
			
			URL bienImgg = getClass().getResource(location.getBien().getImgUrl());
			BufferedImage originalImage = ImageIO.read(bienImgg);
			// Resize the image
			int width = 300; // Desired width of the image in the JLabel
			int height = 300; // Set to -1 to keep aspect ratio
			Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaledImage);

			
			URL clientImgg = getClass().getResource(location.getLocataire().getImgUrl());
			BufferedImage originalImage2 = ImageIO.read(clientImgg);
			// Resize the image
			int width1 = 300; // Desired width of the image in the JLabel
			int height1 = 300; // Set to -1 to keep aspect ratio
			Image scaledImage1 = originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
			ImageIcon icon1 = new ImageIcon(scaledImage1);

		    bienImg.setIcon(icon);
			clientImg.setIcon(icon1);

		} catch (IOException e) {
			e.printStackTrace(); // Handle image loading exception
		}
		
		

	}
	
	

}
