package gsb.service;

import java.util.TreeMap;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import gsb.utils.ServiceUtils;

public class OffrirService {
	
	public static Offrir rechercher(String matricule)
	{
		Offrir uneOffre =  null;
		try {
			if(matricule == null || matricule.length() == 0)
				throw new Exception("Donnée obligatoire : code");
			if(!ServiceUtils.isAMatricule(matricule))
				throw new Exception("Le matricule ne respecte pas le format A00...");
			uneOffre = OffrirDao.rechercher(matricule);
		}
		catch(Exception e)
		{
			System.out.println( e.getMessage());
		}
		return uneOffre;
	}
	
	public static void inserer(Offrir uneOffre)
	{
		try
		{
			if(!OffrirDao.insert(uneOffre))
			{
				throw new Exception("Echec de l'insertion de l'offre.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static TreeMap<String, Offrir> rechercherOffresVisite(String reference)
	{
		return OffrirDao.retournerOffresVisite(VisiteDao.rechercher(reference));
	}

}
