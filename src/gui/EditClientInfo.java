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

public class EditClientInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPre;
	private JTextField textFieldAge;
	private JTextField textFieldAdr;
	private JTextField textFieldNum;
	private JButton btnImg;
	private JLabel lblImg;
	private JButton btnEnregistrer;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EditClientInfo(Client client,JPanel mainPanel, ClientPanel singleClientPanel,ClientPage allClient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("gapx 10px, gapy 20px", "[][150.00,fill][][38.00][63.00][][63.00][][][][]", "[][][][][][][42.00][][][][][][][]"));
		
		JLabel nom = new JLabel("Nom:");
		nom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(nom, "cell 0 1,alignx left");
		
		textFieldNom = new JTextField(client.getNom());
		contentPane.add(textFieldNom, "cell 1 1,alignx left");
		textFieldNom.setColumns(10);
		
		JLabel prenom = new JLabel("Prenom:");
		prenom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(prenom, "cell 0 3,alignx left");
		
		textFieldPre = new JTextField(client.getPrenom());
		contentPane.add(textFieldPre, "cell 1 3,alignx left");
		textFieldPre.setColumns(10);
		
		JLabel age = new JLabel("Age:");
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(age, "cell 0 5,alignx left");
		
		textFieldAge = new JTextField(String.valueOf(client.getAge()));
		contentPane.add(textFieldAge, "cell 1 5,alignx left");
		textFieldAge.setColumns(10);
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, "cell 4 2 3 6,alignx center,aligny center");
		
		JLabel adresse = new JLabel("Adresse:");
		adresse.setHorizontalAlignment(SwingConstants.LEFT);
		adresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(adresse, "cell 0 7,alignx trailing");
		
		textFieldAdr = new JTextField(client.getAdresse());
		contentPane.add(textFieldAdr, "cell 1 7,alignx left");
		textFieldAdr.setColumns(10);
		
		
	    
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
		
		JLabel numero = new JLabel("Numero:");
		numero.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(numero, "cell 0 9,alignx trailing");
		
		textFieldNum = new JTextField(client.getNumero());
		contentPane.add(textFieldNum, "cell 1 9,alignx left");
		textFieldNum.setColumns(10);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				String nom= textFieldNom.getText();
				String prenom= textFieldPre.getText();
				int age= Integer.parseInt(textFieldAge.getText());
				String adresse= textFieldAdr.getText();
				String numero= textFieldNum.getText();
				String imgUrl=(fileImgUrl[0]!=null) ? fileImgUrl[0]: client.getImgUrl();
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setAge(age);
				client.setAdresse(adresse);
				client.setNumero(numero);
				client.setImgUrl(imgUrl);
				
                mainPanel.removeAll();
                allClient.loadData();
                mainPanel.revalidate();
                mainPanel.repaint();
                JOptionPane.showMessageDialog(null, "Les informations du client ont été modifiées avec succès!");
				
			}
		});
		contentPane.add(btnEnregistrer, "cell 5 9,growx");
		
		
		
		
		
		
		
	}
    public static void saveImageToProject(File file) throws IOException {
        Path destination = Paths.get("assets/" + file.getName()); // Change the folder path accordingly
        Files.copy(file.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
    }

}
