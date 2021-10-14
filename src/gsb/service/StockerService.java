package gsb.service;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class StockerService {

	public static Stocker rechercher(String matricule)
	{
		Stocker unStock =  null;
		try {
		if(matricule == null)
		{
			throw new Exception("Donnée obligatoire : code");
		}
			unStock = StockerDao.rechercher(matricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unStock;
	}
}
