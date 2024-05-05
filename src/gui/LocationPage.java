package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.Database;
import entities.Bien;
import entities.Location;

public class LocationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Database data;
	
	/**
	 * Launch the application

	/**
	 * Create the frame.
	 */
	public LocationPage(Database data) {
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
		mnNewMenu.add(mntmGrerLesClients);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Gérer les locations");
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        

        JButton addButton = new JButton("Ajouter Location");
        addButton.addActionListener(e -> {
        	AjouterLocation ajouterlocation = new AjouterLocation(panel,data,this);
        	ajouterlocation.setVisible(true);
        	
        	
        });


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(addButton, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);
        
        loadData();
        setLocationRelativeTo(null);
        setVisible(true);
		
	}
	
    public void loadData() {
    	
		Iterator<Location> iterator = data.getLocations().iterator();
		while (iterator.hasNext()) {
			Location location = iterator.next();
			System.out.println(location.getId());
	    	LocationPanel locationPanel= new LocationPanel(panel,location,data,this);
	        panel.add(locationPanel);
	        panel.revalidate();
	        panel.repaint();
		}
  
	}


}
