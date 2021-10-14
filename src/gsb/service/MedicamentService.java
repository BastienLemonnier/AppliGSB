package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	
	public static Medicament rechercher(String depotLegal)
	{
		Medicament unMedoc =  null;
		try {
		if(depotLegal == null)
		{
			throw new Exception("Donnée obligatoire : code");
		}
			unMedoc = MedicamentDao.rechercher(depotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedoc;
	}

}
