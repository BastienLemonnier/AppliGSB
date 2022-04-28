/**
 *
 * Créé le 7 oct. 2021
 *
 */
package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.TreeMap;

import gsb.modele.Localite;
import gsb.modele.Visite;

/**
 * @author LEMONNIER Bastien
 * 7 oct. 2021
 *
 */
public class LocaliteDao {
	
	public static Localite rechercher(String codeLocalite){
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));	
			}
		} catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}
	
	public static TreeMap<String, Localite>dicoLocalites()
	{
		TreeMap<String, Localite> dicoLocalites = new TreeMap<String, Localite>();
		
		String req = "SELECT * FROM LOCALITE;";
		ResultSet results = ConnexionMySql.execReqSelection(req);
		
		try {
			while(results.next())
			{
				String codePostal = results.getString(1);
				String nomVille = results.getString(2);
				Localite uneLocalite = new Localite(codePostal, nomVille);
				dicoLocalites.put(codePostal, uneLocalite);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dico visites.");
		}
		
		return dicoLocalites;
	}
	
}
