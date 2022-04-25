package gsb.modele;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class Medecin {
	/**
	 * Code du médecin
	 */
	protected String codeMed;
	/**
	 * Nom du Médecin
	 */
	protected String nom;
	/**
	 * Prénom du Médecin
	 */
	protected String prenom;
	/**
	 * Adresse du médecin
	 */
	protected String adresse;
	/**
	 * Téléphone du Médecin
	 */
	protected String telephone;
	/**
	 * Potentiel du Médecin
	 */
	protected String potentiel;
	/**
	 * Spécialité du Médecin
	 */
	protected String specialite;
	/**
	 * Localite du Médecin
	 */
	protected Localite laLocalite;
	
	/**
	 * Constructeur du Médecin
	 * @param codeMed code du médecin
	 * @param nom nom du médecin
	 * @param prenom prénom du médecin
	 * @param adresse adresse du médecin
	 * @param telephone téléphone du médecin
	 * @param potentiel potentiel du médecin
	 * @param specialite spécialité du médecin
	 * @param laLocalite Localite du médecin
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
	 * Getter du code du médecin
	 * @return code du médecin
	 */
	public String getCodeMed() {
		return codeMed;
	}
	
	/**
	 * Setter du code du médecin
	 * @param codeMed nouveau code du médecin
	 */
	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
	}
	
	/**
	 * Getter du nom du médecin
	 * @return nom du médecin
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom du médecin
	 * @param nom nouveau nom du médecin
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter du prénom du médecin
	 * @return prénom du médecin
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter du prénom du médecin
	 * @param prenom nouveau prénom du médecin
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'adresse du médecin
	 * @return adresse du médecin
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter de l'adresse du médecin
	 * @param adresse nouvelle adresse du médecin
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter du numéro de téléphone du médecin
	 * @return numéro de téléphone du médecin
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du numéro de téléphone du médecin
	 * @param telephone nouveau numéro de téléphone du médecin
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter du potentiel du médecin
	 * @return potentiel du médecin
	 */
	public String getPotentiel() {
		return potentiel;
	}

	/**
	 * Setter du potentiel du médecin
	 * @param potentiel nouveau potentiel du médecin
	 */
	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}

	/**
	 * Getter de la spécialité du médecin
	 * @return spécialité du médecin
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * Setter de la spécialité du médecin
	 * @param specialite nouvelle spécialité du médecin
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	/**
	 * Getter de la localité du médecin
	 * @return localité du médecin
	 */
	public Localite getLaLocalite() {
		return laLocalite;
	}

	/**
	 * Setter du la localité du médecin
	 * @param laLocalite nouvelle localité du médecin
	 */
	public void setLaLocalite(Localite laLocalite) {
		this.laLocalite = laLocalite;
	}
	
	
	
}
