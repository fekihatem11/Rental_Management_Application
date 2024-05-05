package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
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
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 27, 770, 343);		
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[45px][53.00px][85px][][][][][]", "[13px][13px][13px][13px][13px][21px][][][][][][][][][]"));
		
		JLabel age = new JLabel("New label");
		panel_1.add(age, "cell 1 2,alignx left,aligny top");
		
		JLabel numero = new JLabel("New label");
		panel_1.add(numero, "cell 1 5,alignx left,aligny top");
		
		JButton btnSupp = new JButton("New button");
		panel_1.add(btnSupp, "cell 7 5,aligny top");
		
		JLabel nom = new JLabel("New label");
		panel_1.add(nom, "cell 1 7,alignx left,aligny top");
		
		JLabel address = new JLabel("New label");
		panel_1.add(address, "cell 1 9,alignx left,aligny top");
		
		JLabel prenom = new JLabel("New label");
		panel_1.add(prenom, "cell 1 11,alignx left,aligny top");
		
		JLabel img = new JLabel("");
		panel.add(img, BorderLayout.WEST);
		
		
		JLabel lblNewLabel = 	new JLabel("");

		//panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
        JLabel lblNewLabel_5 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 1;
        //panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		

        
            try {
            	URL imageUrl = getClass().getResource("/GarNL.jpg");
                BufferedImage originalImage = ImageIO.read(imageUrl);
                // Resize the image
                int width = 300; // Desired width of the image in the JLabel
                int height = 343; // Set to -1 to keep aspect ratio
                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                
            	URL imageUrl2 = getClass().getResource("/LOUER.png");
                BufferedImage originalImage2 = ImageIO.read(imageUrl2);
                // Resize the image
                int width1 = 400; // Desired width of the image in the JLabel
                int height1 = 100; // Set to -1 to keep aspect ratio
                Image scaledImage1 = originalImage2.getScaledInstance(width1, height1, Image.SCALE_SMOOTH);
                ImageIcon icon1 = new ImageIcon(scaledImage1);
                
                img.setIcon(icon);
                //lblNewLabel_5.setIcon(icon1);
                
                

            } catch (IOException e) {
                e.printStackTrace(); // Handle image loading exception
            }
		

	}
}
