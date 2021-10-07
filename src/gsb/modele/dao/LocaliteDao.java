/**
 *
 * Cr�� le 7 oct. 2021
 *
 */
package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;

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
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}
	
}
