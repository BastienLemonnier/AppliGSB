package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {

	public static ArrayList<Stocker> rechercherLesStocks(String matricule)
	{
		ArrayList<Stocker> lesStocks = new ArrayList<Stocker>();
		
		String req = "SELECT * FROM STOCKER WHERE MATRICULE ='" + matricule + "';";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		Visiteur unVisiteur = VisiteurDao.rechercher(matricule);
	
		try
		{
			while(resultat.next()) 
			{
				int QteStock = resultat.getInt(1);
				Stocker unStock = null;
				Medicament unMedoc = null;
				unMedoc = MedicamentDao.rechercher(resultat.getString(3));
				unStock = new Stocker(QteStock, unVisiteur, unMedoc);
				lesStocks.add(unStock);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lesStocks;
	}
	
	public static boolean ajouter(Stocker unStock)
	{
		boolean success = false;
		int stockActuel = getQuantite(unStock.unVisiteur.getMatricule(), unStock.getUnMedicament().getDepotLegal());
		
		if(stockActuel == 0)
		{
			String req = "INSERT INTO STOCKER VALUES ('" + unStock.getQteStock() + "','" + unStock.getUnVisiteur().getMatricule() + "','" + unStock.getUnMedicament().getDepotLegal() + "')";
			if(ConnexionMySql.execReqMaj(req) == 1)
				success = true;
		}
		else
		{
			int nouvQtt = stockActuel + unStock.getQteStock();
			String req = "UPDATE STOCKER SET QTTSTOCK='" + nouvQtt + "' WHERE MATRICULE ='" + unStock.unVisiteur.getMatricule() + "' AND MED_DEPOTLEGAL = '" + unStock.unMedicament.getDepotLegal() + "' LIMIT 1;";
			if(ConnexionMySql.execReqMaj(req) == 1)
				success = true;
		}
		
		return success;
	}
	
	private static int getQuantite(String matricule, String depotLegal)
	{
		int qtt = 0;
		
		String req = "SELECT QTTSTOCK FROM STOCKER WHERE MATRICULE ='" + matricule + "' AND MED_DEPOTLEGAL = '" + depotLegal + "' LIMIT 1;";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
		
		try
		{
			if(resultat.next()) 
			{
				qtt = resultat.getInt(1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return qtt;
	}
	
	public static boolean retirer(Stocker unStock)
	{
		boolean success = false;
		int stockActuel = getQuantite(unStock.unVisiteur.getMatricule(), unStock.getUnMedicament().getDepotLegal());
		
		if(stockActuel > unStock.getQteStock())
		{
			int nouvQtt = stockActuel - unStock.getQteStock();
			String req = "UPDATE STOCKER SET QTTSTOCK='" + nouvQtt + "' WHERE MATRICULE ='" + unStock.unVisiteur.getMatricule() + "' AND MED_DEPOTLEGAL = '" + unStock.unMedicament.getDepotLegal() + "' LIMIT 1;";
			if(ConnexionMySql.execReqMaj(req) == 1)
				success = true;
		}
		else if(stockActuel - unStock.getQteStock() == 0)
		{
			String req = "DELETE FROM STOCKER WHERE MATRICULE ='" + unStock.unVisiteur.getMatricule() + "' AND MED_DEPOTLEGAL = '" + unStock.unMedicament.getDepotLegal() + "' LIMIT 1;";
			if(ConnexionMySql.execReqMaj(req) == 1)
				success = true;
		}
		
		return success;
	}

	/**
	 * @param unVisiteur
	 * @param unMedicament
	 * @return quantité du stock de médicaments
	 */
	public static int getStock(Visiteur unVisiteur, Medicament unMedicament) {
		int stock = 0;
		String req = "SELECT QTTSTOCK FROM STOCKER WHERE MATRICULE='" + unVisiteur.getMatricule() + "' AND MED_DEPOTLEGAL='" + unMedicament.getDepotLegal() + "';";
		ResultSet results = ConnexionMySql.execReqSelection(req);
		try {
			if(results.next()) {
				stock = results.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la requête : " + req);
			e.printStackTrace();
		}
		return stock;
	}
	
}
