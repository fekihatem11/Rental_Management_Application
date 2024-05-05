package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import database.Database;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import entities.Bien;
import entities.Client;
import entities.Location;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

public class HomePage extends JFrame {
	
	private JPanel panel;
	private Database data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public HomePage() throws ParseException {
		data= new Database();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gérer les biens");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmGrerLesClients = new JMenuItem("Gérer les clients");
		mntmGrerLesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClientPage clientPage = new ClientPage(data);
							clientPage.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu.add(mntmGrerLesClients);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Gérer les locations");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LocationPage locationPage = new LocationPage(data);
							locationPage.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
		JMenu trierParMenu = new JMenu("Affichage");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButtonMenuItem allBienItem = new JRadioButtonMenuItem("Tous les biens");
		allBienItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
        		loadData();
				
			}
		});
	
       
        buttonGroup.add(allBienItem);
        trierParMenu.add(allBienItem);

        JRadioButtonMenuItem bienLoue = new JRadioButtonMenuItem("Biens non Loués");
        bienLoue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel.removeAll();
        		loadBienNonLoue();
        	}
        });
       
        buttonGroup.add(bienLoue);
        trierParMenu.add(bienLoue);
        
        JRadioButtonMenuItem bienNonLoue = new JRadioButtonMenuItem("Biens Loués");
        bienNonLoue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel.removeAll();
        		loadBienLoue();
        		
        	}
        });
        
         buttonGroup.add(bienNonLoue);
         trierParMenu.add(bienNonLoue);
        
        menuBar.add(trierParMenu);
		
		
		
		
    
        
        
		
	
		
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        
        
        

        JButton addButton = new JButton("Ajouter Bien");
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a dialog to select the type of bien
                String[] bienTypes = { "Appartement", "Maison", "Garage" };
                String selectedType = (String) JOptionPane.showInputDialog(
                		HomePage.this,
                        "Sélectionnez le type de bien:",
                        "Choisir le type de Bien",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        bienTypes,
                        bienTypes[0]);

                if (selectedType != null) {
                	ajouterBien(selectedType);
                }
            }
        });
        
   JButton reload = new JButton("Actualiser");
        
   		reload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	panel.removeAll();
               loadData();
            
            }
        });
        
        
        
        JTextField searchField = new JTextField(15);
        searchField.setMaximumSize(searchField.getPreferredSize());

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                filterBySurface(searchField.getText());
                panel.revalidate();
    	        panel.repaint();
             
            }
        });
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.add(addButton);
        searchPanel.add(reload);
        searchPanel.add(Box.createHorizontalGlue()); // Pushes components to the right
        searchPanel.add(new JLabel("Surface Totale >= "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
    
        
        



        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
        
        loadData();
        setLocationRelativeTo(null);
        setVisible(true);
		
	}
	
	
	  private void filterBySurface(String input) {
		
		  try {
	            double surfaceValue = Double.parseDouble(input);
	            List<Bien> filteredBiens = new ArrayList<>();
	            for (Bien bien : data.getBiens()) {
	                if (bien.getSurfaceTotale() >= surfaceValue) {
	                	BienPanel bienPanel= new BienPanel(panel,bien,data,this);
	        	        panel.add(bienPanel);
	        	        panel.revalidate();
	        	        panel.repaint();
	                }
	            }
	            
	            
	            // Display filteredBiens in the UI
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Please enter a valid number for surface.");
	        }
	}


	private void ajouterBien(String selectedType) {
	   

	        // Customize the new frame based on the selected type
	        switch (selectedType) {
	            case "Appartement":
	                
	            	AjouterBien ajouterApp = new AjouterBien(panel,data,this,"Appartement",null);
	            	ajouterApp.setVisible(true);
	            	
	                break;

	            case "Maison":
	                AjouterBien ajouterMai = new AjouterBien(panel,data,this,"Maison",null);
	                ajouterMai.setVisible(true);
	                break;

	            case "Garage":
	            	AjouterBien ajouterGar = new AjouterBien(panel,data,this,"Garage",null);
	            	ajouterGar.setVisible(true);
	                break;

	            default:
	                break;
	        }
	    }
	
    public void loadData() {
    	
		Iterator<Bien> iterator = data.getBiens().iterator();
		while (iterator.hasNext()) {
			Bien bien = iterator.next();
			System.out.println(bien.getId());
	    	BienPanel bienPanel= new BienPanel(panel,bien,data,this);
	        panel.add(bienPanel);
	        panel.revalidate();
	        panel.repaint();
		}
  
	}
    
    public void loadBienLoue() {
    	
		Iterator<Location> iterator = data.getLocations().iterator();
		while (iterator.hasNext()) {
			Location location = iterator.next();
			
	    	BienPanel bienPanel= new BienPanel(panel,location.getBien(),data,this);
	        panel.add(bienPanel);
	        panel.revalidate();
	        panel.repaint();
		}
  
	}
    
    public void loadBienNonLoue() {
        List<Bien> bienNotInLocation = data.getBiens().stream()
                .filter(bien -> !bien.isEnLocation())
                .collect(Collectors.toList());
        for (Bien bien : bienNotInLocation) {
        	BienPanel bienPanel= new BienPanel(panel,bien,data,this);
	        panel.add(bienPanel);
	        panel.revalidate();
	        panel.repaint();
        		}
    	
		}
    
    
    


}
