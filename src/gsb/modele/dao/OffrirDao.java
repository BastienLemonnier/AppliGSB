package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class OffrirDao {
	
	public static Offrir rechercher(String matricule)
	{
		Offrir uneOffre = null;
		Medicament unMedoc = null;
		Visite uneVisite = null;
		String req = "SELECT * FROM OFFRIR where";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		
		try {
			if(resultat.next())
			{
				int qteOfferte = resultat.getInt(1);
				Visite uneVisite1 = VisiteDao.rechercher(resultat.getString(2));
				Medicament unMedoc1 = MedicamentDao.rechercher(resultat.getString(3));
				
				uneOffre = new Offrir(unMedoc1, uneVisite1, qteOfferte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uneOffre;
	}
	

}
