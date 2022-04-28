/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.utils.ServiceUtils;

/**
 * @author Isabelle
 * 23 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try {
			if (unCodeMedecin == null)
	            throw new Exception("Donn�e obligatoire : code");
			if(!ServiceUtils.isACodeMed(unCodeMedecin))
				throw new Exception("Le code m�decin ne correspond pas au format M000.");
			
			unMedecin = MedecinDao.rechercher(unCodeMedecin);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedecin;
	}
	
	public static TreeMap<String, Medecin> recupListe()
	{
		HashMap<String, Medecin> lesMedecinsDesor = MedecinDao.retournerDictionnaireDesMedecins();
		TreeMap<String, Medecin> lesMedecins = new TreeMap<String, Medecin>();
		
		for (Map.Entry<String, Medecin> uneEntree : lesMedecinsDesor.entrySet())
		{
			String codeMed = uneEntree.getKey();
			Medecin leMedecin = uneEntree.getValue();
			lesMedecins.put(codeMed, leMedecin);
		}
		
		return lesMedecins;
	}
	
	public static boolean ajouterMedecin(Medecin unMedecin) {
			boolean success = false;
			try
			{
				if(rechercherMedecin(unMedecin.getCodeMed()) != null)
					throw new Exception("Le code m�decin ne correspond pas au format M000 ou ce code m�decin existe deja");
				MedecinDao.addMedecin(unMedecin);
				success = true;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return success;
	}
	
}
