/**
 *
 * Créé le 25 oct. 2021
 *
 */
package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.service.MedicamentService;
import gsb.service.OffrirService;
import gsb.service.VisiteService;

/**
 * @author LEMONNIER Bastien
 * 25 oct. 2021
 *
 */
public class JIFVisiteOffres extends JInternalFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2154252726365388910L;
	
	protected JPanel p;
	
	protected JPanel pSaisie1;
	protected JLabel JLreference;
	protected JTextField JTreference;
	
	protected JPanel pSaisie2;
	protected JLabel JLdepotLegal;
	protected JTextField JTdepotLegal;
	protected JLabel JLquantite;
	protected JTextField JTquantite;
	
	protected JPanel pBoutons;
	protected JButton ajouter;
	
	protected JScrollPane scrollPane;
	private TreeMap<String, Offrir> dicoOffres;
	protected JTable table;
	
	protected JPanel pBoutonsBas;
	protected JButton visite;
	
	protected MenuPrincipal fenetreContainer;
	
	public JIFVisiteOffres(MenuPrincipal fenetreContainer, Visite uneVisite)
	{
		this.fenetreContainer = fenetreContainer;
		
		p = new JPanel(new GridBagLayout());
		
		JLreference = new JLabel("Référence : ");
		JTreference = new JTextField(uneVisite.getReference());
		JTreference.addActionListener(this);
		
		pSaisie1 = new JPanel(new GridLayout(1,2));
		pSaisie1.add(JLreference);
		pSaisie1.add(JTreference);
		
		JLdepotLegal = new JLabel("Dépôt légal : ");
		JTdepotLegal = new JTextField();
		JLquantite = new JLabel("Quantité : ");
		JTquantite = new JTextField();
		
		pSaisie2 = new JPanel(new GridLayout(2,2));
		pSaisie2.add(JLdepotLegal);
		pSaisie2.add(JTdepotLegal);
		pSaisie2.add(JLquantite);
		pSaisie2.add(JTquantite);
		
		ajouter = new JButton("Ajouter");
		ajouter.addActionListener(this);
		pBoutons = new JPanel();
		pBoutons.add(ajouter);
		
		dicoOffres = OffrirService.rechercherOffresVisite(uneVisite.getReference());
		int nbLignes = dicoOffres.size();
		int i = 0;
		String[][] data = new String[nbLignes][2] ;
		for (Map.Entry<String,Offrir> uneEntree : dicoOffres.entrySet())
		{
			data[i][0] = uneEntree.getValue().getUnMedicament().getDepotLegal();
			data[i][1] = String.valueOf(uneEntree.getValue().getQteOfferte());
			i ++;
		}
		String[] columnNames = {"Dépôt Légal", "Quantité"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(this);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		scrollPane.setMinimumSize(new Dimension(300, 150));
		
		visite = new JButton("Fiche Visite");
		visite.addActionListener(this);
		pBoutonsBas = new JPanel();
		pBoutonsBas.add(visite);
		
		Container contentPane = getContentPane();
		GridBagConstraints pConstraint = new GridBagConstraints();
		pConstraint.insets = new Insets(7,0,7,0);
		pConstraint.gridwidth = 2;
		pConstraint.gridx = 0;
		pConstraint.gridy = 0;
		p.add(pSaisie1, pConstraint);
		pConstraint.gridwidth = 1;
		pConstraint.gridy = 1;
		p.add(pSaisie2, pConstraint);
		pConstraint.gridx = 1;
		pConstraint.gridy = 1;
		p.add(pBoutons, pConstraint);
		pConstraint.gridwidth = 2;
		pConstraint.gridx = 0;
		pConstraint.gridy = 2;
		p.add(scrollPane, pConstraint);
		pConstraint.gridy = 3;
		p.add(pBoutonsBas, pConstraint);
		contentPane.add(p);
	}
	
	private Offrir offreFromFields()
	{
		Medicament leMedicament = MedicamentService.rechercher(JTdepotLegal.getText());
		Visite laVisite = VisiteService.rechercherVisite(JTreference.getText());
		int quantite = Integer.parseInt(JTquantite.getText());
		Offrir offre = new Offrir(leMedicament, laVisite, quantite);
		return offre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == ajouter)
		{
			OffrirService.inserer(offreFromFields());
			fenetreContainer.ouvrirFenetre(new JIFVisiteOffres(fenetreContainer, VisiteService.rechercherVisite(JTreference.getText())));
		}
		if(source == JTreference)
		{
			fenetreContainer.ouvrirFenetre(new JIFVisiteOffres(fenetreContainer, VisiteService.rechercherVisite(JTreference.getText())));
		}
		if(source == visite)
		{
			fenetreContainer.ouvrirFenetre(new JIFVisiteRecapitulatif(fenetreContainer, VisiteService.rechercherVisite(JTreference.getText())));
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
