package gsb.modele;

/**
 * 
 * @author PAJOT Arthur
 * 7 oct. 2021
 */
public class Medicament {
	/**
	 * depot de medicament
	 */
	protected String depotLegal;
	/**
	 * nom commercial des medicament
	 */
	protected String nomCommercial;
	/**
	 * composition des médicaments
	 */
	protected String composition;
	/**
	 * effets des médicament
	 */
	protected String effets;
	/**
	 * prix des échantillons
	 */
	protected float prixEchantillon;
	/**
	 * code de la famille du medicament
	 */
	protected String codeFamille;
	/**
	 * nom des familles
	 */
	protected String libelleFamille;
	
	/**
	 * Constructeur du medicament
	 * @param depotLegal
	 * @param nomCommercial
	 * @param composition
	 * @param effets
	 * @param prixEchantillon
	 * @param codeFamille
	 * @param libelleFamille
	 */
	public Medicament(String depotLegal, String nomCommercial, String composition, String effets, float prixEchantillon,
			String codeFamille, String libelleFamille) {
		super();
		this.depotLegal = depotLegal;
		this.nomCommercial = nomCommercial;
		this.composition = composition;
		this.effets = effets;
		this.prixEchantillon = prixEchantillon;
		this.codeFamille = codeFamille;
		this.libelleFamille = libelleFamille;
	}

	/**
	 * Getter du depot legal
	 * @return depot legal
	 */
	public String getDepotLegal() {
		return depotLegal;
	}

	/**
	 * setter du depot legal
	 * @param depotLegal
	 */
	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}

	/**
	 * getter du nom commercial
	 * @return nom commercial
	 */
	public String getNomCommercial() {
		return nomCommercial;
	}

	/**
	 * setter du nom commercial
	 * @param nomCommercial
	 */
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}

	/**
	 * getter de la composition
	 * @return composition
	 */
	public String getComposition() {
		return composition;
	}

	/**
	 * setter de la coposition
	 * @param composition
	 */
	public void setComposition(String composition) {
		this.composition = composition;
	}

	/**
	 * getter des effets
	 * @return effets
	 */
	public String getEffets() {
		return effets;
	}
	
	/**
	 * setter des effets
	 * @param effets
	 */
	public void setEffets(String effets) {
		this.effets = effets;
	}

	/**
	 * getter des prix d'echantillons
	 * @return prixEchantillon
	 */
	public float getPrixEchantillon() {
		return prixEchantillon;
	}

	/**
	 * setter des prix echantillons
	 * @param prixEchantillon
	 */
	public void setPrixEchantillon(float prixEchantillon) {
		this.prixEchantillon = prixEchantillon;
	}

	/**
	 * getter du code famille
	 * @return codeFamille 
	 */
	public String getCodeFamille() {
		return codeFamille;
	}

	/**
	 * setter de code famille
	 * @param codeFamille
	 */
	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	/**
	 * getter du libelle de la famille
	 * @return libelleFamille
	 */
	public String getLibelleFamille() {
		return libelleFamille;
	}

	/**
	 * setter du libelle de la famille
	 * @param libelleFamille
	 */
	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
	
	
}
