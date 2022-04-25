package gsb.modele;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class Medecin {
	/**
	 * Code du m�decin
	 */
	protected String codeMed;
	/**
	 * Nom du M�decin
	 */
	protected String nom;
	/**
	 * Pr�nom du M�decin
	 */
	protected String prenom;
	/**
	 * Adresse du m�decin
	 */
	protected String adresse;
	/**
	 * T�l�phone du M�decin
	 */
	protected String telephone;
	/**
	 * Potentiel du M�decin
	 */
	protected String potentiel;
	/**
	 * Sp�cialit� du M�decin
	 */
	protected String specialite;
	/**
	 * Localite du M�decin
	 */
	protected Localite laLocalite;
	
	/**
	 * Constructeur du M�decin
	 * @param codeMed code du m�decin
	 * @param nom nom du m�decin
	 * @param prenom pr�nom du m�decin
	 * @param adresse adresse du m�decin
	 * @param telephone t�l�phone du m�decin
	 * @param potentiel potentiel du m�decin
	 * @param specialite sp�cialit� du m�decin
	 * @param laLocalite Localite du m�decin
	 */
	public Medecin(String codeMed, String nom, String prenom, String adresse, String telephone, String potentiel,
			String specialite, Localite laLocalite) {
		this.codeMed = codeMed;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.potentiel = potentiel;
		this.specialite = specialite;
		this.laLocalite = laLocalite;
	}

	/**
	 * Getter du code du m�decin
	 * @return code du m�decin
	 */
	public String getCodeMed() {
		return codeMed;
	}
	
	/**
	 * Setter du code du m�decin
	 * @param codeMed nouveau code du m�decin
	 */
	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
	}
	
	/**
	 * Getter du nom du m�decin
	 * @return nom du m�decin
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom du m�decin
	 * @param nom nouveau nom du m�decin
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter du pr�nom du m�decin
	 * @return pr�nom du m�decin
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter du pr�nom du m�decin
	 * @param prenom nouveau pr�nom du m�decin
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'adresse du m�decin
	 * @return adresse du m�decin
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter de l'adresse du m�decin
	 * @param adresse nouvelle adresse du m�decin
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter du num�ro de t�l�phone du m�decin
	 * @return num�ro de t�l�phone du m�decin
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du num�ro de t�l�phone du m�decin
	 * @param telephone nouveau num�ro de t�l�phone du m�decin
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter du potentiel du m�decin
	 * @return potentiel du m�decin
	 */
	public String getPotentiel() {
		return potentiel;
	}

	/**
	 * Setter du potentiel du m�decin
	 * @param potentiel nouveau potentiel du m�decin
	 */
	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}

	/**
	 * Getter de la sp�cialit� du m�decin
	 * @return sp�cialit� du m�decin
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * Setter de la sp�cialit� du m�decin
	 * @param specialite nouvelle sp�cialit� du m�decin
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	/**
	 * Getter de la localit� du m�decin
	 * @return localit� du m�decin
	 */
	public Localite getLaLocalite() {
		return laLocalite;
	}

	/**
	 * Setter du la localit� du m�decin
	 * @param laLocalite nouvelle localit� du m�decin
	 */
	public void setLaLocalite(Localite laLocalite) {
		this.laLocalite = laLocalite;
	}
	
	
	
}
