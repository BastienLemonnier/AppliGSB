/**
 *
 * Créé le 22 oct. 2021
 *
 */
package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.ServiceUtils;

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
			if(matricule == null)
				throw new Exception("donnée obligatoire : matricule");
			if(!ServiceUtils.isAMatricule(matricule))
				throw new Exception("Le matricule ne correspond pas au format X000.");
			
			unVisiteur = VisiteurDao.rechercher(matricule);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return unVisiteur;
	}
	
}
