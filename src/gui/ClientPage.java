package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import database.Database;
import entities.Client;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;



public class ClientPage extends JFrame {
    private JPanel panel;
	private Database data;
// Fixed height for each row

    public ClientPage(Database data) {
    	this.data=data;
    	initialize();
    
    }
    
    
	private void initialize() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gérer les biens");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		
		JMenuItem mntmGrerLesClients = new JMenuItem("Gérer les clients");
		mnNewMenu.add(mntmGrerLesClients);
		mntmGrerLesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClientPage clientPage = new ClientPage(data);
							clientPage.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Gérer les locations");
		mnNewMenu.add(mntmNewMenuItem_1_1);
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LocationPage locationPage = new LocationPage(data);
							locationPage.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
	    JMenu trierParMenu = new JMenu("Trier par");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButtonMenuItem nomItem = new JRadioButtonMenuItem("Nom");
		nomItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.clientSortByNom();
				panel.removeAll();
				loadData();
			}
		});
	
       
        buttonGroup.add(nomItem);
        trierParMenu.add(nomItem);

        JRadioButtonMenuItem prenomItem = new JRadioButtonMenuItem("Prenom");
        prenomItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		data.clientSortByPrenom();;
				panel.removeAll();
				loadData();
        	}
        });
       
        buttonGroup.add(prenomItem);
        trierParMenu.add(prenomItem);
        
        JRadioButtonMenuItem idItem = new JRadioButtonMenuItem("Id");
        idItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		data.clientSortById();;
				panel.removeAll();
				loadData();
        	}
        });
        
         buttonGroup.add(idItem);
         trierParMenu.add(idItem);
        
        menuBar.add(trierParMenu);
		
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        

        JButton addButton = new JButton("Ajouter Client");
        addButton.addActionListener(e -> {
        	AjouterClient ajouterClient = new AjouterClient(panel,data,this,null);
        	ajouterClient.setVisible(true);   
        });


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(addButton, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
        
        loadData();
        setLocationRelativeTo(null);
        setVisible(true);
	}

    public void loadData() {
    	
		Iterator<Client> iterator = data.getClients().iterator();
		while (iterator.hasNext()) {
			Client client = iterator.next();
			System.out.println(client.getId());
	    	ClientPanel clientPanel= new ClientPanel(panel,client,data,this);
	        panel.add(clientPanel);
	        panel.revalidate();
	        panel.repaint();
		}
  
	}

/*
	private void addClientPanel(String clientInfo) {
    	
    	ClientPanel clientPanel= new ClientPanel(panel);
        panel.add(clientPanel);
        panel.revalidate();
        panel.repaint();
    }
*/
}