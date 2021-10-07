package gsb.modele;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class Visiteur {
	
	/**
	 * Matricule du Visiteur
	 */
	protected String matricule;
	/**
	 * Nom du visiteur
	 */
	protected String nom;
	/**
	 * Pr�nom du Visiteur
	 */
	protected String prenom;
	/**
	 * Login du Visiteur
	 */
	protected String login;
	/**
	 * Mot de passe du Visiteur
	 */
	protected String mdp;
	/**
	 * Adresse du Visiteur
	 */
	protected String adresse;
	/**
	 * Localite du Visiteur
	 */
	protected Localite uneLocalite;
	/**
	 * T�l�phone du Visiteur
	 */
	protected String telephone;
	/**
	 * Date d'entr�e du Visiteur
	 */
	protected String dateEntree;
	/**
	 * Prime du Visiteur
	 */
	protected int prime;
	/**
	 * Code de l'unit�e du Visiteur
	 */
	protected String codeUnite;
	/**
	 * Nom de l'unit�e du Visiteur
	 */
	protected String nomUnite;
	
	/**
	 * Constructeur du Visiteur
	 * @param matricule matricule du Visiteur
	 * @param nom nom du Visiteur
	 * @param prenom prenom du Visiteur
	 * @param login login du Visiteur
	 * @param mdp mot de passe du Visiteur
	 * @param adresse adresse du Visiteur
	 * @param uneLocalite Localite du Visiteur
	 * @param telephone num�ro de t�l�phone du Visiteur
	 * @param dateEntree date d'entr�e du Visiteur
	 * @param prime prime du Visiteur
	 * @param codeUnite code de l'unit�e du Visiteur
	 * @param nomUnite nom de l'unit�e du Visiteur
	 */
	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse,
			Localite uneLocalite, String telephone, String dateEntree, int prime, String codeUnite, String nomUnite) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.uneLocalite = uneLocalite;
		this.telephone = telephone;
		this.dateEntree = dateEntree;
		this.prime = prime;
		this.codeUnite = codeUnite;
		this.nomUnite = nomUnite;
	}

	/**
	 * Getter du matricule
	 * @return matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter du matricule
	 * @param matricule nouveau matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter du nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom
	 * @param nom nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter du pr�nom
	 * @return pr�nom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter du pr�nom
	 * @param prenom nouveau pr�nom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter du login
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter du login
	 * @param login nouveau login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter du mot de passe
	 * @return mot de passe
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Setter du mot de passe
	 * @param mdp nouveau mot de passe
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Getter de l'adresse
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter de l'adresse
	 * @param adresse nouvelle adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter de la localit�
	 * @return localit�
	 */
	public Localite getUneLocalite() {
		return uneLocalite;
	}

	/**
	 * Setter de la localit�
	 * @param uneLocalite nouvelle localit�
	 */
	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}

	/**
	 * Getter du num�ro de t�l�phone
	 * @return num�ro de t�l�phone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du num�ro de t�l�phone
	 * @param telephone nouveau num�ro de t�l�phone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de la date d'entr�e
	 * @return date d'entr�e
	 */
	public String getDateEntree() {
		return dateEntree;
	}

	/**
	 * Setter du la date d'entr�e
	 * @param dateEntree nouvelle date d'entr�e
	 */
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	/**
	 * Getter de la prime
	 * @return prime
	 */
	public int getPrime() {
		return prime;
	}

	/**
	 * Setter de la prime
	 * @param prime nouvelle prime
	 */
	public void setPrime(int prime) {
		this.prime = prime;
	}

	/**
	 * Getter du code de l'unit�e
	 * @return code de l'unit�e
	 */
	public String getCodeUnite() {
		return codeUnite;
	}

	/**
	 * Setter du code de l'unit�e
	 * @param codeUnite
	 */
	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}

	/**
	 * Getter du nom de l'unit�e
	 * @return nom de l'unit�e
	 */
	public String getNomUnite() {
		return nomUnite;
	}

	/**
	 * Setter du nom de l'unit�e
	 * @param nomUnite nouveau nom de l'unit�e
	 */
	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}
	
	
}
