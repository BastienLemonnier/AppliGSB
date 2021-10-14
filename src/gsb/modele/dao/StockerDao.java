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
				Visiteur unVisiteur1 = VisiteurDao.rechercher(resultat.getString(2));
				Medicament unMedoc1 = MedicamentDao.rechercher(resultat.getString(3));
				unStock = new Stocker(QteStock, unVisiteur1, unMedoc1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return unStock;
	}
}
