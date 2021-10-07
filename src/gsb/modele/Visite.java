package gsb.modele;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class Visite {

	/**
	 * R�f�rence de la visite
	 */
	protected String reference;
	/**
	 * Date de la visite
	 */
	protected String date;
	/**
	 * Commentaire de la visite
	 */
	protected String commentaire;
	/**
	 * M�decin visit�
	 */
	protected Medecin unMedecin;
	/**
	 * Visiteur de la visite
	 */
	protected Visiteur unVisiteur;
	
	/**
	 * Constructeur de la visite
	 * @param reference r�f�rence
	 * @param date date
	 * @param commentaire commentaire
	 * @param unMedecin m�decin
	 * @param unVisiteur visiteur
	 */
	public Visite(String reference, String date, String commentaire, Medecin unMedecin, Visiteur unVisiteur) {
		this.reference = reference;
		this.date = date;
		this.commentaire = commentaire;
		this.unMedecin = unMedecin;
		this.unVisiteur = unVisiteur;
	}

	/**
	 * Getter de la r�f�rence
	 * @return r�f�rence
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Setter de la r�f�rence
	 * @param reference nouvelle r�f�rence
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Getter de la date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter de la date
	 * @param date nouvelle date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Getter du commentaire
	 * @return commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Setter du commentaire
	 * @param commentaire nouveau commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * Getter du m�decin
	 * @return m�decin
	 */
	public Medecin getUnMedecin() {
		return unMedecin;
	}

	/**
	 * Setter du m�decin
	 * @param unMedecin nouveau m�decin
	 */
	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}

	/**
	 * Getter du visiteur
	 * @return visiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	/**
	 * Setter du visiteur
	 * @param unVisiteur nouveau visiteur
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	
}
