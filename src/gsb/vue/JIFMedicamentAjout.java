package gsb.vue;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.service.MedecinService;
import gsb.service.MedicamentService;
import gsb.service.VisiteService;
import gsb.service.VisiteurService;

/**
 * @author LEMONNIER Bastien
 * 21 oct. 2021
 *
 */
public class JIFMedicamentAjout extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4976466054485124215L;
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JButton ajouter;
	
	protected JLabel JLDepotLegal;
	protected JLabel JLnomCom;
	protected JLabel JLeffet;
	protected JLabel JLcomp;
	protected JLabel JLprix;
	protected JLabel JLlibelle;
	protected JLabel JLcodFam;
	
	protected JTextField JTDepotLegal;
	protected JTextField JTnomCom;
	protected JTextArea JTeffet;
	protected JTextField JTcomp;
	protected JTextField JTprix;
	protected JTextField JTlibelle;
	protected JTextField JTcodFam;
	
	public JIFMedicamentAjout() {
		p = new JPanel(new GridBagLayout()); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridBagLayout());
		
		ajouter = new JButton("Ajouter");
		
		JLDepotLegal = new JLabel("depotLegal");
		JLnomCom = new JLabel("nomCom");
		JLeffet = new JLabel("effet");
		JLcomp = new JLabel("comp");
		JLprix = new JLabel("prix échantillion");
		JLlibelle = new JLabel("libelle Famille");
		JLcodFam = new JLabel("code Famille");
		
		JTDepotLegal = new JTextField(5);
		JTDepotLegal.setMaximumSize(JTDepotLegal.getPreferredSize());
		JTnomCom = new JTextField(10);
		JTnomCom.setMaximumSize(JTnomCom.getPreferredSize());
		JTeffet = new JTextArea(5, 20);
		JTeffet.setMaximumSize(JTeffet.getPreferredSize());
		JTcomp = new JTextField(4);
		JTcomp.setMaximumSize(JTcomp.getPreferredSize());
		JTprix = new JTextField(4);
		JTprix.setMaximumSize(JTprix.getPreferredSize());
		JTlibelle = new JTextField(5);
		JTlibelle.setMaximumSize(JTlibelle.getPreferredSize());
		JTcodFam = new JTextField(6);
		JTcodFam.setMaximumSize(JTcodFam.getPreferredSize());
		
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(2,10,2,10);
		constraint.gridx = 0;
		constraint.gridy = 0;
		pTexte.add(JLDepotLegal, constraint);
		constraint.gridy = 1;
		pTexte.add(JLnomCom, constraint);
		constraint.gridy = 2;
		pTexte.add(JLeffet, constraint);
		constraint.gridy = 3;
		pTexte.add(JLcomp, constraint);
		constraint.gridy = 4;
		pTexte.add(JLprix, constraint);
		constraint.gridy = 5;
		pTexte.add(JLlibelle, constraint);
		constraint.gridy = 6;
		pTexte.add(JLcodFam, constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		pTexte.add(JTDepotLegal, constraint);
		constraint.gridy = 1;
		pTexte.add(JTnomCom, constraint);
		constraint.gridy = 2;
		pTexte.add(JTeffet, constraint);
		constraint.gridy = 3;
		pTexte.add(JTcomp, constraint);
		constraint.gridy = 4;
		pTexte.add(JTprix, constraint);
		constraint.gridy = 5;
		pTexte.add(JLlibelle, constraint);
		constraint.gridy = 6;
		pTexte.add(JLlibelle, constraint);
		
        pBoutons.add(ajouter);
        ajouter.addActionListener(this);
		
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
	
	}
	
	public void remplirText(Medicament unMedicament) 	
	{ // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
		JTDepotLegal.setText(unMedicament.getNomCommercial());
		JTnomCom.setText(unMedicament.getDepotLegal());
		JTeffet.setText(unMedicament.getEffets());
		JTcomp.setText(unMedicament.getComposition());
		JTprix.setText(unMedicament.getEffets());
		JTlibelle.setText(unMedicament.getLibelleFamille());
	}
	
	public void viderText() 	
	{ // méthode qui permet de vider les zones de texte 
		JTDepotLegal.setText("");
		JTnomCom.setText("");
		JTeffet.setText("");
		JTcomp.setText("");
		JTprix.setText("");
		JTlibelle.setText("");
	}
	
	public Medicament recupMedicamentDuText()
	{ // méthode qui permet de créer un objet visite à partir des champs de saisie
		String DepotLegal = JTDepotLegal.getText();
		String nomCom = JTnomCom.getText();
		String effet = JTeffet.getText();
		String comp = JTcomp.getText();
		float prix = Float.valueOf(JTprix.getText());
		String libelle = JTlibelle.getText();
		String codFam = JTcodFam.getText();
		Medicament unMedicament = new Medicament(DepotLegal, nomCom, effet, comp, prix, libelle, codFam);
		return unMedicament;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == ajouter)
		{
			MedicamentService.ajouterMedicament(recupMedicamentDuText());
		}
	}

}

