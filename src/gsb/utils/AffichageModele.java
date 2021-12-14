/**
 *
 * Créé le 25 oct. 2021
 *
 */
package gsb.utils;

import gsb.modele.Stocker;
import gsb.modele.Visite;

/**
 * @author LEMONNIER Bastien
 * 25 oct. 2021
 *
 */
public class AffichageModele {
	
	public static void afficher(Visite uneVisite)
	{
		System.out.println("Visite : " + uneVisite.getReference());
	}
	
	public static void afficher(Stocker unStock)
	{
		System.out.println("STOCK ----- Matricule : " + unStock.getUnVisiteur().getMatricule() + " | Quantité : " + unStock.getQteStock() + " | Dépôt Légal : " + unStock.getUnMedicament().getDepotLegal());
	}
	
}
