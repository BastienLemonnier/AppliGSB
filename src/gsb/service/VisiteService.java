/**
 *
 * Créé le 22 oct. 2021
 *
 */
package gsb.service;

import java.util.TreeMap;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

/**
 * @author LEMONNIER Bastien
 * 22 oct. 2021
 *
 */
public class VisiteService {
	
	public static Visite rechercherVisite(String reference)
	{
		Visite uneVisite = null;
		try
		{
			uneVisite = VisiteDao.rechercher(reference);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}
	
	public static void ajouterVisite(Visite uneVisite)
	{
		try
		{
			if(uneVisite.getReference() == null || uneVisite.getDate() == null || uneVisite.getCommentaire() == null || uneVisite.getUnMedecin() == null || uneVisite.getUnVisiteur() == null)
			{
				throw new Exception("Aucun paramètre ne peut être null !");
			}
			if(uneVisite.getReference().length() != 5)
			{
				throw new Exception("La référence doit faire 5 caractères.");
			}
			if(uneVisite.getDate().length() != 10)
			{
				throw new Exception("La date doit faire 10 caractères.");
			}
			if(uneVisite.getCommentaire().length() > 100)
			{
				throw new Exception("Le commentaire doit faire moins de 100 caractères.");
			}
			
			if(VisiteDao.ajouter(uneVisite) == false)
			{
				throw new Exception("Erreur lors de l'ajout de la visite en base !");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void majVisite(Visite uneVisite)
	{
		try
		{
			if(uneVisite.getReference() == null || uneVisite.getDate() == null || uneVisite.getCommentaire() == null || uneVisite.getUnMedecin() == null || uneVisite.getUnVisiteur() == null)
			{
				throw new Exception("Aucun paramètre ne peut être null !");
			}
			if(uneVisite.getReference().length() != 5)
			{
				throw new Exception("La référence doit faire 5 caractères.");
			}
			if(uneVisite.getDate().length() != 10)
			{
				throw new Exception("La date doit faire 10 caractères.");
			}
			if(uneVisite.getCommentaire().length() > 100)
			{
				throw new Exception("Le commentaire doit faire moins de 100 caractères.");
			}
			
			if(VisiteDao.update(uneVisite) == false)
			{
				throw new Exception("Erreur lors de l'update de la visite en base !");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static TreeMap<String,Visite> rechercherListeVisites(String matricule, String date)
	{
		if(matricule == "" || matricule == null)
		{
			matricule = "%";
		} else {
			matricule = "%" + matricule + "%";
		}
		if(date == "" || date == null)
		{
			date = "%";
		} else {
			date = "%" + date + "%";
		}
		return VisiteDao.retournerListeVisites(matricule, date);
	}
	
}
