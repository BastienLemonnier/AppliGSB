package gsb.vue;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.service.MedecinService;
import gsb.service.VisiteService;
import gsb.service.VisiteurService;

/**
* @author LEMONNIER Bastien
* 21 oct. 2021
*
*/
public class JIFMedecinAjout extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4976466054485124215L;
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JButton ajouter;
	
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLadresse;
	protected JLabel JLtelephone;
	protected JLabel JLcodeMedecin;
	protected JLabel JLpotentiel;
	protected JLabel JLspecialite;
	protected JLabel JLlaLocalite;
	
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTadresse;
	protected JTextField JTtelephone;
	protected JTextField JTcodeMedecin;
	protected JTextField JTpotentiel;
	protected JTextField JTspecialite;
	protected JComboBox<String> JClaLocalite;
	
	protected MenuPrincipal leMenu;
	
	protected TreeMap<String, Localite> lesLocalites;
	
	public JIFMedecinAjout(MenuPrincipal leMenu) {
		this.leMenu = leMenu;
		
		p = new JPanel(new GridBagLayout()); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridBagLayout());
		
		ajouter = new JButton("Ajouter");
		
		JLcodeMedecin = new JLabel("code Médecin");
		JLnom = new JLabel("nom");
		JLprenom = new JLabel("prenom");
		JLadresse = new JLabel("adresse");
		JLtelephone = new JLabel("telephone");
		JLpotentiel = new JLabel("potentiel");
		JLspecialite = new JLabel("specialité");
		JLlaLocalite = new JLabel("localite");
		
		JTcodeMedecin = new JTextField(5);
		JTcodeMedecin.setMaximumSize(JTcodeMedecin.getPreferredSize());
		JTnom = new JTextField(10);
		JTnom.setMaximumSize(JTnom.getPreferredSize());
		JTprenom = new JTextField(10);
		JTprenom.setMaximumSize(JTprenom.getPreferredSize());
		JTadresse = new JTextField(10);
		JTadresse.setMaximumSize(JTadresse.getPreferredSize());
		JTtelephone = new JTextField(10);
		JTtelephone.setMaximumSize(JTtelephone.getPreferredSize());
		JTpotentiel = new JTextField(10);
		JTpotentiel.setMaximumSize(JTpotentiel.getPreferredSize());
		JTspecialite = new JTextField(10);
		JTspecialite.setMaximumSize(JTspecialite.getPreferredSize());
		JClaLocalite = new JComboBox<String>();
		lesLocalites = LocaliteDao.dicoLocalites();
		for(String key : lesLocalites.keySet())
			JClaLocalite.addItem(key);
		
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(2,10,2,10);
		constraint.gridx = 0;
		constraint.gridy = 0;
		pTexte.add(JLcodeMedecin, constraint);
		constraint.gridy = 1;
		pTexte.add(JLnom, constraint);
		constraint.gridy = 2;
		pTexte.add(JLprenom, constraint);
		constraint.gridy = 3;
		pTexte.add(JLadresse, constraint);
		constraint.gridy = 4;
		pTexte.add(JLtelephone, constraint);
		constraint.gridy = 5;
		pTexte.add(JLpotentiel, constraint);
		constraint.gridy = 6;
		pTexte.add(JLspecialite, constraint);
		constraint.gridy = 7;
		pTexte.add(JLlaLocalite, constraint);
		constraint.gridx = 1;
		constraint.gridy = 0;
		pTexte.add(JTcodeMedecin, constraint);
		constraint.gridy = 1;
		pTexte.add(JTnom, constraint);
		constraint.gridy = 2;
		pTexte.add(JTprenom, constraint);
		constraint.gridy = 3;
		pTexte.add(JTadresse, constraint);
		constraint.gridy = 4;
		pTexte.add(JTtelephone, constraint);
		constraint.gridy = 5;
		pTexte.add(JTpotentiel, constraint);
		constraint.gridy = 6;
		pTexte.add(JTspecialite, constraint);
		constraint.gridy = 7;
		pTexte.add(JClaLocalite, constraint);
		
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
	
	public void remplirText(Medecin unMedecin) 	
	{ // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
		JTcodeMedecin.setText(unMedecin.getCodeMed());
		JTnom.setText(unMedecin.getNom());
		JTprenom.setText(unMedecin.getPrenom());
		JTadresse.setText(unMedecin.getAdresse());
		JTtelephone.setText(unMedecin.getTelephone());
		JTpotentiel.setText(unMedecin.getPotentiel());
		JTspecialite.setText(unMedecin.getSpecialite());
		JClaLocalite.setSelectedItem(unMedecin.getLaLocalite().getCodePostal());
	}
	
	public void viderText() 	
	{ // méthode qui permet de vider les zones de texte 
		JTcodeMedecin.setText("");
		JTnom.setText("");
		JTprenom.setText("");
		JTadresse.setText("");
		JTtelephone.setText("");
		JTpotentiel.setText("");
		JTspecialite.setText("");
		JClaLocalite.setSelectedItem("");
	}
	
	public Medecin recupMedecinDuText()
	{ // méthode qui permet de créer un objet visite à partir des champs de saisie
		String codeMedecin = JTcodeMedecin.getText();
		String nom = JTnom.getText();
		String prenom = JTprenom.getText();
		String adresse = JTadresse.getText();
		String telephone = JTtelephone.getText();
		String potentiel = JTpotentiel.getText();
		String specialite= JTspecialite.getText();
		String laLocalite = (String) JClaLocalite.getSelectedItem();
		
		
		
		Medecin unMedecin = new Medecin(codeMedecin, nom, prenom, adresse, telephone, potentiel, specialite, lesLocalites.get(laLocalite));
		return unMedecin;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == ajouter)
		{
			Medecin leMedecin = recupMedecinDuText();
			if(MedecinService.ajouterMedecin(leMedecin))
			{
				leMenu.ouvrirFenetre(new JIFMedecinFiche(leMedecin));
			}
			else
			{
				JOptionPane.showMessageDialog(leMenu, "Echec lors de l'ajout de la Visite !");
			}
			
		}
	}

}
