package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
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
import gsb.service.MedicamentService;

public class JIFMedicamentListe extends JInternalFrame implements ActionListener, ListSelectionListener {
	
private static final long serialVersionUID = 3630L;
	
	private TreeMap<String,Medicament> dicoMedicament;


	protected JPanel p; //panel principal
	
	protected JScrollPane scrollPane;
	
	protected JPanel pSaisie2;
	protected JLabel JLrefMedicament;
	protected JTextField JTrefMedicament;
	protected JButton JBafficherMedicament;
	protected JButton JBstockMedicament;
	
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFMedicamentListe(MenuPrincipal uneFenetreContainer)
	{

		fenetreContainer = uneFenetreContainer;
		
		dicoMedicament = MedicamentService.recupListe();
		int nbLignes = dicoMedicament.size();
		
		p = new JPanel(); // panneau principal de la fenêtre
		
		//table des visites

		int i = 0;
		String[][] data = new String[nbLignes][3];
		for (Map.Entry<String,Medicament> uneEntree : dicoMedicament.entrySet())
		{
			data[i][0] = uneEntree.getValue().getDepotLegal();
			data[i][1] = uneEntree.getValue().getNomCommercial();
			data[i][2] = uneEntree.getValue().getLibelleFamille();
			i ++;
		}
		String[] columnNames = {"Code", "Nom", "Famille"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(this);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie2 = new JPanel();
		JLrefMedicament = new JLabel("Code : ");
		JTrefMedicament = new JTextField(20);
		JTrefMedicament.setMaximumSize(JTrefMedicament.getPreferredSize());
		JBafficherMedicament = new JButton("Médicament Détaillée");
		JBafficherMedicament.addActionListener(this); // source d'évenement
		JBstockMedicament = new JButton("Stocks Médicament");
		JBstockMedicament.addActionListener(this);
		pSaisie2.add(JLrefMedicament);
		pSaisie2.add(JTrefMedicament);
		pSaisie2.add(JBafficherMedicament);
		pSaisie2.add(JBstockMedicament);
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
   		if (source == JBafficherMedicament)
   		{
   			if (dicoMedicament.containsKey(JTrefMedicament.getText()))
   			{
   	   			Medicament unMedicament = dicoMedicament.get(JTrefMedicament.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(fenetreContainer, unMedicament));
   			}
   		}
   		
   		if(source == JBstockMedicament)
   		{
   			fenetreContainer.ouvrirFenetre(new JIFMedicamentStock(fenetreContainer, JTrefMedicament.getText(), ""));
   		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		JTrefMedicament.setText((String)table.getValueAt(table.getSelectedRow(), 0));
	}
	
}
