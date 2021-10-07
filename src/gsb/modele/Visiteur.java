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
	 * Prénom du Visiteur
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
	 * Téléphone du Visiteur
	 */
	protected String telephone;
	/**
	 * Date d'entrée du Visiteur
	 */
	protected String dateEntree;
	/**
	 * Prime du Visiteur
	 */
	protected int prime;
	/**
	 * Code de l'unitée du Visiteur
	 */
	protected String codeUnite;
	/**
	 * Nom de l'unitée du Visiteur
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
	 * @param telephone numéro de téléphone du Visiteur
	 * @param dateEntree date d'entrée du Visiteur
	 * @param prime prime du Visiteur
	 * @param codeUnite code de l'unitée du Visiteur
	 * @param nomUnite nom de l'unitée du Visiteur
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
	 * Getter du prénom
	 * @return prénom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter du prénom
	 * @param prenom nouveau prénom
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
	 * Getter de la localité
	 * @return localité
	 */
	public Localite getUneLocalite() {
		return uneLocalite;
	}

	/**
	 * Setter de la localité
	 * @param uneLocalite nouvelle localité
	 */
	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}

	/**
	 * Getter du numéro de téléphone
	 * @return numéro de téléphone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du numéro de téléphone
	 * @param telephone nouveau numéro de téléphone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de la date d'entrée
	 * @return date d'entrée
	 */
	public String getDateEntree() {
		return dateEntree;
	}

	/**
	 * Setter du la date d'entrée
	 * @param dateEntree nouvelle date d'entrée
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
	 * Getter du code de l'unitée
	 * @return code de l'unitée
	 */
	public String getCodeUnite() {
		return codeUnite;
	}

	/**
	 * Setter du code de l'unitée
	 * @param codeUnite
	 */
	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}

	/**
	 * Getter du nom de l'unitée
	 * @return nom de l'unitée
	 */
	public String getNomUnite() {
		return nomUnite;
	}

	/**
	 * Setter du nom de l'unitée
	 * @param nomUnite nouveau nom de l'unitée
	 */
	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}
	
	
}
