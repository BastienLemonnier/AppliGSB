package gsb.modele;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class Localite {
	
	/**
	 * Code Postal de la Localite
	 */
	protected String codePostal;
	/**
	 * Ville de la Localite
	 */
	protected String ville;
	
	/**
	 * Constructeur de la Localite
	 * @param codePostal Code Postal
	 * @param ville Ville
	 */
	public Localite(String codePostal, String ville) {
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Getter du code postal
	 * @return code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter du code postal
	 * @param codePostal nouveau code postal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * Getter de la ville
	 * @return nom de la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de la ville
	 * @param ville nouveau nom de ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
