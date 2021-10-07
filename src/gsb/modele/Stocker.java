package gsb.modele;

/**
 * 
 * @author PAJOT Arthur
 *
 */

public class Stocker {
	/**
	 * La quantit� des stock
	 */
	protected int qteStock; 
	/**
	 * les visiteurs
	 */
	public Visiteur unVisiteur; 
	/**
	 * les medicament
	 */
	public Medicament unMedicament;
	
	/**
	 * constructeur du stocker
	 * @param qteStock
	 * @param unVisiteur
	 * @param unMedicament
	 */
	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		super();
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}

	/**
	 * getter de la quantit�e stock�e
	 * @return quantit� stock�
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * setter de la quantit�e stock�e
	 * @param qteStock
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	/**
	 * getter du visiteur
	 * @return un visiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	/**
	 * setter du visiteur
	 * @param unVisiteur
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	/**
	 * getter du m�dicament
	 * @return un medicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 * setter du medicament
	 * @param unMedicament
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	

}
