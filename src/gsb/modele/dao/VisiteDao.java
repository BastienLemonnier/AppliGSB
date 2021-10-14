/**
 *
 * Créé le 14 oct. 2021
 *
 */
package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

/**
 * @author LEMONNIER Bastien
 * 14 oct. 2021
 *
 */
public class VisiteDao {
	
	public static Visite rechercher(String reference)
	{
		Visite uneVisite = null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		
		String req = "SELECT * FROM Visite WHERE REFERENCE = " + reference + ";";
		ResultSet results = ConnexionMySql.execReqSelection(req);
		
		try {
			if(results.next())
			{
				String dateVisite = results.getString(2);
				String commentaire = results.getString(3);
				unMedecin = MedecinDao.rechercher(results.getString(5));
				unVisiteur = VisiteurDao.rechercher(results.getString(4));
				uneVisite = new Visite(reference, dateVisite, commentaire, unMedecin, unVisiteur);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uneVisite;
	}
	
}
