package gsb.modele;

/**
 * 
 * @author PAJOT Arthur
 *
 */

public class Offrir {
	/**
	 * les m�dicaments
	 */
	protected Medicament unMedicament;
	/**
	 * les visites
	 */
	protected Visite uneVisite;
	/**
	 * la quantit�e offerte
	 */
	protected int qteOfferte;
	
	/**
	 * constructeur d'offrir
	 * @param unMedicament
	 * @param uneVisite
	 * @param qteOfferte
	 */
	public Offrir(Medicament unMedicament, Visite uneVisite, int qteOfferte) {
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
		this.qteOfferte = qteOfferte;
	}

	/**
	 * getter du medicament
	 * @return unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 * setter du m�dicament
	 * @param unMedicament
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	/**
	 * getter d'une visite
	 * @return
	 */
	public Visite getUneVisite() {
		return uneVisite;
	}

	/**
	 * setter d'une visite 
	 * @param uneVisite
	 */
	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}

	/**
	 * getter d'une quantit� offerte
	 * @return
	 */
	public int getQteOfferte() {
		return qteOfferte;
	}

	/**
	 * setter d'une quantit�e offerte
	 * @param qteOfferte
	 */
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
	
	

}
