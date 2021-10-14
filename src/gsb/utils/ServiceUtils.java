/**
 *
 * Créé le 14 oct. 2021
 *
 */
package gsb.utils;

/**
 * @author LEMONNIER Bastien
 * 14 oct. 2021
 *
 */
public class ServiceUtils {
	
	public static boolean isStringNumeric(String uneChaine)
	{
		boolean isNumeric = true;
		
		for(int i = 0; i < uneChaine.length(); i ++)
		{
			char unChar = uneChaine.charAt(i);
			if(!(unChar >= '0' && unChar <= '9'))
			{
				isNumeric = false;
			}
		}
		
		return isNumeric;
	}
	
}
