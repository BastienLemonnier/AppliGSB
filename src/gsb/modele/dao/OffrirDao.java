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
	
	public static boolean insert(Offrir uneOffre)
	{
		boolean success = false;
		
		String req = "INSERT INTO OFFRIR VALUES ('" + uneOffre.getQteOfferte() + "','" + uneOffre.getUneVisite().getReference() + "','" + uneOffre.getUnMedicament().getDepotLegal() + "');";
		
		if(ConnexionMySql.execReqMaj(req) == 1)
			success = true;
		
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
	
	public static int nombreOffresVisite(Visite uneVisite)
	{
		int nmb = 0;
		String req = "SELECT COUNT(*) FROM OFFRIR WHERE REFERENCE = '" + uneVisite.getReference() + "';";
		ResultSet results = ConnexionMySql.execReqSelection(req);
		try {
			if(results.next())
			{
				nmb = results.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la requête : " + req);
			e.printStackTrace();
		}
		return nmb;
	}

}
