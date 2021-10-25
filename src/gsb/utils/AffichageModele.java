/**
 *
 * Créé le 25 oct. 2021
 *
 */
package gsb.utils;

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
	
}
