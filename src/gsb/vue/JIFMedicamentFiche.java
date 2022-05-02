/**
 *
 * Créé le 12 dec. 2021
 *
 */
package gsb.vue;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;

public class JIFMedicamentFiche extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 326597107518661843L;
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JButton modifier;
	protected JButton offres;
	
	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndications;
	protected JLabel JLcodeFamille;
	protected JLabel JLlibelleFamille;
	protected JLabel JLnmbCond;
	protected JLabel JLdc;
	
	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndications;
	protected JTextField JTcodeFamille;
	protected JTextField JTlibelleFamille;
	protected JTextField JTnmbCond;
	protected JTextField JTdc;
	
	protected MenuPrincipal fenetreContainer;
	
	public JIFMedicamentFiche(MenuPrincipal uneFenetreContainer, Medicament unMedicament) {
		fenetreContainer = uneFenetreContainer;
		p = new JPanel(new GridBagLayout()); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridBagLayout());
		
		JLdepotLegal = new JLabel("Dépot Legal");
		JLnomCommercial = new JLabel("Nom Commercial");
		JLcomposition = new JLabel("Composition");
		JLeffets = new JLabel("Effets");
		JLcontreIndications = new JLabel("Contre Indications");
		JLcodeFamille = new JLabel("Code Famille");
		JLlibelleFamille = new JLabel("Libelle Famille");
		JLnmbCond = new JLabel("Nombre de conditionnements");
		JLdc = new JLabel("Dénomination Commune");

		//JTcommentaire.setMaximumSize(JTcommentaire.getPreferredSize());
		JTdepotLegal = new JTextField(10);
		JTnomCommercial = new JTextField(20);
		JTnomCommercial.setEditable(false);
		JTcomposition = new JTextField(20);
		JTcomposition.setEditable(false);
		JTeffets = new JTextField(20);
		JTeffets.setEditable(false);
		JTcontreIndications = new JTextField(20);
		JTcontreIndications.setEditable(false);
		JTcodeFamille = new JTextField(20);
		JTcodeFamille.setEditable(false);
		JTlibelleFamille = new JTextField(20);
		JTlibelleFamille.setEditable(false);
		JTnmbCond = new JTextField(20);
		JTnmbCond.setEditable(false);
		JTdc = new JTextField(20);
		JTdc.setEditable(false);
		
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(2,10,2,10);
		constraint.gridx = 0;
		constraint.gridy = 0;
		pTexte.add(JLdepotLegal, constraint);
		constraint.gridy = 1;
		pTexte.add(JLnomCommercial, constraint);
		constraint.gridy = 2;
		pTexte.add(JLcomposition, constraint);
		constraint.gridy = 3;
		pTexte.add(JLeffets, constraint);
		constraint.gridy = 4;
		pTexte.add(JLcontreIndications, constraint);
		constraint.gridy = 5;
		pTexte.add(JLcodeFamille, constraint);
		constraint.gridy = 6;
		pTexte.add(JLlibelleFamille, constraint);
		constraint.gridy = 7;
		pTexte.add(JLnmbCond, constraint);
		constraint.gridy = 8;
		pTexte.add(JLdc, constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		pTexte.add(JTdepotLegal, constraint);
		constraint.gridy = 1;
		pTexte.add(JTnomCommercial, constraint);
		constraint.gridy = 2;
		pTexte.add(JTcomposition, constraint);
		constraint.gridy = 3;
		pTexte.add(JTeffets, constraint);
		constraint.gridy = 4;
		pTexte.add(JTcontreIndications, constraint);
		constraint.gridy = 5;
		pTexte.add(JTcodeFamille, constraint);
		constraint.gridy = 6;
		pTexte.add(JTlibelleFamille, constraint);
		constraint.gridy = 7;
		pTexte.add(JTnmbCond, constraint);
		constraint.gridy = 8;
		pTexte.add(JTdc, constraint);
		
		// mise en forme de la fenêtre

		Container contentPane = getContentPane();
		GridBagConstraints pConstraint = new GridBagConstraints();
		pConstraint.insets = new Insets(10,0,10,0);
		pConstraint.gridx = 0;
		pConstraint.gridy = 0;
		p.add(pTexte, pConstraint);
		pConstraint.gridy = 1;
		p.add(pBoutons, pConstraint);
		contentPane.add(p);
		
		remplirText(unMedicament);
	
	}
	
	public void remplirText(Medicament unMedicament) 	
	{ // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
		JTdepotLegal.setText(unMedicament.getDepotLegal());
		JTnomCommercial.setText(unMedicament.getNomCommercial());
		JTcomposition.setText(unMedicament.getComposition());
		JTeffets.setText(unMedicament.getEffets());
		JTcontreIndications.setText("");
		JTcodeFamille.setText(unMedicament.getCodeFamille());
		JTlibelleFamille.setText(unMedicament.getLibelleFamille());
		JTnmbCond.setText(Integer.toString(unMedicament.getNmbConditionnements()));
		JTdc.setText(unMedicament.getDc());
	}
}
