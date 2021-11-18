/*
 * Cr�� le 07 oct. 2021
 *
 */
package gsb.modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author LEMONNIER Bastien
 * 07 oct. 2021
 */
public class ConnexionMySql {
	
	static Connection cnx;
	
	public ConnexionMySql(){
		cnx = null;
	}
	
	/**
	 * methode qui permet la connexion � la base de donn�es
	 */
	public static void connecterBd(){
		String url = "jdbc:mysql://192.178.1.13:3306/GSB"; // url : chaine de connexion
		//String url = "jdbc:mysql://localhost/GSB";
		// try permet d'essayer de lancer la connexion
		try {Class.forName("com.mysql.cj.jdbc.Driver");
			cnx = DriverManager.getConnection(url,"gsbAppli","password"); 
		} 
		// si la connexion echoue un message d'erreur est affich�
        catch(Exception e) {  System.out.println("Echec lors de la connexion");  } 

	}

	
	/**
	 * @param laRequete requ�te SQL de type SELECT
	 * @return un curseur qui contient les lignes obtenues lors de l'ex�cution de la requ�te, null sinon
	 */
	public static ResultSet execReqSelection(String laRequete){ 
		connecterBd();
		ResultSet resultatReq = null;
		try {
				Statement requete = cnx.createStatement(); 
				resultatReq =requete.executeQuery(laRequete); 
		} 
		catch(Exception e) {  System.out.println("Erreur requete : "+laRequete);  }
		return resultatReq;	
	}
	
	/**
	 * @param laRequete requ�te SQL de type INSERT, UPDATE ou DELETE
	 * @return 1 si la MAJ s'est bien d�roul�e, 0 sinon
	 */
	public static int execReqMaj(String laRequete){
		connecterBd();
		int nbMaj =0;
		try {
		Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        nbMaj = s.executeUpdate(laRequete);
        s.close();}
		catch (Exception er) {
			er.printStackTrace(); 
			System.out.println("echec requ�te : "+laRequete); }
		return nbMaj;       
	}
	
	/**
	 * attention : tant que la connexion n'est pas ferm�e, 
	 * les MAJ ne sont pas effectives, on reste en mode d�connect�
	 */
	public static void fermerConnexionBd(){
		try{cnx.close();}
		catch(Exception e) {  System.out.println("Erreur sur fermeture connexion");  } 
	}

}
