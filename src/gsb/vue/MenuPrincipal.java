/*
 * Cr?? le 22 f?vr. 2015
 *
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 f?vr. 2015
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;

	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame ? la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(500, 400);

		// Ajout d'une barre de menus ? la fen?tre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un ?couteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Liste Medicaments");
		mE1.addActionListener(this); // installation d'un ?couteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Liste Visites");
		mA1.addActionListener(this); // installation d'un ?couteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout Visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() instanceof JMenuItem)
		{
			String ChoixOption = evt.getActionCommand();
			
			switch(ChoixOption)
			{
				case "Consultation Medecin":
					ouvrirFenetre(new JIFMedecinCons());
					break;
				case "Liste Medecins":
					ouvrirFenetre(new JIFMedecinListeDic(this));
					break;
				case "Liste Medicaments":
					ouvrirFenetre(new JIFMedicamentListe(this));
					break;
				case "Ajout Medicaments":
					ouvrirFenetre(new JIFMedicamentAjout());
					break;
				case "Liste Visites" : 
					ouvrirFenetre(new JIFVisiteListe(this, "", ""));
					break;
				case "Ajout Visite":
					ouvrirFenetre(new JIFVisiteAjout(this));
					break;
			}
		}
	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fen?tre ?tait dej? affich?e, elle
									// est lib?r?e
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}
	
	public static void main(String[] args)
	{
		new MenuPrincipal();
	}

}
