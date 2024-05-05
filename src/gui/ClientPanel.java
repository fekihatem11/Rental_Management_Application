package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import database.Database;
import entities.Client;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.SpringLayout;

public class ClientPanel extends JPanel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client client;
	
	ClientPanel(JPanel mainPanel,Client clientParam,Database db,ClientPage allClient){
		
		client=clientParam;
		setLayout(new BorderLayout());
		
	    Border whiteBorder = BorderFactory.createLineBorder(Color.white, 4);
	    setBorder(whiteBorder);
	    setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
	    
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("gap 5px 30px", "[][150.00,fill][][38.00][63.00][63.00][63.00][63.00][63.00][63.00][]", "[][][][][][][][][][][][]"));
		
		JLabel nom = new JLabel("Nom: "+client.getNom());
		panel_1.add(nom, "cell 1 1,alignx left,aligny top");
		nom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel prenom = new JLabel("Prenom: "+client.getPrenom());
		panel_1.add(prenom, "cell 1 2,alignx left,aligny top");
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel age = new JLabel("Age: "+String.valueOf(client.getAge()));
		panel_1.add(age, "cell 1 3,alignx left,aligny top");
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel numero = new JLabel("Numero: "+client.getNumero());
		panel_1.add(numero, "cell 1 4,alignx left,aligny top");
		numero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel address = new JLabel("Adresse: "+client.getAdresse());
		panel_1.add(address, "cell 1 5,alignx left,aligny top");
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		JButton btnSupp = new JButton("Supprimer");
		panel_1.add(btnSupp, "cell 10 4, width 30px,alignx left,aligny top");
		btnSupp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		btnSupp.addActionListener(e -> {
	        int dialogResult = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ??", "Confirmation", JOptionPane.YES_NO_OPTION);
	        
	        if (dialogResult == JOptionPane.YES_OPTION) {
				db.deleteClient(client);
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
			EditClientInfo editPage= new EditClientInfo(client,mainPanel,this,allClient);
			editPage.setVisible(true);
		}
		);
		
		JLabel img = new JLabel("");
		
		
	    JPanel imagePanel = new JPanel();
	    add(imagePanel, BorderLayout.WEST);
	    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
	    imagePanel.add(img);
	    
	    try {
	    	URL imageUrl = getClass().getResource(client.getImgUrl());
	        BufferedImage originalImage = ImageIO.read(imageUrl);
	        // Resize the image
	        int width = 300; // Desired width of the image in the JLabel
	        int height = 300; // Set to -1 to keep aspect ratio
	        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        ImageIcon icon = new ImageIcon(scaledImage);   
	        img.setIcon(icon);
	       

	    } catch (IOException e) {
	        e.printStackTrace(); // Handle image loading exception
	    }
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	


    


}
