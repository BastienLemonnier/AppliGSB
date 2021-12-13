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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
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
	
	protected TreeMap<String, Medicament> lesMedocs;
	protected JPanel medocPane;
	protected JScrollPane medocListPane;
	protected JTable medocTable;
	protected JLabel JLmedoc;
	protected JTextField JTmedoc;
	
	protected TreeMap<String, Visiteur> lesVisiteurs;
	protected JPanel visitPane;
	protected JScrollPane visitListPane;
	protected JTable visitTable;
	protected JLabel JLvisit;
	protected JTextField JTvisit;
	
	protected JPanel quantPane;
	protected JLabel JLquantity;
	protected JTextField JTquantity;
	protected JButton JBsend;
	
	protected MenuPrincipal mainFrame;
	
	public JIFMedicamentStock(MenuPrincipal mainFrame)
	{
		this.mainFrame = mainFrame;
		
		this.setLayout(new BorderLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		medocPane = new JPanel(new GridBagLayout());
		this.add(medocPane, BorderLayout.LINE_START);
		
		TreeMap<String, Medicament> lesMedocs = MedicamentService.recupListe();
		int nbLignes = lesMedocs.size();
		int i = 0;
		String[][] data = new String[nbLignes][2] ;
		for (Map.Entry<String, Medicament> uneEntree : lesMedocs.entrySet())
		{
			data[i][0] = uneEntree.getValue().getDepotLegal();
			data[i][1] = uneEntree.getValue().getNomCommercial();
			i ++;
		}
		String[] columnNamesMedoc = {"Dépôt Légal", "Nom Commercial"};
		medocTable = new JTable(data, columnNamesMedoc);
		medocTable.getSelectionModel().addListSelectionListener(this);
		
		medocListPane = new JScrollPane();
		medocListPane.setPreferredSize(new Dimension(400, 100));
		medocListPane.setMinimumSize(new Dimension(100, 60));
		
		JLmedoc = new JLabel("Médicament");
		JTmedoc = new JTextField();
		
		constraint = new GridBagConstraints();
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		visitPane.add(medocListPane, constraint);
		constraint.gridy = 1;
		visitPane.add(JLmedoc, constraint);
		constraint.gridy = 2;
		visitPane.add(JTmedoc, constraint);
		
		
		
		visitPane = new JPanel(new GridBagLayout());
		this.add(visitPane, BorderLayout.LINE_END);
		
		ArrayList<Visiteur> lesVisiteurs = VisiteurService.recupListe();
		nbLignes = lesMedocs.size();
		i = 0;
		data = new String[nbLignes][2] ;
		for (Visiteur unVisiteur : lesVisiteurs)
		{
			data[i][0] = unVisiteur.getMatricule();
			data[i][1] = unVisiteur.getNom();
			data[i][2] = unVisiteur.getPrenom();
			i ++;
		}
		String[] columnNamesVisit = {"Matricule", "Nom", "Prénom"};
		visitTable = new JTable(data, columnNamesVisit);
		visitTable.getSelectionModel().addListSelectionListener(this);
		
		JLvisit = new JLabel("Visiteur");
		JTvisit = new JTextField();
		
		visitListPane = new JScrollPane();
		visitListPane.setPreferredSize(new Dimension(400, 100));
		visitListPane.setMinimumSize(new Dimension(100, 60));
		
		constraint = new GridBagConstraints();
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		visitPane.add(visitListPane, constraint);
		constraint.gridy = 1;
		visitPane.add(JLvisit, constraint);
		constraint.gridy = 2;
		visitPane.add(JTvisit, constraint);
		
		
		
		quantPane = new JPanel(new GridBagLayout());
		this.add(quantPane, BorderLayout.PAGE_END);
		
		JLquantity = new JLabel("Quantité");
		JTquantity = new JTextField();
		JBsend = new JButton("Envoyer");
		JBsend.addActionListener(this);
		
		constraint = new GridBagConstraints();
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		quantPane.add(JLquantity, constraint);
		constraint.gridy = 1;
		quantPane.add(JLquantity, constraint);
		constraint.gridy = 2;
		quantPane.add(JBsend, constraint);
		
		
		
	}
	
	private Stocker getStockSaisie()
	{
		Stocker leStock = new Stocker();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == JBsend)
		{
			
		}
		
	}
	
}
