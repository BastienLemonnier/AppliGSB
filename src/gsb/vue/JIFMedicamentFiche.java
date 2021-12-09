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
import javax.swing.JTextArea;
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
	
	protected JLabel JLreference;
	protected JLabel JLdateVisite;
	protected JLabel JLmatricule;
	protected JLabel JLcodeMedecin;
	protected JLabel JLcommentaire;
	
	protected JTextField JTreference;
	protected JTextField JTdateVisite;
	protected JTextField JTmatricule;
	protected JTextField JTcodeMedecin;
	protected JTextArea JTcommentaire;
	
	protected MenuPrincipal fenetreContainer;
	
	public JIFMedicamentFiche(MenuPrincipal uneFenetreContainer, Medicament unMedicament) {
		fenetreContainer = uneFenetreContainer;
		p = new JPanel(new GridBagLayout()); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridBagLayout());
		
		JLreference = new JLabel("Dépot Legal");
		JLdateVisite = new JLabel("Nom Commercial");
		JLmatricule = new JLabel("Nom Molécule");
		JLcodeMedecin = new JLabel("Code");
		JLcommentaire = new JLabel("Libelle");
		
		JTreference = new JTextField(5);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JTdateVisite = new JTextField(10);
		JTdateVisite.setMaximumSize(JTdateVisite.getPreferredSize());
		JTdateVisite.setEditable(false);
		JTmatricule = new JTextField(4);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTmatricule.setEditable(false);
		JTcodeMedecin = new JTextField(4);
		JTcodeMedecin.setMaximumSize(JTcodeMedecin.getPreferredSize());
		JTcodeMedecin.setEditable(false);
		JTcommentaire = new JTextArea(5, 20);
		JTcommentaire.setMaximumSize(JTcommentaire.getPreferredSize());
		JTcommentaire.setEditable(false);
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(2,10,2,10);
		constraint.gridx = 0;
		constraint.gridy = 0;
		pTexte.add(JLreference, constraint);
		constraint.gridy = 1;
		pTexte.add(JLdateVisite, constraint);
		constraint.gridy = 2;
		pTexte.add(JLmatricule, constraint);
		constraint.gridy = 3;
		pTexte.add(JLcodeMedecin, constraint);
		constraint.gridy = 4;
		pTexte.add(JLcommentaire, constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		pTexte.add(JTreference, constraint);
		constraint.gridy = 1;
		pTexte.add(JTdateVisite, constraint);
		constraint.gridy = 2;
		pTexte.add(JTmatricule, constraint);
		constraint.gridy = 3;
		pTexte.add(JTcodeMedecin, constraint);
		constraint.gridy = 4;
		pTexte.add(JTcommentaire, constraint);
		
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
		JTreference.setText(unMedicament.getDepotLegal());
		JTdateVisite.setText(unMedicament.getNomCommercial());
		JTmatricule.setText(unMedicament.getComposition());
		JTcodeMedecin.setText(unMedicament.getCodeFamille());
		JTcommentaire.setText(unMedicament.getLibelleFamille());
	}
}
