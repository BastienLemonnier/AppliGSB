package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

public class OffrirDao {
	
	public static Offrir rechercher(String depotLegal)
	{
		Offrir uneOffre = null;
		Medicament unMedoc = null;
		Visite uneVisite = null;
		String req = "SELECT * FROM OFFRIR where MED_DEPOTLEGAL = '" + depotLegal + "';";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		
		try {
			if(resultat.next())
			{
				int qteOfferte = resultat.getInt(1);
				uneVisite = VisiteDao.rechercher(resultat.getString(2));
				unMedoc = MedicamentDao.rechercher(resultat.getString(3));
				
				uneOffre = new Offrir(unMedoc, uneVisite, qteOfferte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uneOffre;
	}
	
	public static int insert(Offrir uneOffre)
	{
		int success = 0;
		
		String req = "INSERT INTO OFFRIR VALUES ('" + uneOffre.getQteOfferte() + "','" + uneOffre.getUneVisite().getReference() + "','" + uneOffre.getUnMedicament().getDepotLegal() + "');";
		
		success = ConnexionMySql.execReqMaj(req);
		
		return success;
	}
	
	public static TreeMap<String, Offrir> retournerOffresVisite(Visite laVisite)
	{
		TreeMap<String, Offrir> lesOffres = new TreeMap<String, Offrir>();
		
		String req = "SELECT * FROM OFFRIR WHERE REFERENCE = '" + laVisite.getReference() + "';";
		ResultSet results = ConnexionMySql.execReqSelection(req);
		
		try {
			while(results.next())
			{
				int quantite = results.getInt(1);
				Medicament leMedicament = MedicamentDao.rechercher(results.getString(3));
				Offrir offre = new Offrir(leMedicament, laVisite, quantite);
				lesOffres.put(leMedicament.getDepotLegal(), offre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur retourner offres visite.");
		}
		
		return lesOffres;
	}

}
