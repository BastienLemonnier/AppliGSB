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
	protected Localite uneLocalite;
	
	/**
	 * Constructeur du Médecin
	 * @param codeMed code du médecin
	 * @param nom nom du médecin
	 * @param prenom prénom du médecin
	 * @param adresse adresse du médecin
	 * @param telephone téléphone du médecin
	 * @param potentiel potentiel du médecin
	 * @param specialite spécialité du médecin
	 * @param uneLocalite Localite du médecin
	 */
	public Medecin(String codeMed, String nom, String prenom, String adresse, String telephone, String potentiel,
			String specialite, Localite uneLocalite) {
		this.codeMed = codeMed;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.potentiel = potentiel;
		this.specialite = specialite;
		this.uneLocalite = uneLocalite;
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
	 * 
	 * @return
	 */
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPotentiel() {
		return potentiel;
	}

	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Localite getUneLocalite() {
		return uneLocalite;
	}

	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}
	
	
	
}
