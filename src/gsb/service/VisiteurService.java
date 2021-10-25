/**
 *
 * Créé le 22 oct. 2021
 *
 */
package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

/**
 * @author LEMONNIER Bastien
 * 22 oct. 2021
 *
 */
public class VisiteurService {
	
	public static Visiteur rechercherVisiteur(String matricule)
	{
		Visiteur unVisiteur = null;
		try
		{
			if(matricule == null || matricule.length() == 0)
			{
				throw new Exception("donnée obligatoire : matricule");
			}
			unVisiteur = VisiteurDao.rechercher(matricule);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return unVisiteur;
	}
	
}
