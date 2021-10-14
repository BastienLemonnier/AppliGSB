/**
 *
 * Créé le 7 oct. 2021
 *
 */
package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class VisiteurDao {

	public static Visiteur rechercher(String matricule)
	{
		Visiteur unVisiteur = null;
		String req = "SELECT * FROM Visiteur WHERE MATRICULE = '" + matricule + "' LIMIT 1;";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		
		try {
			if(resultat.next())
			{
				String nom = resultat.getString(2);
				String prenom = resultat.getString(3);
				String login = resultat.getString(4);
				String mdp = resultat.getString(5);
				String adresse = resultat.getString(6);
				String codePostal = resultat.getString(7);
				String telephone = resultat.getString(8);
				Localite laLocalite = LocaliteDao.rechercher(codePostal);
				String dateEntree = resultat.getString(9);
				int prime = resultat.getInt(10);
				String codeUnite = resultat.getString(11);
				String nomUnite = resultat.getString(12);
				
				unVisiteur = new Visiteur(matricule, nom, prenom, login, mdp, adresse, laLocalite, telephone, dateEntree, prime, codeUnite, nomUnite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return unVisiteur;
	}
	
}
