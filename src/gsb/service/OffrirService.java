package gsb.service;

import java.util.TreeMap;

import gsb.modele.Offrir;
import gsb.modele.Stocker;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.StockerDao;
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
	
	public static boolean inserer(Offrir uneOffre)
	{
		boolean success = true;
		try
		{
			if(uneOffre.getUnMedicament() == null || uneOffre.getUneVisite() == null || uneOffre.getQteOfferte() == 0)
				throw new Exception("Aucun champ ne peut être null ou égal à 0.");
			if(StockerService.getStock(uneOffre.getUneVisite().getUnVisiteur().getMatricule(), uneOffre.getUnMedicament().getDepotLegal()) >= uneOffre.getQteOfferte())
				throw new Exception("Vous voulez donner plus de médicaments qu'il n'y en a de disponible dans vos stocks.");
			if(!StockerDao.retirer(new Stocker(uneOffre.getQteOfferte(), uneOffre.getUneVisite().getUnVisiteur(), uneOffre.getUnMedicament())))
				throw new Exception("Echec du retrait du stock de medicaments.");
			if(!OffrirDao.insert(uneOffre))
				throw new Exception("Echec de l'insertion de l'offre.");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
	
	public static TreeMap<String, Offrir> rechercherOffresVisite(String reference)
	{
		return OffrirDao.retournerOffresVisite(VisiteDao.rechercher(reference));
	}

}
