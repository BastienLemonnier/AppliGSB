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
	protected Localite uneLocalite;
	
	/**
	 * Constructeur du M�decin
	 * @param codeMed code du m�decin
	 * @param nom nom du m�decin
	 * @param prenom pr�nom du m�decin
	 * @param adresse adresse du m�decin
	 * @param telephone t�l�phone du m�decin
	 * @param potentiel potentiel du m�decin
	 * @param specialite sp�cialit� du m�decin
	 * @param uneLocalite Localite du m�decin
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
