/**
 *
 * Créé le 13 déc. 2021
 *
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.MedicamentService;
import gsb.service.StockerService;
import gsb.service.VisiteurService;

/**
 * @author LEMONNIER Bastien
 * 13 déc. 2021
 *
 */
public class JIFMedicamentStock extends JInternalFrame implements ListSelectionListener, ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7417049198945743569L;
	
	protected TreeMap<String, Stocker> lesStocks;
	
	protected JPanel visitPane;
	protected JScrollPane visitListPane;
	protected JTable visitTable;
	
	protected JLabel JLdepotLegal;
	protected JComboBox<String> JCdepotLegal;
	
	protected JPanel quantPane;
	protected JLabel JLmatricule;
	protected JComboBox<String> JCmatricule;
	protected JLabel JLquantity;
	protected JTextField JTquantity;
	protected JButton JBajouter;
	protected JButton JBretirer;
	
	protected MenuPrincipal mainFrame;
	
	public JIFMedicamentStock(MenuPrincipal mainFrame, String depotLegal, String matricule)
	{
		this.mainFrame = mainFrame;
		
		this.setLayout(new BorderLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		visitPane = new JPanel(new GridBagLayout());
		this.add(visitPane, BorderLayout.PAGE_START);
		
		lesStocks = StockerService.getStocksMedicament(depotLegal);
		int nbLignes = lesStocks.size();
		int i = 0;
		String[][] data = new String[nbLignes][4] ;
		for (Map.Entry<String, Stocker> uneEntree : lesStocks.entrySet())
		{
			data[i][0] = uneEntree.getKey();
			data[i][1] = uneEntree.getValue().getUnVisiteur().getNom();
			data[i][2] = uneEntree.getValue().getUnVisiteur().getPrenom();
			data[i][3] = Integer.toString(uneEntree.getValue().getQteStock());
			i ++;
		}
		String[] columnNamesVisit = {"Matricule", "Nom", "Prénom", "Quantité"};
		visitTable = new JTable(data, columnNamesVisit);
		visitTable.getSelectionModel().addListSelectionListener(this);
		
		JLdepotLegal = new JLabel("Dépôt Légal");
		JCdepotLegal = new JComboBox<String>();
		TreeMap<String, Medicament> lesMedocs = MedicamentService.recupListe();
		for(String key : lesMedocs.keySet())
			JCdepotLegal.addItem(key);
		JCdepotLegal.setSelectedItem(depotLegal);
		JCdepotLegal.addActionListener(this);
		
		visitListPane = new JScrollPane(visitTable);
		visitListPane.setPreferredSize(new Dimension(400, 100));
		visitListPane.setMinimumSize(new Dimension(100, 60));
		
		constraint = new GridBagConstraints();
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		visitPane.add(JLdepotLegal, constraint);
		constraint.gridy = 1;
		visitPane.add(JCdepotLegal, constraint);
		constraint.gridy = 2;
		visitPane.add(visitListPane, constraint);
		
		quantPane = new JPanel(new GridBagLayout());
		this.add(quantPane, BorderLayout.CENTER);
		
		JLmatricule = new JLabel("Matricule");
		JCmatricule = new JComboBox<String>();
		TreeMap<String, Visiteur> lesVisiteurs = VisiteurService.recupListe();
		for(String key : lesVisiteurs.keySet())
			JCmatricule.addItem(key);
		JCmatricule.setSelectedItem(matricule);
		JLquantity = new JLabel("Quantité");
		JTquantity = new JTextField(10);
		JBajouter = new JButton("Ajouter");
		JBajouter.addActionListener(this);
		JBretirer = new JButton("Retirer");
		JBretirer.addActionListener(this);
		
		constraint = new GridBagConstraints();
		
		constraint.insets = new Insets(0,10,0,10);
		constraint.gridheight = 1;
		constraint.gridx = 0;
		constraint.gridy = 1;
		quantPane.add(JLmatricule, constraint);
		constraint.gridheight = 2;
		constraint.gridy = 2;
		quantPane.add(JCmatricule, constraint);
		constraint.gridheight = 1;
		constraint.gridx = 1;
		constraint.gridy = 1;
		quantPane.add(JLquantity, constraint);
		constraint.gridheight = 2;
		constraint.gridy = 2;
		quantPane.add(JTquantity, constraint);
		constraint.gridheight = 1;
		constraint.gridx = 2;
		constraint.gridy = 1;
		quantPane.add(JBajouter, constraint);
		constraint.gridy = 2;
		quantPane.add(JBretirer, constraint);
		
	}
	
	private Stocker getStockSaisie()
	{
		int quantity = Integer.parseInt(JTquantity.getText());
		String matricule = (String) JCmatricule.getSelectedItem();
		Visiteur unVisiteur = VisiteurService.rechercherVisiteur(matricule);
		String depotLegal = (String) JCdepotLegal.getSelectedItem();
		Medicament unMedoc = MedicamentService.rechercher(depotLegal);
		Stocker unStock = new Stocker(quantity, unVisiteur, unMedoc);
		return unStock;
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		JCmatricule.setSelectedItem((String)visitTable.getValueAt(visitTable.getSelectedRow(), 0));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == JBajouter)
		{
			StockerService.ajouter(getStockSaisie());
			mainFrame.ouvrirFenetre(new JIFMedicamentStock(mainFrame, (String) JCdepotLegal.getSelectedItem(), (String) JCmatricule.getSelectedItem()));
		}
		
		if(source == JBretirer)
		{
			StockerService.retirer(getStockSaisie());
			mainFrame.ouvrirFenetre(new JIFMedicamentStock(mainFrame, (String) JCdepotLegal.getSelectedItem(), (String) JCmatricule.getSelectedItem()));
		}
		
		if(source == JCdepotLegal)
		{
			mainFrame.ouvrirFenetre(new JIFMedicamentStock(mainFrame, (String) JCdepotLegal.getSelectedItem(), (String) JCmatricule.getSelectedItem()));
		}
		
	}
	
}
