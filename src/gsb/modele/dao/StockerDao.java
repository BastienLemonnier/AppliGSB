package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {

	public static Stocker rechercher(String matricule)
	{
		Stocker unStock = null;
		Medicament unMedoc = null;
		Visiteur unVisiteur = null;
		String req = "SELECT * FROM STOCKER where";
		ResultSet resultat = ConnexionMySql.execReqSelection(req);
	
		try {
			if(resultat.next()) 
			{
				int QteStock = resultat.getInt(1);
				unVisiteur = VisiteurDao.rechercher(resultat.getString(2));
				unMedoc = MedicamentDao.rechercher(resultat.getString(3));
				unStock = new Stocker(QteStock, unVisiteur, unMedoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return unStock;
	}
}
