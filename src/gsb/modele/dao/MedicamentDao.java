package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import gsb.modele.Medicament;

public class MedicamentDao {
	
	public static Medicament rechercher(String depotLegal) {
		
		Medicament unMedoc = null;
		String req = "SELECT * FROM MEDICAMENT WHERE MED_DEPOTLEGAL =" + depotLegal;
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		
		try {
			if(resultat.next())
			{
				String nomCom = resultat.getString(2);
				String compo = resultat.getString(3);
				String effets = resultat.getString(4);
				String contreIndic = resultat.getString(5);
				float prixEchant = resultat.getFloat(6);
				String code = resultat.getString(7);
				String libelle = resultat.getString(8);
				
				unMedoc = new Medicament(depotLegal, nomCom, compo, effets, prixEchant, code, libelle);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return unMedoc;
	}
	
}
