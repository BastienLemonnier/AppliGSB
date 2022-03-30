package gsb.service;

import java.util.TreeMap;

import gsb.modele.Offrir;
import gsb.modele.Stocker;
import gsb.modele.Visite;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.StockerDao;
import gsb.utils.ServiceUtils;

public class OffrirService {
	
	/*private static Offrir rechercher(String matricule)
	{
		Offrir uneOffre =  null;
		try {
			if(matricule == null || matricule.length() == 0)
				throw new Exception("Donn�e obligatoire : code");
			if(!ServiceUtils.isAMatricule(matricule))
				throw new Exception("Le matricule ne respecte pas le format A00...");
			uneOffre = OffrirDao.rechercher(matricule);
		}
		catch(Exception e)
		{
			System.out.println( e.getMessage());
		}
		return uneOffre;
	}*/
	
	public static boolean inserer(Offrir uneOffre)
	{
		boolean success = true;
		try
		{
			if(getNombreOffresVisite(uneOffre.getUneVisite()) >= 2 && !OffrirDao.offreExists(uneOffre.getUnMedicament().getDepotLegal(), uneOffre.getUneVisite().getReference()))
				throw new Exception("Vous avez d�j� offert le nombre maximal de m�dicaments.");
			if(uneOffre.getUnMedicament() == null || uneOffre.getUneVisite() == null || uneOffre.getQteOfferte() == 0)
				throw new Exception("Aucun champ ne peut �tre null ou �gal � 0.");
			int stock = StockerService.getStock(uneOffre.getUneVisite().getUnVisiteur().getMatricule(), uneOffre.getUnMedicament().getDepotLegal());
			if( stock < uneOffre.getQteOfferte())
			{
				System.out.println("Il y a " + stock + " " + uneOffre.getUnMedicament().getNomCommercial() + " dans les stocks de " + uneOffre.getUneVisite().getUnVisiteur().getNom() + " " + uneOffre.getUneVisite().getUnVisiteur().getPrenom());
				throw new Exception("Vous voulez donner plus de m�dicaments qu'il n'y en a de disponible dans vos stocks.");
			}
			if(!StockerDao.retirer(new Stocker(uneOffre.getQteOfferte(), uneOffre.getUneVisite().getUnVisiteur(), uneOffre.getUnMedicament())))
				throw new Exception("Echec du retrait du stock de medicaments.");
			if(!OffrirDao.ajoutStock(uneOffre))
				throw new Exception("Echec de l'insertion de l'offre.");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
	
	public static TreeMap<String, Offrir> rechercherOffresVisite(Visite uneVisite)
	{
		TreeMap<String, Offrir> lesOffres = new TreeMap<String, Offrir>();
		try
		{
			if(uneVisite == null)
				throw new Exception("La visite ne peut pas �tre null.");
			if(!ServiceUtils.isAReference(uneVisite.getReference()))
				throw new Exception("La r�f�rence ne correspond pas au format v0000");
			lesOffres = OffrirDao.retournerOffresVisite(uneVisite);
		}
		catch(Exception e)
		{
			
		}
		return lesOffres;
	}
	
	private static int getNombreOffresVisite(Visite uneVisite)
	{
		int nmb = 0;
		try
		{
			if(uneVisite == null)
				throw new Exception("La visite ne peut pas �tre null.");
			if(!ServiceUtils.isAReference(uneVisite.getReference()))
				throw new Exception("La r�f�rence ne correspond pas au form v0000");
			nmb = OffrirDao.nombreOffresVisite(uneVisite);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return nmb;
	}

}
