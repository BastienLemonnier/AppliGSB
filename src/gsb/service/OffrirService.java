package gsb.service;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;

public class OffrirService {
	
	public static Offrir rechercher(String matricule)
	{
		Offrir uneOffre =  null;
		try {
		if(matricule == null)
		{
			throw new Exception("Donnée obligatoire : code");
		}
			uneOffre = OffrirDao.rechercher(matricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneOffre;
	}

}
