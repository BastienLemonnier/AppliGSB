/**
 *
 * Créé le 25 oct. 2021
 *
 */
package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import gsb.modele.Visite;
import gsb.service.VisiteService;

/**
 * @author LEMONNIER Bastien
 * 25 oct. 2021
 */
public class JIFVisiteListe extends JInternalFrame implements ActionListener, ListSelectionListener {
	
	private static final long serialVersionUID = 3630L;
	
	private TreeMap<String,Visite> dicoVisite;


	protected JPanel p;
	
	protected JPanel pSaisie1;
	protected JLabel JLmatricule;
	protected JTextField JTmatricule;
	protected JLabel JLdate;
	protected JTextField JTdate;
	
	protected JScrollPane scrollPane;
	
	protected JPanel pSaisie2;
	protected JLabel JLrefVisite;
	protected JTextField JTrefVisite;
	protected JButton JBafficherVisite;
	
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFVisiteListe(MenuPrincipal uneFenetreContainer, String matricule, String date) {

		fenetreContainer = uneFenetreContainer;
		
		dicoVisite = VisiteService.rechercherListeVisites(matricule,date);
		int nbLignes = dicoVisite.size();
		
		p = new JPanel(); // panneau principal de la fenêtre
		
		//champs de saisie visiteur et date
		
		pSaisie1 = new JPanel(new GridLayout(2,2));
		JLmatricule = new JLabel("Matricule Visiteur : ");
		JTmatricule = new JTextField(matricule);
		JTmatricule.addActionListener(this);
		JLdate = new JLabel("Date Visite : ");
		JTdate = new JTextField(date);
		JTdate.addActionListener(this);
		pSaisie1.add(JLmatricule);
		pSaisie1.add(JTmatricule);
		pSaisie1.add(JLdate);
		pSaisie1.add(JTdate);
		p.add(pSaisie1);
		
		//table des visites

		int i = 0;
		String[][] data = new String[nbLignes][3];
		for (Map.Entry<String,Visite> uneEntree : dicoVisite.entrySet())
		{
			data[i][0] = uneEntree.getValue().getReference();
			data[i][1] = uneEntree.getValue().getUnMedecin().getCodeMed() ;
			data[i][2] = uneEntree.getValue().getUnMedecin().getLaLocalite().getVille();
			i ++;
		}
		String[] columnNames = {"Référence", "Médecin", "Lieu"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(this);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie2 = new JPanel();
		JLrefVisite = new JLabel("Référence : ");
		JTrefVisite = new JTextField(20);
		JTrefVisite.setMaximumSize(JTrefVisite.getPreferredSize());
		JBafficherVisite = new JButton("Visite Détaillée");
		JBafficherVisite.addActionListener(this); // source d'évenement
		pSaisie2.add(JLrefVisite);
		pSaisie2.add(JTrefVisite);
		pSaisie2.add(JBafficherVisite);
		p.add(pSaisie2);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object source = arg0.getSource();
   		if (source == JBafficherVisite)
   		{
   			if (dicoVisite.containsKey(JTrefVisite.getText()))
   			{
   	   			Visite uneVisite = dicoVisite.get(JTrefVisite.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteRecapitulatif(fenetreContainer, uneVisite));
   			}
   		}
   		
   		if(source == JTmatricule || source == JTdate)
   		{
   			fenetreContainer.ouvrirFenetre(new JIFVisiteListe(fenetreContainer, JTmatricule.getText(), JTdate.getText()));
   		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JTrefVisite.setText((String)table.getValueAt(table.getSelectedRow(), 0));
	}
}
