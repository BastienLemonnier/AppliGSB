/**
 *
 * Cr�� le 14 oct. 2021
 *
 */
package gsb.tests.utils;

import gsb.utils.ServiceUtils;

/**
 * @author LEMONNIER Bastien
 * 14 oct. 2021
 *
 */
public class ServiceUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String num1 = "07494";
		System.out.println(ServiceUtils.isStringNumeric(num1));
		String num2 = "67G90";
		System.out.println(ServiceUtils.isStringNumeric(num2));
	}

}
